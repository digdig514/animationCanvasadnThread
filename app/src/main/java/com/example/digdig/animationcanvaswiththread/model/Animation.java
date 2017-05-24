package com.example.digdig.animationcanvaswiththread.model;

import android.util.Log;

/**
 * Created by digdig on 17-05-24.
 */

public class Animation implements Runnable {
    CustomView customView;
    Thread thread;

    public Animation(CustomView customView) {
        this.customView = customView;
    }

    @Override
    public void run() {
        while (thread!=null)
        {
           /* switch (thread)
            {
                case reserve:
                    animation.reverse();
                    break;
            }*/
            customView.move();
            // redraw the canvas
            // or call the method onDraw
            customView.postInvalidate();
            try {
                thread.sleep(500);

            } catch (InterruptedException e)

            {
                Log.d("ANIMATION",e.getMessage());
            }

        }

    }

    public void start(){
        thread = new Thread(this);
        thread.start();
    }
    public void stop(){
        thread=null;
    }
   /* public void reverse(){
        thread=reserve;
    }*/


}
