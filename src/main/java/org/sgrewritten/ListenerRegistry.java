package org.sgrewritten;

import net.minestom.server.MinecraftServer;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.InstanceContainer;

public class ListenerRegistry {
    public static void registerAllListeners(InstanceContainer instanceContainer) {
        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, (event) -> {
            event.setSpawningInstance(instanceContainer);
        });
    }
}
