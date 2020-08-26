package com.vandendaelen.pollinator;

import com.vandendaelen.pollinator.config.PollinatorConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.vandendaelen.pollinator.Pollinator.MOD_ID;

@Mod(MOD_ID)
public class Pollinator {

    public static final String MOD_ID = "pollinator";
    public static final Logger LOGGER = LogManager.getLogger();

    public Pollinator() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PollinatorConfig.COMMON_CONFIG);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
