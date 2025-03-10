package com.fatalgames.nexus.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodProperties {
    public static final FoodProperties TERRESTRIAL_FRUIT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 12000), 1f).build();

    public static final FoodProperties TERRESTRIAL_STEAK = new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 12000), 1f).build();

}
