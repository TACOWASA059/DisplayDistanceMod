package com.github.tacowasa059.displaydistancemod;

import net.minecraftforge.common.ForgeConfigSpec;

public class DDConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    private static final ForgeConfigSpec.IntValue DISPLAY_RANGE_CHUNKS;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();

        DISPLAY_RANGE_CHUNKS = b
                .comment(
                        "Tracking range for Display entities (in CHUNKS).",
                        "This controls how far the server will send TextDisplay/ItemDisplay/BlockDisplay to players.",
                        "Note: The effective distance is min(this * 16, server view-distance * 16).")
                .defineInRange("displayTrackingRangeChunks", 32, 1, 512);

        COMMON_SPEC = b.build();
    }

    public static int displayRangeChunks() {
        int v = DISPLAY_RANGE_CHUNKS.get();
        if (v < 1) v = 1;
        if (v > 512) v = 512;
        return v;
    }
}