package org.sgrewritten.world;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Entity;

public class UpdatablePosition {

    private Pos pos;
    private Entity target;
    private boolean hasChanged;

    public UpdatablePosition(Entity target) {
        this.target = target;
        this.pos = target.getPosition();
    }

    public UpdatablePosition(Pos pos) {
        this.pos = pos;
    }

    public Pos getPos() {
        updatePosition();
        return this.pos;
    }

    public boolean hasChanged() {
        return this.hasChanged;
    }

    public void updatePosition() {
        if (target == null) {
            return;
        }
        if (target.getPosition().equals(pos)) {
            return;
        }
        this.pos = target.getPosition();
        this.hasChanged = true;
    }

    public void clearPositionChange() {
        this.hasChanged = false;
    }

    public void changePosition(Pos pos){
        this.pos = pos;
        this.hasChanged = true;
    }
}
