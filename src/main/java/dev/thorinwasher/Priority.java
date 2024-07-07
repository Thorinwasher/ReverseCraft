package dev.thorinwasher;

public class Priority {

    public static final Priority NONE = new Priority(-1);
    public static final Priority LOWEST = new Priority(0);
    public static final Priority LOWER = new Priority(10);
    public static final Priority LOW = new Priority(20);
    public static final Priority NORMAL = new Priority(30);
    public static final Priority HIGH = new Priority(40);
    public static final Priority HIGHER = new Priority(50);
    public static final Priority HIGHEST = new Priority(60);

    private final int level;
    public Priority(int level) {
        this.level = level;
    }

    public boolean largerThan(Priority other) {
        return this.level > other.level;
    }
}
