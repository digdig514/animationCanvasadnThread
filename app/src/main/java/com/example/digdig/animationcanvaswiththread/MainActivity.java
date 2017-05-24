package com.example.digdig.animationcanvaswiththread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.digdig.animationcanvaswiththread.model.Animation;
import com.example.digdig.animationcanvaswiththread.model.CustomView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
LinearLayout linMid;
Button btnStart,btnStop, btnReverse;
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
        btnReverse = (Button) findViewById(R.id.btnReverse);
        btnStart.setOnClickListener(this);
        btnReverse.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        customView = new CustomView(this);
        linMid.addView(customView);
        animation =  new Animation(customView);

    }



    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnStart:
                animation.start();
                break;
            case R.id.btnStop:
                animation.stop();
                break;
            case R.id.btnReverse:
                animation.reverse();
                break;
        }

    }
}
