package com.vandendaelen.polinator;

import com.vandendaelen.polinator.config.PolinatorConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.vandendaelen.polinator.Polinator.MOD_ID;

@Mod(MOD_ID)
public class Polinator {

    public static final String MOD_ID = "polinator";
    private static final Logger LOGGER = LogManager.getLogger();

    public Polinator() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PolinatorConfig.COMMON_CONFIG);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
