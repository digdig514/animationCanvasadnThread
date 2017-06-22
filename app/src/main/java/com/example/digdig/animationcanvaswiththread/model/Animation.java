package com.example.digdig.animationcanvaswiththread.model;

import android.content.Intent;
import android.util.Log;

import com.example.digdig.animationcanvaswiththread.MainActivity;

/**
 * Created by digdig on 17-05-24.
 */

public class Animation implements Runnable {
    CustomView customView;
    Thread thread;

    public Animation(CustomView customView) {
        this.customView = customView;
    }
   int test;
    @Override
    public void run() {
        while (thread!=null)
        {
           if (test==0)
           {
               customView.start();
           }
           //else customView.stop();
            customView.postInvalidate();
            try {
                thread.sleep(50);

            } catch (InterruptedException e)

            {
                Log.d("ANIMATION",e.getMessage());
            }

        }

    }



    public void start(int value){
        test = value;

        thread = new Thread(this);
        thread.start();
    }


    public void stop(){
        thread=null;
    }




}
