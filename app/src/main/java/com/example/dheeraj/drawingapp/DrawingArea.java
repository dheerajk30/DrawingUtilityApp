package com.example.dheeraj.drawingapp;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.dheeraj.drawingapp.Views.SquareDrawingArea;

import java.util.ArrayList;

public class DrawingArea extends AppCompatActivity {

    SquareDrawingArea drawingArea;
    SeekBar sizeSeekBar;
    Button viewall;


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
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog dialog=new AlertDialog.Builder(DrawingArea.this).create();
                dialog.setTitle("All Rectangles");

                ArrayList<Rect> squares=drawingArea.getAllRects();
                String allsquares=format(squares);
                dialog.setMessage(allsquares);
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    public void initViews(){
        drawingArea=(SquareDrawingArea) findViewById(R.id.drawingArea);
        sizeSeekBar=(SeekBar) findViewById(R.id.sizeSeekBar);
        viewall=(Button) findViewById(R.id.viewall);
    }

    public String format(ArrayList<Rect> squares){
        StringBuilder b=new StringBuilder();
        b.append("[");
        for(Rect r:squares){
            b.append("{coordinates: [("+r.left+","+r.top+"),("+r.right+","+r.bottom+")("+r.left+","+r.bottom+")("+r.right+","+r.top+")]}");
        }
        b.append("]");

        return b.toString();
    }
}
