package com.example.gustomviewdome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
private Button t_zheng;
private  Button t_bujian;
private  Button t_shuxing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t_zheng = findViewById(R.id.frame);
        t_bujian = findViewById(R.id.tween);
        t_shuxing = findViewById(R.id.attr);
        t_shuxing.setOnClickListener(this);
        t_bujian.setOnClickListener(this);
        t_zheng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.tween :
            Intent intent = new Intent(Main2Activity.this,TweenAnimationActivity.class);
            startActivity(intent);
            break;
        case R.id.frame :
            Intent intent1 = new Intent(Main2Activity.this,FrameAnimationActivity.class);
            startActivity(intent1);
            break;
        case R.id.attr  :
            Intent intent2 = new Intent(Main2Activity.this,ValueAnimationActivity.class);
            startActivity(intent2);
            break;
    }
    }
}
