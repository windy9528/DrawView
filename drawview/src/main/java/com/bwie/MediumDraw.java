package com.bwie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/24 19:35
 * Description:
 */
public class MediumDraw extends ViewGroup {

    private Paint paint;  //画笔
    private final static int circleX = 539;
    private final static int circleY = 791;
    private final static int textSize = 35;
    private float textWidth;
    private String coord;
    private Path redPath;
    //private Path bluePath;

    public MediumDraw(Context context) {
        this(context, null);
    }

    public MediumDraw(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        initView();
    }

    public MediumDraw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        paint.setStyle(Paint.Style.STROKE);
        //给画笔设置粗细
        paint.setStrokeWidth(10);
        //给画笔设置
        paint.setTextSize(textSize);

        //红色的画笔;
        redPath = new Path();
        //路径起始点
        redPath.moveTo(circleX, circleY);
        /*redPath.lineTo(circleX + 200, circleY - 500);
        redPath.lineTo(circleX + 300, circleY - 400);
        redPath.lineTo(circleX + 400, circleY - 300);
        redPath.lineTo(circleX + 500, circleY - 200);*/
        //红色的画笔;
        //  redTrack();

        //蓝色画笔
        //blueTrack();
    }

    private void redTrack() {
        //红色的画笔;
        redPath = new Path();
        //路径起始点
        redPath.moveTo(circleX, circleY);
        //循环遍历
        redPath.lineTo(circleX + 200, circleY - 500);
        redPath.lineTo(circleX + 300, circleY - 400);
        redPath.lineTo(circleX + 400, circleY - 300);
        redPath.lineTo(circleX + 500, circleY - 200);
        for (int i = 100; i < 500; i++) {
            redPath.lineTo(circleX + 100 + i, circleY - 600 - i);
        }
  /*      redPath.moveTo(circleX + 100, circleY - 600);
        redPath.moveTo(circleX + 100, circleY - 600);
        redPath.moveTo(circleX + 100, circleY - 600);
        redPath.lineTo(circleX + 200, circleY - 500);
        redPath.lineTo(circleX + 300, circleY - 400);
        redPath.lineTo(circleX + 400, circleY - 400);
        redPath.lineTo(circleX + 500, circleY - 300);*/
    }

    /*private void blueTrack() {
        //红色的画笔;
        bluePath = new Path();
        //路径起始点
        redPath.moveTo(circleX + 100, circleY - 600);
        //循环遍历
        redPath.lineTo(circleX + 200, circleY - 500);
        redPath.lineTo(circleX + 300, circleY - 400);
        redPath.lineTo(circleX + 400, circleY - 300);
        redPath.lineTo(circleX + 500, circleY - 200);
    }*/


    public void add(int x, int y) {
        redPath.lineTo(circleX + x, circleY - y);
        //getRootView().invalidate();
        //postInvalidate();
        this.invalidate();
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


   /* @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //直接获取屏幕中心 用来做圆点  （提成全局）
        width = this.getWidth() / 2;
        height = this.getHeight() / 2;
    }*/
}
