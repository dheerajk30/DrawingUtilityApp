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

import com.example.dheeraj.drawingapp.R;

import java.util.ArrayList;

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
    ArrayList<Rect> squares;
    int boxcolor;

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
        boxcolor= Color.BLACK;
        squares=new ArrayList<Rect>();
        gestureDetector=new GestureDetector(ctx,new DrawGestureDetector());
        singletap=false;
        squarePaint=new Paint();
        squarePaint.setStrokeWidth(10);
        squarePaint.setStyle(Paint.Style.FILL);
        squarePaint.setColor(Color.rgb(200,0,0));
    }




    public void adjustRectSize(int length){
        this.length=length;
    }

    public ArrayList<Rect> getAllRects(){
        return squares;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        if(singletap){
            Rect rect=new Rect();
            rect.left=x_centre- (length/2);
            rect.right=x_centre+ (length/2);
            rect.top=y_centre-(length/2);
            rect.bottom=y_centre+(length/2);

            squares.add(rect);
            for (Rect r:squares){
                canvas.drawRect(r,squarePaint);
            }
        }
        else{
            for (Rect r:squares){
                canvas.drawRect(r,squarePaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        singletap=gestureDetector.onTouchEvent(event);
        x_centre=(int) event.getX();
        y_centre=(int) event.getY();


        postInvalidate();
        return gestureDetector.onTouchEvent(event);

    }



    class DrawGestureDetector extends GestureDetector.SimpleOnGestureListener{

        public DrawGestureDetector() {
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {

            return false;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onContextClick(MotionEvent e) {
            return false;
        }



    }
}
