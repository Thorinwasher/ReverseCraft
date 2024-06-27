package org.sgrewritten.entity;

import net.minestom.server.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BaseEntity extends LivingEntity {
    private PawnType pawnType;

    public BaseEntity(@NotNull PawnType pawnType) {
        super(pawnType.entityType());

        setPawnType(pawnType);
    }

    public void setPawnType(PawnType pawnType) {
        this.pawnType = pawnType;
        setHealth(pawnType.maxHealth());
    }

    public float getMaxHealth(){
        return pawnType.maxHealth();
    }
}
