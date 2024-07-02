package org.sgrewritten.world;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.generator.GenerationUnit;
import net.minestom.server.instance.generator.Generator;
import net.minestom.server.instance.generator.UnitModifier;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.noise.Noise;
import org.spongepowered.noise.NoiseQuality;

public class PerlinNoiseGenerator implements Generator {

    private final int seed;
    private static final int INTERVAL = 100;
    private static final int OFFSET = 50;

    public PerlinNoiseGenerator(int seed) {
        this.seed = seed;
    }

    @Override
    public void generate(@NotNull GenerationUnit generationUnit) {
        Point start = generationUnit.absoluteStart();
        Point end = generationUnit.absoluteEnd();
        int seaLevel = start.blockY() + OFFSET + INTERVAL / 3;
        for (int x = start.blockX(); x < end.blockX(); x++) {
            for (int z = start.blockZ(); z < end.blockZ(); z++) {
                double perlinNoise1 = Noise.valueCoherentNoise3D(((double) x) / 128, 0, ((double) z) / 128, seed, NoiseQuality.BEST);
                double perlinNoise2 = Noise.valueCoherentNoise3D(((double) x) / 32, 0, ((double) z) / 32, seed, NoiseQuality.BEST);
                int maxPoint = (int) Math.floor(perlinNoise1 * INTERVAL + perlinNoise2 * INTERVAL / 10) + start.blockY() + OFFSET;
                UnitModifier unitModifier = generationUnit.modifier();
                if (maxPoint < seaLevel) {
                    unitModifier.fill(new Vec(x, maxPoint, z), new Vec(x + 1, seaLevel, z + 1), Block.WATER);
                    unitModifier.fill(new Vec(x, start.blockY(), z), new Vec(x + 1, maxPoint, z + 1), Block.STONE);
                } else {
                    unitModifier.fill(new Vec(x, start.blockY(), z), new Vec(x + 1, maxPoint - 3, z + 1), Block.STONE);
                    unitModifier.fill(new Vec(x, maxPoint - 3, z), new Vec(x + 1, maxPoint - 1, z + 1), Block.DIRT);
                    unitModifier.fill(new Vec(x, maxPoint - 1, z), new Vec(x + 1, maxPoint, z + 1), Block.GRASS_BLOCK);
                }
            }
        }
    }
}
