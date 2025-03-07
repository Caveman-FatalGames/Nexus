package com.fatalgames.nexus.screen;

import com.fatalgames.nexus.NexusMod;
import com.fatalgames.nexus.screen.custom.SteelForgeMenu;
import com.fatalgames.nexus.screen.custom.SteelPedestalMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, NexusMod.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<SteelPedestalMenu>> PEDESTAL_MENU =
            registerMenuType("pedestal_menu", SteelPedestalMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<SteelForgeMenu>> STEEL_FORGE_MENU =
            registerMenuType("steel_forge_menu", SteelForgeMenu::new);


    private static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                              IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
