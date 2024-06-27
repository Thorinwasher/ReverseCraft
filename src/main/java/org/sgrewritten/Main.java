package org.sgrewritten;

import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.LightingChunk;
import org.sgrewritten.command.CommandRegistry;
import org.sgrewritten.world.FlatWorldGenerator;

public class Main {
    public static void main(String[] args) {
        MinecraftServer minecraftServer = MinecraftServer.init();
        InstanceManager manager = MinecraftServer.getInstanceManager();
        InstanceContainer instanceContainer = manager.createInstanceContainer();

        instanceContainer.setGenerator(new FlatWorldGenerator());
        instanceContainer.setChunkSupplier(LightingChunk::new);
        instanceContainer.setTime(0);
        ListenerRegistry.registerAllListeners(instanceContainer);
        CommandManager commandManager = MinecraftServer.getCommandManager();
        CommandRegistry.registerAllCommands(commandManager);
        minecraftServer.start(System.getProperty("address", "0.0.0.0"), Integer.getInteger("port", 25565));
    }
}