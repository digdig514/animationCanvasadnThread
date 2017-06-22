package com.example.digdig.animationcanvaswiththread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.digdig.animationcanvaswiththread.model.Animation;
import com.example.digdig.animationcanvaswiththread.model.CustomView;
import com.example.digdig.animationcanvaswiththread.model.Score;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
LinearLayout linMid;
Button btnStart,btnStop, btnRefresh;
//TextView scoreHigh,scoreLive,lives;
CustomView customView;
Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        linMid = (LinearLayout) findViewById(R.id.linMid);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnRefresh = (Button) findViewById(R.id.btnRefresh);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnRefresh.setOnClickListener(this);
        //lives = (TextView) findViewById(R.id.textViewLive);
        //scoreHigh = (TextView) findViewById(R.id.textViewScoreHigh);
        //scoreLive = (TextView) findViewById(R.id.textViewScoreLive);
        customView = new CustomView(this);

        linMid.addView(customView);

        animation =  new Animation(customView);


    }



    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnStart:
                //customView.play();
                animation.start(0);
                break;
            case R.id.btnStop:
                animation.stop();
                break;
            case R.id.btnRefresh:
                refresh();
                break;
        }

    }

    private void refresh() {


            Intent refresh = new Intent(this,MainActivity.class);
            startActivity(refresh);
            this.finish();

    }
}
