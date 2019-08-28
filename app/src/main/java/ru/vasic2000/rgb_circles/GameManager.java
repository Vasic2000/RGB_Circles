package ru.vasic2000.rgb_circles;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {
    private MainCircle mainCircle;
    private Paint paint;
    private CanvasView canvasView;
    private static int width;
    private static int height;

    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMinCircle();
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initMinCircle() {
        mainCircle = new MainCircle(width / 2,height / 2);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
