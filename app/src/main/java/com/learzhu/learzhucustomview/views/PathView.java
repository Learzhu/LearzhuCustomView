package com.learzhu.learzhucustomview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * PathView.java是自定义控件项目的路径类。
 * 使用Path不仅能够绘制简单图形，也可以绘制这些比较复杂的图形。
 * 另外，根据路径绘制文本和剪裁画布都会用到Path。
 *
 * @author Learzhu
 * @version 2.0.0 2018-10-24 10:59
 * @update Learzhu 2018-10-24 10:59
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class PathView extends View {
    // 1.创建一个画笔
    private Paint mPaint = new Paint();
    // 宽高
    private int mWidth, mHeight;

    // 2.初始化画笔
    private void initPaint() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10f);
    }

    public PathView(Context context) {
//        super(context);
        this(context, null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        lineTo(canvas);
        addArcAndArcTo(canvas);
    }

    /**
     * 画线条
     *
     * @param canvas
     */
    private void lineTo(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心(宽高数据在onSizeChanged中获取)
        Path path = new Path();                     // 创建Path
        path.lineTo(200, 200);                      // lineTo
        path.lineTo(200, 0);

        canvas.drawPath(path, mPaint);
    }

    /**
     * 移动下一次操作的起点位置 不影响之前的操作 影响之后的操作
     *
     * @param canvas
     */
    private void moveTo(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心
        Path path = new Path();                     // 创建Path
        path.lineTo(200, 200);                      // lineTo
        path.moveTo(200, 100);                       // moveTo
        path.lineTo(200, 0);                         // lineTo

        canvas.drawPath(path, mPaint);              // 绘制Path
    }

    /**
     * setLastPoint是重置上一次操作的最后一个点，
     * 在执行完第一次的lineTo的时候，
     * 最后一个点是A(200,200),而setLastPoint更改最后一个点为C(200,100),
     * 所以在实际执行的时候，第一次的lineTo就不是从原点O到A(200,200)的连线了，而变成了从原点O到C(200,100)之间的连线了。
     *
     * @param canvas
     */
    private void setLastPoint(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心
        Path path = new Path();                     // 创建Path
        path.lineTo(200, 200);                      // lineTo
        path.setLastPoint(200, 100);                 // setLastPoint
        path.lineTo(200, 0);                         // lineTo

        canvas.drawPath(path, mPaint);              // 绘制Path
    }

    /**
     * close方法用于连接当前最后一个点和最初的一个点(如果两个点不重合的话)，
     * 最终形成一个封闭的图形。
     * close的作用是封闭路径，与连接当前最后一个点和第一个点并不等价。
     * 如果连接了最后一个点和第一个点仍然无法形成封闭图形，则close什么 也不做。
     *
     * @param canvas
     */
    private void close(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心
        Path path = new Path();                     // 创建Path
        path.lineTo(200, 200);                      // lineTo
        path.lineTo(200, 0);                         // lineTo
        path.close();                               // close

        canvas.drawPath(path, mPaint);              // 绘制Path
    }

    private void addArcAndArcTo(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心
        Path path = new Path();
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        //会限定矩形的位置空间 超出部分会被切割
        path.addRect(-100, -100, 100, 100, Path.Direction.CW);

//        path.setLastPoint(-80, 80);                // <-- 重置最后一个点的位
        path.setLastPoint(-130, 130);                // <-- 重置最后一个点的位
//        path.setLastPoint(-150, 150);                // <-- 重置最后一个点的位
//        path.setLastPoint(-300, 300);                // <-- 重置最后一个点的位
//        path.close();
//        path.moveTo(-300, 300);
        canvas.drawPath(path, mPaint);
    }
}
