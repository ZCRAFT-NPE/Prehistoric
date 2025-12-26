package com.wiyuka.prehistoric;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

@EventBusSubscriber
public class CommonEvents {
    private static final SimpleCommandExceptionType ERROR_FAILED = new SimpleCommandExceptionType(Component.translatable("commands.save.failed"));

    @SubscribeEvent
    public static void serverTick(ServerTickEvent.Post event)  {
        MinecraftServer minecraftserver = event.getServer();
        boolean flag = minecraftserver.saveEverything(true, true, true);

    }
}
