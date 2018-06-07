package com.example.dheeraj.drawingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.example.dheeraj.drawingapp.Views.SquareDrawingArea;

public class DrawingArea extends AppCompatActivity {

    SquareDrawingArea drawingArea;
    SeekBar sizeSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_area);

        initViews();
    }

    public void initViews(){
        drawingArea=(SquareDrawingArea) findViewById(R.id.drawingArea);
        sizeSeekBar=(SeekBar) findViewById(R.id.sizeSeekBar);
    }
}
