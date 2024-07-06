package dev.thorinwasher.entity.goal;

import dev.thorinwasher.entity.BaseEntity;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.utils.NamespaceID;

import java.util.Random;

public class LookAround implements Goal {

    private final BaseEntity baseEntity;
    private static final Random RANDOM = new Random();
    private final float targetYaw;
    private static final float MAX_LOOKAROUND_STEP = (float) (Math.PI / 20);

    public LookAround(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
        this.targetYaw = RANDOM.nextFloat(0F, (float) (2F*Math.PI));
    }

    @Override
    public void tick() {
        Pos pos = baseEntity.getPosition();
        float currentYaw = (float) ((pos.yaw() + 2*Math.PI) % Math.PI*2);
        float currentPitch = pos.pitch();
        if (Math.abs(targetYaw - currentYaw) <= MAX_LOOKAROUND_STEP*2) {
            baseEntity.setView(targetYaw, currentPitch);
            return;
        }
        if (targetYaw < currentYaw) {
            baseEntity.setView(currentYaw - MAX_LOOKAROUND_STEP, currentPitch);
            return;
        }
        baseEntity.setView(currentYaw + MAX_LOOKAROUND_STEP, currentPitch);
    }

    @Override
    public boolean isCompleted() {
        Pos pos = baseEntity.getPosition();
        float currentYaw = pos.yaw();
        return targetYaw == currentYaw;
    }

    @Override
    public NamespaceID key() {
        return null;
    }


}
