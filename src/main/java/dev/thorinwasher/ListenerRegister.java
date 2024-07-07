package dev.thorinwasher;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.GameMode;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.InstanceContainer;

public class ListenerRegister {
    private ListenerRegister() {
        throw new IllegalStateException("Utility class");
    }

    public static void registerAllListeners(InstanceContainer instanceContainer) {
        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, (event) -> {
            event.setSpawningInstance(instanceContainer);
            event.getPlayer().setGameMode(GameMode.CREATIVE);
            event.getPlayer().setRespawnPoint(new Pos(0, 40, 0));
        });
    }
}
