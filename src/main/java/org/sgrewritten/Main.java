package org.sgrewritten;

import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.LightingChunk;
import org.sgrewritten.command.CommandRegister;
import org.sgrewritten.entity.attack.Ranged;
import org.sgrewritten.world.FlatWorldGenerator;
import org.sgrewritten.world.PerlinNoiseGenerator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MinecraftServer minecraftServer = MinecraftServer.init();
        InstanceManager manager = MinecraftServer.getInstanceManager();
        InstanceContainer instanceContainer = manager.createInstanceContainer();

        instanceContainer.setGenerator(new PerlinNoiseGenerator(new Random().nextInt()));
        instanceContainer.setChunkSupplier(LightingChunk::new);
        instanceContainer.setTime(0);
        ListenerRegister.registerAllListeners(instanceContainer);
        CommandManager commandManager = MinecraftServer.getCommandManager();
        CommandRegister.registerAllCommands(commandManager);
        minecraftServer.start(System.getProperty("address", "0.0.0.0"), Integer.getInteger("port", 25565));
    }
}