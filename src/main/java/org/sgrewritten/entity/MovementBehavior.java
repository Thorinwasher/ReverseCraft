package org.sgrewritten.entity;

import net.minestom.server.utils.NamespaceID;
import org.sgrewritten.namespace.Keyed;

public record MovementBehavior(double walkSpeed, double runSpeed, double sneakSpeed, double swimSpeed, NamespaceID key) implements Keyed {

}
