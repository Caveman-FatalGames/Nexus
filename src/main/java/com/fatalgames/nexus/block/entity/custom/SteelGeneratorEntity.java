package com.fatalgames.nexus.block.entity.custom;

import com.fatalgames.nexus.block.entity.ModBlockEntities;
import com.fatalgames.nexus.block.entity.energy.ModEnergyStorage;
import com.fatalgames.nexus.block.entity.energy.ModEnergyUtil;
import com.fatalgames.nexus.item.ModItems;
import com.fatalgames.nexus.screen.custom.SteelGeneratorMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class SteelGeneratorEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private static final int INPUT_SLOT = 0;

    protected final ContainerData data;
    private int burnProgress = 160;
    private int maxBurnProgress = 160;
    private boolean isBurning = false;

    private static final int ENERGY_TRANSFER_AMOUNT = 320;

    private final ModEnergyStorage ENERGY_STORAGE = createEnergyStorage();
    private ModEnergyStorage createEnergyStorage() {
        return new ModEnergyStorage(64000, 320) {
            @Override
            public void onEnergyChanged() {
                setChanged();
                getLevel().sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        };
    }

    public SteelGeneratorEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.STEEL_GENERATOR_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> SteelGeneratorEntity.this.burnProgress;
                    case 1 -> SteelGeneratorEntity.this.maxBurnProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> SteelGeneratorEntity.this.burnProgress = pValue;
                    case 1 -> SteelGeneratorEntity.this.maxBurnProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public IEnergyStorage getEnergyStorage(@Nullable Direction direction) {
        return this.ENERGY_STORAGE;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Coal Generator");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new SteelGeneratorMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if(hasFuelItemInSlot()) {
            if(!isBurningFuel()) {
                startBurning();
            }
        }

        if(isBurningFuel()) {
            increaseBurnTimer();
            if(currentFuelDoneBurning()) {
                resetBurning();
            }
            fillUpOnEnergy();
        }

        pushEnergyToNeighbourAbove();
    }

    private void pushEnergyToNeighbourAbove() {
        if(ModEnergyUtil.doesBlockHaveEnergyStorage(this.worldPosition.above(), this.level)) {
            ModEnergyUtil.move(this.worldPosition, this.worldPosition.above(), 320, this.level);
        }
    }

    private static final Set<Item> VALID_FUELS = Set.of(
            Items.COAL,
            Items.CHARCOAL,
            Items.COAL_BLOCK,
            Items.LAVA_BUCKET,
            ModItems.TERRESTRIAL_COAL.get()

    );

    private boolean hasFuelItemInSlot() {
        return VALID_FUELS.contains(this.itemHandler.getStackInSlot(INPUT_SLOT).getItem());
    }

    private boolean isBurningFuel() {
        return isBurning;
    }

    private void startBurning() {
        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
        isBurning = true;
    }

    private void increaseBurnTimer() {
        this.burnProgress--;
    }

    private boolean currentFuelDoneBurning() {
        return this.burnProgress <= 0;
    }

    private void resetBurning() {
        isBurning = false;
        this.burnProgress = 160;
    }

    private void fillUpOnEnergy() {
        this.ENERGY_STORAGE.receiveEnergy(320, false);
    }


    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("steel_generator.inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("steel_generator.burn_progress", burnProgress);
        pTag.putInt("steel_generator.max_burn_progress", maxBurnProgress);

        pTag.putInt("steel_generator.energy", ENERGY_STORAGE.getEnergyStored());

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("steel_generator.inventory"));
        ENERGY_STORAGE.setEnergy(pTag.getInt("steel_generator.energy"));

        burnProgress = pTag.getInt("steel_generator.burn_progress");
        maxBurnProgress = pTag.getInt("steel_generator.max_burn_progress");
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider pRegistries) {
        super.onDataPacket(net, pkt, pRegistries);
    }


}
