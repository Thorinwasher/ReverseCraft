package dev.thorinwasher.entity;

import net.minestom.server.utils.NamespaceID;
import dev.thorinwasher.namespace.Keyed;

public record MovementBehavior(double walkSpeed, double runSpeed, double sneakSpeed, double swimSpeed, NamespaceID key) implements Keyed {

}
