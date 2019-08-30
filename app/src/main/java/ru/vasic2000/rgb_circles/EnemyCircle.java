package ru.vasic2000.rgb_circles;

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 100;
    public static final int ENEMY_COLOR = Color.RED;
    public static final int FOOD_COLOR = Color.rgb(0, 200, 0);
    public static final int RANDOM_SPEED = 10;

    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        setColor(ENEMY_COLOR);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle() {
        Random rand = new Random();
        int x = rand.nextInt(GameManager.getWidth());
        int y = rand.nextInt(GameManager.getHeight());

        int dx = rand.nextInt(RANDOM_SPEED);
        int dy = rand.nextInt(RANDOM_SPEED);


        int radius = FROM_RADIUS + rand.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle circle = new EnemyCircle(x, y, radius, dx, dy);
        circle.setColor(ENEMY_COLOR);
        return circle;
    }

    public void setEnemyOfFoodColorDependensOn(MainCircle mainCircle) {
        if(isSmallerThan(mainCircle)) {
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }

    }

    public boolean isSmallerThan(SimpleCircle circle) {
        return this.radius < circle.radius;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    private void checkBounds() {
        if(x > GameManager.getWidth() || x < 0)
            dx = -dx;
        if(y > GameManager.getHeight() || y < 0)
            dy = -dy;
    }
}
