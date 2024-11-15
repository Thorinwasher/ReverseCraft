package dev.thorinwasher.entity.behavior;

import com.google.gson.JsonObject;
import dev.thorinwasher.entity.BaseEntity;
import dev.thorinwasher.entity.goal.AnyAttack;
import dev.thorinwasher.entity.goal.Flee;
import dev.thorinwasher.entity.goal.Goal;
import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.Priority;

import java.util.Locale;
import java.util.function.Function;

public class SelfPreservation implements Behavior {
    private final RunAwayOption runAway;
    private final NamespaceID key;

    private SelfPreservation(RunAwayOption runAway, NamespaceID key) {
        this.runAway = runAway;
        this.key = key;
    }

    public static SelfPreservation from(JsonObject jsonObject, NamespaceID key) {
        RunAwayOption runAway = RunAwayOption.valueOf(jsonObject.get("run_away").getAsString().toUpperCase(Locale.ROOT));

        return new SelfPreservation(runAway,key);
    }

    @Override
    public Priority getPriority(BaseEntity baseEntity) {
        return Priority.NONE;
    }

    @Override
    public Goal getGoal(BaseEntity baseEntity) {
        float healthPercentage = baseEntity.getHealth() / baseEntity.getMaxHealth();
        return runAway.getGoal(healthPercentage);
    }

    @Override
    public NamespaceID key() {
        return key;
    }

    enum RunAwayOption {
        ALWAYS(ignored -> new Flee()),
        WHEN_HP_LOW(hpPercentage -> hpPercentage < 0.05 ? new Flee() : new AnyAttack()),
        NEVER(ignored -> new AnyAttack());

        private final Function<Float, Goal> goalProvider;

        RunAwayOption(Function<Float, Goal> goalProvider) {
            this.goalProvider = goalProvider;
        }

        Goal getGoal(float hpPercentLost) {
            return goalProvider.apply(hpPercentLost);
        }
    }
}
