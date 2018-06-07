package com.example.dheeraj.drawingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.dheeraj.drawingapp.Views.SquareDrawingArea;

public class DrawingArea extends AppCompatActivity {

    SquareDrawingArea drawingArea;
    SeekBar sizeSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_area);

        initViews();
        sizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                drawingArea.adjustRectSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sizeSeekBar.setProgress(20);
        sizeSeekBar.setMax(250);
    }

    public void initViews(){
        drawingArea=(SquareDrawingArea) findViewById(R.id.drawingArea);
        sizeSeekBar=(SeekBar) findViewById(R.id.sizeSeekBar);
    }
}
