package dev.thorinwasher.command;

import dev.thorinwasher.minestruct.command.FlipStructure;
import dev.thorinwasher.minestruct.command.LoadStructureCommand;
import dev.thorinwasher.minestruct.command.PasteStructureCommand;
import dev.thorinwasher.minestruct.command.RotateStructure;
import net.minestom.server.command.CommandManager;

public class CommandRegister {


    private CommandRegister() {
        throw new IllegalStateException("Utility class");
    }

    public static void registerAllCommands(CommandManager commandManager) {
        commandManager.register(new SpawnEntityCommand());
        commandManager.register(new LoadStructureCommand("/load"));
        commandManager.register(new PasteStructureCommand("/paste"));
        commandManager.register(new RotateStructure("/rotate"));
        commandManager.register(new FlipStructure("/flip"));
    }
}
