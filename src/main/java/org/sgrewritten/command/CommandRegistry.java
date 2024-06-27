package org.sgrewritten.command;

import net.minestom.server.command.CommandManager;

public class CommandRegistry {


    public static void registerAllCommands(CommandManager commandManager) {
        commandManager.register(new SpawnEntityCommand());
    }
}
