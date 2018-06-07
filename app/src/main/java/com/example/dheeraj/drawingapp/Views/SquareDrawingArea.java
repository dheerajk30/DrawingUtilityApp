package com.example.dheeraj.drawingapp.Views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by dheeraj on 7/6/18.
 */

public class SquareDrawingArea extends View {

    GestureDetector gestureDetector;
    Context ctx;
    int x_centre=300,y_centre=300;
    int length=200;
    Boolean singletap;
    Paint squarePaint;


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
        Toast.makeText(ctx,"init",Toast.LENGTH_SHORT).show();
        gestureDetector=new GestureDetector(ctx,new DrawGestureDetector());
        singletap=true;
        squarePaint=new Paint();
        squarePaint.setColor(Color.rgb(0, 0, 0));
        squarePaint.setStrokeWidth(10);
        squarePaint.setStyle(Paint.Style.STROKE);
    }


    public void adjustRectSize(int length){
        this.length=length;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(45f,55f,55f,45f,squarePaint);


        if(singletap){
            Rect rect=new Rect();
            float left=x_centre-(float) (length/2);
            float right=x_centre+(float) (length/2);

            float top=y_centre-(float) (length/2);
            float bottom=y_centre+(float)(length/2);

            Log.d("main", "onDraw: left"+left+"right"+right+"top"+top+"bottom"+bottom);
            canvas.drawRect(left,top,right,bottom,squarePaint);

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        singletap=true;
        x_centre=(int) event.getX();
        y_centre=(int) event.getY();

        Toast.makeText(ctx,singletap+"single tap at"+x_centre+" and"+y_centre,Toast.LENGTH_SHORT).show();

        postInvalidate();
        return true;

    }



    class DrawGestureDetector extends GestureDetector.SimpleOnGestureListener{

        public DrawGestureDetector() {
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {

            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }
    }
}
