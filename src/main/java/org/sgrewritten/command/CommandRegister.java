package org.sgrewritten.command;

import net.minestom.server.command.CommandManager;

public class CommandRegister {


    private CommandRegister() {
        throw new IllegalStateException("Utility class");
    }

    public static void registerAllCommands(CommandManager commandManager) {
        commandManager.register(new SpawnEntityCommand());
    }
}
