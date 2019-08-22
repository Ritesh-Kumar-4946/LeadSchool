package com.ritesh.leadschool;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class Viewport extends ViewGroup {

    public Viewport(Context context) {
        super(context);
    }

    public Viewport(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Viewport(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);


        int viewportMargin = 40;
        int viewportCornerRadius = 10;
        Paint eraser = new Paint();
        eraser.setAntiAlias(true);
        eraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float width = (float) getWidth() - viewportMargin;
//        float height = width * (float) 0.7;
        float height = width * (float) 0.7;


        RectF rect = new RectF((float) viewportMargin, (float) viewportMargin, width, height); // image area
        RectF frame = new RectF((float) viewportMargin - 1, (float) viewportMargin - 1, width + 1, height + 1);
        Path path = new Path();


        Paint stroke = new Paint();
        stroke.setAntiAlias(true);
        stroke.setStrokeWidth(2);
        stroke.setColor(Color.WHITE);
        stroke.setStyle(Paint.Style.STROKE);
        path.addRoundRect(frame, (float) viewportCornerRadius, (float) viewportCornerRadius, Path.Direction.CW);
        canvas.drawPath(path, stroke);
        canvas.drawRoundRect(rect, (float) viewportCornerRadius, (float) viewportCornerRadius, eraser);

//        //center
//        int x0 = canvas.getWidth()/2;
//        int y0 = canvas.getHeight()/2;
//        int dx = canvas.getHeight()/3;
//        int dy = canvas.getHeight()/3;
//        //draw guide box
//        canvas.drawRect(x0-dx, y0-dy, x0+dx, y0+dy, stroke);
    }
}