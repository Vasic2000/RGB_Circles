package ru.vasic2000.rgb_circles;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 100;

    public EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    public static EnemyCircle getRandomCircle() {
        Random rand = new Random();
        int x = rand.nextInt(GameManager.getWidth());
        int y = rand.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + rand.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle circle = new EnemyCircle(x, y, radius);
        return circle;
    }
}
