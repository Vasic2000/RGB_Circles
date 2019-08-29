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
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        circles = new ArrayList<>();

        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemyCircle circle;
            do {
                circle = EnemyCircle.getRandomCircle();
            }
            while (circle.isIntersect(mainCircleArea));
            circles.add(circle);
        }
        calculateAndSetCirclesColor();
    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle : circles) {
            circle.setEnemyOfFoodColorDependensOn(mainCircle);
        }
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    public void onTuchEvent(int x, int y) {
        mainCircle.mobeMainCirsleWhenTuchAt(x, y);
    }
}
