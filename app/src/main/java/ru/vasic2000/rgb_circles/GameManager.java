package ru.vasic2000.rgb_circles;

import java.util.ArrayList;

public class GameManager {
    public static final int MAX_CIRCLES = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMinCircle();
        initEnemyCircles();
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }


    private void initMinCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    private void initEnemyCircles() {
        circles = new ArrayList<>();

        for (int i = 0; i < MAX_CIRCLES; i++) {
            circles.add(EnemyCircle.getRandomCircle());
        }
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for(EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    public void onTuchEvent(int x, int y) {
        mainCircle.mobeMainCirsleWhenTuchAt(x, y);
    }
}
