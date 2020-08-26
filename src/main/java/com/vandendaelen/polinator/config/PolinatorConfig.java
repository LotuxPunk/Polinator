package com.vandendaelen.polinator.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class PolinatorConfig {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static final String CATEGORY_GENERAL = "general";

    public static ForgeConfigSpec.IntValue RADIUS;
    public static ForgeConfigSpec.DoubleValue CHANCE;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("General settings").push(CATEGORY_GENERAL);

        RADIUS = COMMON_BUILDER
                .comment("Diameter of appearance of the flower around the hive")
                .defineInRange("diameter", 10,1, 30);

        CHANCE = COMMON_BUILDER
                .comment("Chance to have a flower appear when the bee has delivered its honey")
                .defineInRange("chance", 0.5, 0, 1);

        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Reloading configEvent) {
    }

}
