package org.sgrewritten.entity.goal;

import org.sgrewritten.namespace.Keyed;

public interface Goal extends Keyed {

    void tick();

    boolean isCompleted();
}
