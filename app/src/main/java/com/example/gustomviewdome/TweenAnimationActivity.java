package com.example.gustomviewdome;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class TweenAnimationActivity extends AppCompatActivity {
private TextView textView;
private ImageView ivInside;
private  ImageView ivOuter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        textView = findViewById(R.id.tv_view);
        ivInside = findViewById(R.id.iv_inside_circle);
        ivOuter = findViewById(R.id.iv_outer_circle);

        Animation insideCircle = AnimationUtils.loadAnimation(this,R.anim.inside_rotate);
        insideCircle.setInterpolator(new LinearInterpolator());
        Animation outerCircle = AnimationUtils.loadAnimation(this,R.anim.outer_ratate);
        outerCircle.setInterpolator(new LinearInterpolator());

    ivInside.startAnimation(insideCircle);
    ivOuter.startAnimation(outerCircle);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_translation:
             //   根据anim/xml完成
//                Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_translate);
//                textView.startAnimation(animation);
             //动态创建，完成和xml一样的效果
                Animation animation = new TranslateAnimation(0,100,0,300);
                animation.setDuration(3000);
                textView.startAnimation(animation);

            case R.id.btn_scale:
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
               textView.startAnimation(animation);
            case R.id.btn_set:
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_set);
                textView.startAnimation(animation);

        }
    }
}