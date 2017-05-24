package com.example.digdig.animationcanvaswiththread.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.digdig.animationcanvaswiththread.R;

/**
 * Created by digdig on 17-05-24.
 */

public class CustomView extends View  implements View.OnTouchListener{
    // declare the object that you animate
    private Square square1;
    private Square square2;
    //add the constructor
    public CustomView(Context context) {
        super(context);
        //initialize squarel;
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.pacman);
        square1=new Square(100f,100f,image);
        square2=new Square(500f,100f,image);
        setOnTouchListener(this);
    }
    //private Square square2;


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("CANVAS", String.valueOf(canvas.getWidth()));
        Log.d("CANVAS",square1.toString());
        float xPos1 = square1.getxPos();
        float yPos1 =  square1.getyPos();
        canvas.drawBitmap(square1.getBitmap(),xPos1,yPos1,null);

        float xPos2 = square2.getxPos();
        float yPos2 =  square2.getyPos();
        canvas.drawBitmap(square2.getBitmap(),xPos2,yPos2,null);


    }
    public void move()
    {
        float nextXPos1=square1.getxPos()+10;
        float nextYPos1=square1.getyPos()+10;
        square1.setxPos(nextXPos1);
        square1.setyPos(nextYPos1);

        float nextXPos2=square2.getxPos()-10;
        float nextYPos2=square2.getyPos()+10;
        square2.setxPos(nextXPos2);
        square2.setyPos(nextYPos2);


        if((square1.getxPos() == square2.getxPos()) && (square1.getyPos() == square2.getyPos()))
        {

           Log.d("INTERSECTION","Object collision");
        }
    }
    public void reverse()
    {
        float nextXPos1=square1.getxPos()-10;
        float nextYPos1=square1.getyPos()-10;
        square1.setxPos(nextXPos1);
        square1.setyPos(nextYPos1);

        float nextXPos2=square2.getxPos()+10;
        float nextYPos2=square2.getyPos()-10;
        square2.setxPos(nextXPos2);
        square2.setyPos(nextYPos2);


        if((square1.getxPos() == square2.getxPos()) && (square1.getyPos() == square2.getyPos()))
        {

            Log.d("INTERSECTION","Object collision");
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("TOUCH","X pos="+square1.toString());
        float canvasXpos = event.getX();
        return false;
    }
}
