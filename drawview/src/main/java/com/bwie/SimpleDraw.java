package com.bwie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/24 18:00
 * Description:这里写一些简单的画  样式
 */
public class SimpleDraw extends View {

    private Paint paint;  //画笔

    public SimpleDraw(Context context) {
        this(context, null);
    }

    public SimpleDraw(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        initView();
    }

    public SimpleDraw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView() {
        //初始化画笔
        paint = new Paint();
        //给画笔颜色
        paint.setColor(Color.RED);
        //给画笔设置粗细
        paint.setStyle(Paint.Style.STROKE);
        //
        paint.setStrokeWidth(15);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画一条直线  (这是一条横着的直线)
        canvas.drawLine(100, 100, 800, 100, paint);
        //画一条直线  (这是一条竖着的直线)
        canvas.drawLine(40, 150, 40, 500, paint);
        //画一条 直线 (这是一条斜着的直线)
        canvas.drawLine(60, 130, 600, 400, paint);
        //画一个圆    圆心坐标 x,y  半径  画笔
        canvas.drawCircle(650, 700, 150, paint);
        //
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //画一个椭圆
            canvas.drawOval(50, 550, 400, 750, paint);
        }
        //矩形
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //画一个矩形  (非矩形)
            canvas.drawRoundRect(50, 900, 430, 1100, 0, 0, paint);
            //画一个带圆角的矩形
            canvas.drawRoundRect(459, 900, 800, 1100, 100.0f, 100.0f, paint);
        }
        //没效果。。
        canvas.drawARGB(1, 200, 100, 300);
        //绘制背景颜色
        //canvas.drawColor(Color.BLUE);

        //clip切割画布
    }
}
