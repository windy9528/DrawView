package com.bwie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/25 14:22
 * Description:
 */
public class HighView extends View {
    private Paint paint;  //画笔
    private final static int circleX = 539;
    private final static int circleY = 791;
    private final static int textSize = 35;
    private float textWidth;
    private String coord;
    private Path redPath;

    public HighView(Context context) {
        this(context, null);
    }

    public HighView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        initView();
    }

    public HighView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

    }

    private void initView() {
        //初始化画笔
        paint = new Paint();
        //给画笔颜色
        paint.setColor(Color.RED);
        //给画笔设置粗细
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //给画笔设置粗细
        paint.setStrokeWidth(10);
        //给画笔设置
        paint.setTextSize(textSize);

        //红色的画笔;
        redPath = new Path();
        //路径起始点
        redPath.moveTo(circleX, circleY);
    }

    public void add(int x, int y) {
        redPath.lineTo(circleX + x, circleY - y);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //redPath.lineTo(400,500);
        //调用这个
        canvas.drawPath(redPath, paint);
        //画横线 x轴  circleX  circleY
        canvas.drawLine(-circleX, circleY, circleX * 2, circleY, paint);
        //划横线 y轴
        canvas.drawLine(circleX, circleY * 2, circleX, -circleY, paint);
        //写圆点
        canvas.drawText("0", circleX - paint.measureText("0") * 2, circleY + textSize, paint);
        //开始 写坐标
        for (int i = -500; i <= 500; i += 100) {
            if (i == 0) {
                //圆点单独写

            } else {
                //写坐标的值
                coord = i + " ";
                //写文本的宽度
                textWidth = paint.measureText(coord);
                //画X轴的坐标
                canvas.drawText(coord, circleX + i - textWidth / 2, circleY + textSize, paint);
            }
        }
        for (int i = -700; i <= 700; i += 100) {
            if (i == 0) {
                //圆点单独写

            } else {
                //写坐标的值
                coord = i + " ";
                //写文本的宽度
                textWidth = paint.measureText(coord);
                //画Y轴的坐标
                canvas.drawText(coord, circleX - textWidth, circleY - i + textSize / 2, paint);
            }
        }

    }
}
