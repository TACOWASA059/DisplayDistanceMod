package com.github.tacowasa059.displaydistancemod.config;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class DDConfigCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("ddconfig")
                        .requires(src -> src.hasPermission(2)) // OPのみ
                        .then(Commands.literal("get")
                                .executes(ctx -> {
                                    int value = DDConfig.displayRangeChunks();
                                    ctx.getSource().sendSuccess(
                                            () -> Component.literal("Display tracking range = " + value + " chunks"),
                                            false
                                    );
                                    return Command.SINGLE_SUCCESS;
                                })
                        )
                        .then(Commands.literal("set")
                                .then(Commands.argument("value", IntegerArgumentType.integer(1, 512))
                                        .executes(ctx -> {
                                            int value = IntegerArgumentType.getInteger(ctx, "value");
                                            DDConfig.setDisplayRangeChunks(value);

                                            ctx.getSource().sendSuccess(
                                                    () -> Component.literal("Display tracking range set to " + value + " chunks"),
                                                    true
                                            );
                                            return Command.SINGLE_SUCCESS;
                                        })
                                )
                        )
        );
    }
}