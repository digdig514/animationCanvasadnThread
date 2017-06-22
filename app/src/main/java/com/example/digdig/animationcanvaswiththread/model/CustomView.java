package com.example.digdig.animationcanvaswiththread.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.digdig.animationcanvaswiththread.MainActivity;
import com.example.digdig.animationcanvaswiththread.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by digdig on 17-05-24.
 */

public class CustomView extends View  implements View.OnTouchListener{
    //screen width and height
    float canvasWidth;
    float canvasHeight;
    private ArrayList<Coconut> coconuts;
    private Coconut barr;
    private boolean movecheck;
    private int barratop=190;
    Score score;
   // String[]  speedran= {"10"};
    String[]  open= {"-10","+10","+6","-4","+16","-4"};
    String[]  speedran= {"10","14"};
    Animation animation;

    Random ran = new Random();
    //add the constructor

    public CustomView(Context context) {
        super(context);
        //initialize squarel;
        coconuts = new ArrayList<>();
        Bitmap imageedit = BitmapFactory.decodeResource(getResources(), R.drawable.fisnih2);
        Bitmap image = Bitmap.createScaledBitmap(imageedit,150,100,true);
        Bitmap image2edit = BitmapFactory.decodeResource(getResources(), R.drawable.fish4);
        Bitmap image2 = Bitmap.createScaledBitmap(image2edit,150,150,true);
        Bitmap image3edit = BitmapFactory.decodeResource(getResources(), R.drawable.fish5);
        Bitmap image3 = Bitmap.createScaledBitmap(image3edit,150,100,true);
        Bitmap image4edit = BitmapFactory.decodeResource(getResources(), R.drawable.finish3);
        Bitmap image4 = Bitmap.createScaledBitmap(image4edit,150,150,true);

        Bitmap changebarrimg = BitmapFactory.decodeResource(getResources(), R.drawable.barham);
        Bitmap barrimg = Bitmap.createScaledBitmap(changebarrimg,320,160,true);







        coconuts.add(new Coconut(ran.nextInt(700)+barratop,ran.nextInt(700)+barratop,image,Float.valueOf(open[ran.nextInt(speedran.length)]),Float.valueOf(open[ran.nextInt(speedran.length)]),Integer.valueOf(speedran[ran.nextInt(speedran.length)])));
        coconuts.add(new Coconut(ran.nextInt(700)+barratop,ran.nextInt(700)+barratop,image2,Float.valueOf(open[ran.nextInt(speedran.length)]),Float.valueOf(open[ran.nextInt(speedran.length)]),Integer.valueOf(speedran[ran.nextInt(speedran.length)])));
        coconuts.add(new Coconut(ran.nextInt(700)+barratop,ran.nextInt(700)+barratop,image3,Float.valueOf(open[ran.nextInt(speedran.length)]),Float.valueOf(open[ran.nextInt(speedran.length)]),Integer.valueOf(speedran[ran.nextInt(speedran.length)])));
        coconuts.add(new Coconut(ran.nextInt(700)+barratop,ran.nextInt(700)+barratop,image4,Float.valueOf(open[ran.nextInt(speedran.length)]),Float.valueOf(open[ran.nextInt(speedran.length)]),Integer.valueOf(speedran[ran.nextInt(speedran.length)])));
        barr=new Coconut(800,100,barrimg);
        score= new Score();

        setOnTouchListener(this);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //bar top
        Bitmap barrtop = BitmapFactory.decodeResource(getResources(), R.drawable.green);
        //Bitmap barrtop = Bitmap.createScaledBitmap(barrtopimg,320,160,true);
        //life
        Bitmap heart = BitmapFactory.decodeResource(getResources(),R.drawable.heart);
        Bitmap heartimg = Bitmap.createScaledBitmap(heart,200,200,true);
        //start Touch
        Bitmap star = BitmapFactory.decodeResource(getResources(),R.drawable.star);
        Bitmap starimg = Bitmap.createScaledBitmap(star,200,200,true);
        //score
        Bitmap sun = BitmapFactory.decodeResource(getResources(),R.drawable.suny);
        Bitmap sunimg = Bitmap.createScaledBitmap(sun,480,220,true);
        paint.setTextSize(70);
        //bar top
        canvas.drawBitmap(barrtop, 0, 0, null);
        //lives
        canvas.drawBitmap(heartimg, canvasWidth-heartimg.getWidth(), 10, null);
        canvas.drawText(getContext().getString(R.string.life_name) + score.getLive(), canvasWidth-heartimg.getWidth()+heartimg.getWidth()/2-25, heartimg.getWidth()/2+heartimg.getWidth()/10, paint);
        //sun score
        canvas.drawBitmap(sunimg, 0, 0, null);
        canvas.drawText(getContext().getString(R.string.life_name) + score.getScore(), barratop , sunimg.getWidth()/4, paint);
        //touch
        canvas.drawBitmap(starimg, canvasWidth/2, 0, null);
        canvas.drawText(getContext().getString(R.string.life_name) + score.getTouch(), canvasWidth/2+40 , sunimg.getWidth()/4+25, paint);

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();


        Log.d("CANVAS", String.valueOf(canvas.getWidth()));
        Log.d("CANVAS",coconuts.toString());
        for(Coconut coconut : coconuts) {
            if(!coconut.isSetAllCoconuts()) {

                coconut.getxPos();
                coconut.getyPos();
                coconut.setSetAllCoconuts(true);
            }
            canvas.drawBitmap(coconut.getBitmap(), coconut.getxPos(), coconut.getyPos(), null);
        }
  if(!barr.isInitialposition())
        {
            barr.setxPos((int) (canvasWidth / 2) - (barr.getBitmap().getWidth() / 2));
            barr.setyPos((int) (canvasHeight - barr.getBitmap().getHeight()));
            barr.setInitialposition(true);
        }


        float xPos3 = barr.getxPos();
        float yPos3 =  barr.getyPos();
        canvas.drawBitmap(barr.getBitmap(),xPos3,yPos3,null);



    }

    public void start() {
        for(int i=0;i<coconuts.size();i++) {
            Coconut coconut = coconuts.get(i);
       moveS(coconut);


        }
    }

    private void moveS(Coconut coconut) {
        if (score.getLive()>0)
        {

            if (coconut.getxPos() <= 0) {
                coconut.setSetxDirection(1 * coconut.getSpeed());
            } else if (coconut.getxPos() + coconut.getBitmap().getWidth() >= canvasWidth) {
                coconut.setSetxDirection(-1 * coconut.getSpeed());
            } else if (coconut.getyPos() + coconut.getBitmap().getHeight() >= canvasHeight && (!barr.isBumpbarr())) {
                score.setLive(score.getLive() - 1);
                if (score.getLive()<0)
                {
                    coconut.setStopcoconuts(true);

                }

                coconut.setSpeed(10);
                coconut.setSetyDirection(1 * coconut.getSpeed());
                coconut.setyPos(barratop);
            } else if (coconut.getyPos() <= barratop) {

                coconut.setSetyDirection(1 * coconut.getSpeed());
            } else if (coconut.getyPos() + coconut.getBitmap().getHeight() >= barr.getyPos() + 20) {

                if (coconut.getxPos() + coconut.getBitmap().getWidth() >= barr.getxPos() && (coconut.getxPos() <= barr.getxPos() + barr.getBitmap().getWidth())) {
                    coconut.setSetyDirection(-1 * coconut.getSpeed());
                    coconut.setSpeed(coconut.getSpeed() + 1);
                    score.incrementScore(coconut.getSpeed());
                    score.setTouch(score.getTouch() + 1);
                }


            }
            float nextXPos1 = coconut.getxPos() + coconut.getSetxDirection();
            float nextYPos1 = coconut.getyPos() + coconut.getSetyDirection();
            coconut.setxPos(nextXPos1);
            coconut.setyPos(nextYPos1);
        }
        /*else
        {
            Toast.makeText(context,"GAME OVER",Toast.LENGTH_SHORT).show();
        }*/

    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        barr.setxPos((int) event.getX());

       if (barr.getxPos() + barr.getBitmap().getWidth() >= canvasWidth)
       {

           barr.setxPos((int) (canvasWidth - barr.getBitmap().getWidth()));

       }
       else
       if (barr.getxPos() <= 0)
       {


           barr.setxPos((int) (event.getX()));

       }

   return true;
    }
}
