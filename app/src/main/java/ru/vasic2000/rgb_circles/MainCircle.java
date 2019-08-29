package ru.vasic2000.rgb_circles;

public class MainCircle extends SimpleCircle {
    public static final int INT_RADIUS = 50;
    public static final double MAIN_SPEED = 30;

    public MainCircle(int x, int y) {
        super(x, y, INT_RADIUS);
    }

    public void mobeMainCirsleWhenTuchAt(int x1, int y1) {
        int dx = (int) ((x1 - x) * MAIN_SPEED / GameManager.getWidth());
        int dy = (int) ((y1 - y) * MAIN_SPEED / GameManager.getHeight());
        x += dx;
        y += dy;
    }
}
