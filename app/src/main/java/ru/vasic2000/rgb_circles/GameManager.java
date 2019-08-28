package ru.vasic2000.rgb_circles;

public class GameManager {
    private MainCircle mainCircle;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMinCircle();
    }


    private void initMinCircle() {
        mainCircle = new MainCircle(width / 2,height / 2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
    }
}
