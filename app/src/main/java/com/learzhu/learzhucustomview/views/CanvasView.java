package com.learzhu.learzhucustomview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * CanvasView.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-09-18 16:03
 * @update Learzhu 2018-09-18 16:03
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class CanvasView extends View {
    // 1.创建一个画笔
    private Paint mPaint = new Paint();


    // 2.初始化画笔
    private void initPaint() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);
    }

    // 3.在构造函数中初始化
    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.画点
        canvas.drawPoint(200, 200, mPaint);
        canvas.drawPoints(new float[]{ ////绘制一组点，坐标位置由float数组指定
                500f, 500f,
                500, 600,
                500, 700
        }, mPaint);

        //2.画线
        canvas.drawLine(300, 300, 500, 600, mPaint);
        canvas.drawLines(new float[]{
                100, 200, 200, 200,
                100, 300, 200, 300
        }, mPaint);

        //3.画矩形
        canvas.drawRect(100, 100, 800, 400, mPaint);

        //两者最大的区别就是精度不同，Rect是int(整形)的，而RectF是float(单精度浮点型)的。除了精度不同，两种提供的方法也稍微存在差别，在这里我们暂时无需关注，想了解更多参见官方文档 Rect 和 RectF
        Rect rect = new Rect(100, 100, 800, 400);
        canvas.drawRect(rect, mPaint);

        RectF rectF = new RectF(100, 100, 800, 400);
        canvas.drawRect(rectF, mPaint);

        //4.圆角矩形
        RectF rectF1 = new RectF(50, 50, 100, 200);
        canvas.drawRoundRect(rectF1, 30, 30, mPaint);

        canvas.drawRoundRect(100, 100, 400, 600, 30, 30, mPaint);


        //5.画椭圆
        // 矩形
        RectF rectF2 = new RectF(100, 100, 800, 400);

        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF2, mPaint);

        // 绘制圆角矩形
        mPaint.setColor(Color.BLUE);
        canvas.drawRoundRect(rectF2, 700, 400, mPaint);

        // 第一种 绘制椭圆实际上就是绘制一个矩形的内切图形
        RectF rectF3 = new RectF(100, 100, 800, 400);
        canvas.drawOval(rectF3, mPaint);

        // 第二种
        canvas.drawOval(100, 100, 800, 400, mPaint);

        canvas.drawCircle(500, 500, 400, mPaint);  // 绘制一个圆心坐标在(500,500)，半径为400 的圆。

        //6.绘制圆弧：

    }

    /**
     * 画圆弧
     *
     * @param canvas
     */
    public void drawArc(Canvas canvas) {
        RectF rectF = new RectF(100, 100, 800, 400);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF, mPaint);

        // 绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 0, 90, false, mPaint);

        //-------------------------------------
        RectF rectF2 = new RectF(100, 600, 800, 900);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF2, mPaint);

        // 绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF2, 0, 90, true, mPaint);
    }

    /**
     * 正圆弧
     *
     * @param canvas
     */
    public void drawArcRight(Canvas canvas) {
        RectF rectF = new RectF(100, 100, 600, 600);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF, mPaint);

        // 绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 0, 90, false, mPaint);

        //-------------------------------------

        RectF rectF2 = new RectF(100, 700, 600, 1200);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF2, mPaint);

        // 绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF2, 0, 90, true, mPaint);
    }
}
