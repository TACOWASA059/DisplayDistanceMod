package com.github.tacowasa059.displaydistancemod;

import com.github.tacowasa059.displaydistancemod.config.DDConfig;
import com.github.tacowasa059.displaydistancemod.config.DDConfigCommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Displaydistancemod.MODID)
public class Displaydistancemod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "displaydistancemod";

    @SuppressWarnings("removal")
    public Displaydistancemod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DDConfig.COMMON_SPEC);

        MinecraftForge.EVENT_BUS.addListener((RegisterCommandsEvent e) ->
                DDConfigCommand.register(e.getDispatcher())
        );
    }

}
