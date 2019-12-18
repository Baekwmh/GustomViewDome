package com.example.gustomviewdome;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity  {
private ImageView ivFrame;
private AnimationDrawable drawable;
private Button start;
private  Button stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        start = findViewById(R.id.btn_start);
        stop = findViewById(R.id.btn_stop);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable.stop();
            }
        });
//第一种方式
   ivFrame = findViewById(R.id.iv_progress);
   drawable = (AnimationDrawable)ivFrame.getBackground();

   drawable.start();
//  第二种方式
//   ivFrame.setImageResource(R.drawable.frame_anim);
//   drawable = (AnimationDrawable)ivFrame.getDrawable();
//
//        drawable.start();
//        第三种方式
//        drawable = createAnimation();
//        ivFrame.setImageDrawable(drawable);
//        drawable.start();

    }

    private AnimationDrawable createAnimation() {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (int i = 0; i < 8 ; i++){
            int id = getResources().getIdentifier("wait"+i,"drawable",getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            animationDrawable.addFrame(drawable,100);
        }
        return  animationDrawable;
    }


}
