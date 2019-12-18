package com.example.gustomviewdome;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PointView extends View {
    private static final float RADIUS = 90;
    private Point currentPoint;
    private Paint mPaint;
    private String color;

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.GREEN);
    }

    /**
     * 绘制逻辑：现在初始点画圆，通过监听当前坐标值的变化，调用onDraw()重绘，
     * 实现元的平移动画效果
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // 当前点的坐标为空，第一次绘制
        if (currentPoint == null) {
            // 创建一个坐标为(90，90)的Point对象
            currentPoint = new Point(RADIUS, RADIUS);

            float x = currentPoint.getX();
            float y = currentPoint.getY();

            // 在该点坐标画一个圆
            canvas.drawCircle(x, y, RADIUS, mPaint);

            // 创建初始动画的对象点和结束动画的对象点
            Point startPoint = new Point(RADIUS, RADIUS);
            Point endPoint = new Point(700, 1000);

            // 创建值动画对象，设置初始点和结束点
            ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(),
                    startPoint, endPoint, startPoint);

            // 设置动画参数
            valueAnimator.setDuration(5000);
//            valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
//            valueAnimator.setRepeatMode(ValueAnimator.REVERSE);

            // 设置监听器
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    currentPoint = (Point) animation.getAnimatedValue();
                    // 重绘实现动画效果
                    invalidate();
                }
            });
            // 启动动画
            valueAnimator.start();
        } else {
            // 如果坐标值不为0，则画圆
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }
}
