package com.example.dheeraj.drawingapp.Views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dheeraj on 7/6/18.
 */

public class SquareDrawingArea extends View {

    GestureDetector gestureDetector;
    Context ctx;
    public SquareDrawingArea(Context context) {
        super(context);
        ctx=context;
    }

    public SquareDrawingArea(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ctx=context;
        init(null);
    }

    public SquareDrawingArea(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ctx=context;
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SquareDrawingArea(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        ctx=context;
        init(attrs);
    }

    public void init(@Nullable AttributeSet attr){
        gestureDetector=new GestureDetector(ctx,new DrawGestureDetector());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return true;
    }



    class DrawGestureDetector extends GestureDetector.SimpleOnGestureListener{

        public DrawGestureDetector() {
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return true;
        }
    }
}
