package com.github.tacowasa059.displaydistancemod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Displaydistancemod.MODID)
public class Displaydistancemod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "displaydistancemod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    @SuppressWarnings("removal")
    public Displaydistancemod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DDConfig.COMMON_SPEC);
    }

}
