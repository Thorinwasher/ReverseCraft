package org.sgrewritten.entity.goal;

import net.minestom.server.coordinate.Point;
import net.minestom.server.entity.pathfinding.Navigator;
import net.minestom.server.entity.pathfinding.PPath;
import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.entity.BaseEntity;
import org.sgrewritten.entity.behavior.BehaviorData;
import org.sgrewritten.namespace.ReversedNamespace;
import org.sgrewritten.util.Key;

import java.util.Random;
import java.util.stream.Stream;

public class StrollAroundArea implements Goal {

    private final int strollRadius;
    private static final Random RANDOM = new Random();
    private final BaseEntity baseEntity;

    public StrollAroundArea(int strollRadius, BaseEntity baseEntity) {
        this.strollRadius = strollRadius;
        this.baseEntity = baseEntity;
    }

    @Override
    public void tick() {
        baseEntity.setSprinting(false);
        Stream<PPath.PathState> pathStateStream = finishedStates();
        Navigator navigator = baseEntity.getNavigator();
        if (pathStateStream.noneMatch(navigator.getState()::equals)) {
            return;
        }
        BehaviorData data = baseEntity.getData();
        Point homePoint = data.get(Key.HOME_POINT).orElse(baseEntity.getPosition());
        navigator.setPathTo(getStrollTarget(homePoint));
    }

    private Point getStrollTarget(Point homePoint) {
        double degree = RANDOM.nextDouble(0, Math.PI * 2);
        double radius = RANDOM.nextDouble(0, strollRadius);
        return homePoint.add(Math.cos(degree) * radius, 0, Math.sin(degree) * radius);
    }

    @Override
    public boolean isCompleted() {
        return finishedStates().anyMatch(baseEntity.getNavigator().getState()::equals);
    }

    @Override
    public NamespaceID key() {
        return ReversedNamespace.fromKey("goal/stroll");
    }

    private Stream<PPath.PathState> finishedStates() {
        return Stream.of(PPath.PathState.TERMINATED, PPath.PathState.INVALID);
    }
}
