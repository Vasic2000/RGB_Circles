package ru.vasic2000.rgb_circles;

import android.graphics.Color;

public class MainCircle extends SimpleCircle {
    public static final int INT_RADIUS = 50;
    public static final double MAIN_SPEED = 30;
    public static final int OUR_COLOR = Color.BLUE;

    public MainCircle(int x, int y) {
        super(x, y, INT_RADIUS);
        setColor(OUR_COLOR);
    }

    public void moveMainCirsleWhenTuchAt(int x1, int y1) {
        int dx = (int) ((x1 - x) * MAIN_SPEED / GameManager.getWidth());
        int dy = (int) ((y1 - y) * MAIN_SPEED / GameManager.getHeight());
        x += dx;
        y += dy;
    }

    public void initRadius() {
        radius = INT_RADIUS;
    }

    public void growRadius(SimpleCircle circle) {
        // Pi * newR^2 == Pi * R^2 + Pi * R_eated^2
        //newR = sqrt(R^2 + R_eated^2)
        radius = (int) Math.sqrt(Math.pow(radius, 2) + (Math.pow(circle.radius, 2)));
    }
}
