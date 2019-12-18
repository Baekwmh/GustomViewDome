package com.example.gustomviewdome;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class SimpleView extends View {
    private Paint paint;
    private Drawable drawable;
    private int width;
    private int height;

    public SimpleView(Context context) {
        super(context,null);
    }

    public SimpleView(Context context,  AttributeSet attrs) {
        super(context, attrs,0);
        initAttrs(attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    private void initAttrs(AttributeSet attrs) {
        if(attrs != null){
            TypedArray array = null;

            try {
                array = getContext().obtainStyledAttributes(attrs,R.styleable.SimpleView);
                drawable = array.getDrawable(R.styleable.SimpleView_src);
                measureDrawable();
            }finally {
               if (array != null){
                   array.recycle();
               }
            }



        }

    }

    private void measureDrawable() {
    if (drawable == null){
     throw new RuntimeException("drawable不能为空");
    }
    width = drawable.getIntrinsicWidth();
    height = drawable.getIntrinsicHeight();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMode,width),measureHeight(heightMode,height));
    }

    private int measureHeight(int mode , int height) {
        switch (mode){
            case MeasureSpec.UNSPECIFIED:

             case MeasureSpec.AT_MOST:
                    break;
             case MeasureSpec.EXACTLY:
                    this.height = height;
                     break;
        }
       return this.height;
    }

    private int measureWidth(int mode, int width) {
        switch (mode){
            case MeasureSpec.UNSPECIFIED:

            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                this.width = width;
                break;
        }
        return this.width;
    }

private Bitmap mBitmap;
    @Override
    protected void onDraw(Canvas canvas) {
        if(mBitmap == null){
            mBitmap = Bitmap.createScaledBitmap(
                    ImageUtils.drawableToBitmap(drawable),getMeasuredWidth(),
                    getMeasuredHeight(),true);

        }
        canvas.drawBitmap(mBitmap,getLeft(),getTop(),paint);
        canvas.save();
        canvas.rotate(90);
        paint.setColor(Color.YELLOW);
        paint.setTextSize(50);
        canvas.drawText("exo",getLeft() + 50,getTop() - 50,paint);
        canvas.restore();
    }

    public SimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
