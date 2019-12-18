package com.example.gustomviewdome;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class CustomToolbar extends LinearLayout {
    private  int bgColor;
    private String title;
    private int menuSrc;

    public CustomToolbar(Context context) {
        super(context,null);
    }

    public CustomToolbar(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomToolbar,defStyleAttr,0);
        bgColor = typedArray.getColor(R.styleable.CustomToolbar_backgroundColor, Color.TRANSPARENT);
        title = typedArray.getString(R.styleable.CustomToolbar_title);
        menuSrc = typedArray.getResourceId(R.styleable.CustomToolbar_menuSrc,-1);
        typedArray.recycle();

    }

    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);


    }
    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.custom_title,this);
    }
}
