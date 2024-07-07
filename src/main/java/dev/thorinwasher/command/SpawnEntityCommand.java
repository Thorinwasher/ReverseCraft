package dev.thorinwasher.command;

import com.google.common.base.Preconditions;
import dev.thorinwasher.Registry;
import dev.thorinwasher.entity.BaseEntity;
import dev.thorinwasher.entity.PawnType;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.ArgumentWord;
import net.minestom.server.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class SpawnEntityCommand extends Command {

    private static final Map<String, PawnType> PAWN_NAMES = loadPawnNames();


    public SpawnEntityCommand() {
        super("spawn");

        setDefaultExecutor(((commandSender, commandContext) -> {
            commandSender.sendMessage("Not enough arguments!");
        }));

        ArgumentWord entity = ArgumentType.Word("pawn-type").from(PAWN_NAMES.keySet().toArray(String[]::new));
        System.out.println(PAWN_NAMES.keySet());
        addSyntax((commandSender, commandContext) -> {
            System.out.println("ping");
            Preconditions.checkArgument(commandSender instanceof Player);
            Player player = (Player) commandSender;
            PawnType pawnType = PAWN_NAMES.get(commandContext.get(entity));
            new BaseEntity(pawnType).setInstance(player.getInstance(), player.getPosition());
        }, entity);
    }

    private static Map<String, PawnType> loadPawnNames() {
        Map<String, PawnType> pawnTypes = new HashMap<>();
        for(PawnType pawType : Registry.PAWN_TYPES.values()){
            pawnTypes.put(pawType.name(), pawType);
        }
        return pawnTypes;
    }
}
