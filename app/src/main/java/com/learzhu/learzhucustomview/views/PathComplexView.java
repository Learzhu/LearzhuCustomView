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
 * PathComplexView.java是自定义控件项目的Path计算的图形的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-10-31 14:24
 * @update Learzhu 2018-10-31 14:24
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class PathComplexView extends View {

    // 1.创建一个画笔
    private Paint mPaint = new Paint();
    // 宽高
    private int mWidth, mHeight;

    public PathComplexView(Context context) {
        super(context);
    }

    public PathComplexView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
    }

    public PathComplexView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public PathComplexView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    // 2.初始化画笔
    private void initPaint() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawEvenOddRules(canvas);
//        drawView(canvas);
    }

    private void drawEvenOddRules(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);                   // 设置画布模式为填充
        canvas.translate(mWidth / 2, mWidth / 2);          // 移动画布(坐标系)
        Path path = new Path();                                     // 创建Path

        path.setFillType(Path.FillType.EVEN_ODD);                   // 设置Path填充模式为 奇偶规则
//        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);            // 反奇偶规则
//        path.setFillType(Path.FillType.WINDING);            // 反奇偶规则
//        path.setFillType(Path.FillType.INVERSE_WINDING);            // 反奇偶规则

//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);         // 给Path中添加一个矩形
        path.addRect(-200, -200, 200, 200, Path.Direction.CCW);         // 给Path中添加一个矩形
        canvas.drawPath(path, mPaint);
    }

    private void drawView(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);                   // 设置画笔模式为填充
        canvas.translate(mWidth / 2, mHeight / 2);          // 移动画布(坐系)
        Path path = new Path();                                     // 创建Path

        // 添加小正方形 (通过这两行代码来控制小正方形边的方向,从而演示不同的效果)
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//        path.addRect(-200, -200, 200, 200, Path.Direction.CCW);

        // 添加大正方形
        path.addRect(-400, -400, 400, 400, Path.Direction.CCW);
        path.setFillType(Path.FillType.WINDING);                    // 设置Path填充模式为非零环绕规则
//        path.setFillType(Path.FillType.INVERSE_WINDING);                    // 设置Path填充模式为非零环绕规则
        canvas.drawPath(path, mPaint);                       // 绘制Path
    }

    private void drawLine(Canvas canvas) {
        Path path = new Path();
        path.moveTo(100, 100);
        //相对坐标
        path.rLineTo(100, 200);
        canvas.drawPath(path, mPaint);
    }

    private void drawTaiJi(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);
        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path();
        Path path4 = new Path();

        path1.addCircle(0, 0, 200, Path.Direction.CW);
        path2.addRect(0, -200, 200, 200, Path.Direction.CW);
        path3.addCircle(0, -100, 100, Path.Direction.CW);
        path4.addCircle(0, 100, 100, Path.Direction.CCW);

        //差集
        // 对 path1 和 path2 执行布尔运算，运算方式由第二个参数指定，运算结果存入到path1中。
        path1.op(path2, Path.Op.DIFFERENCE);
        //并集
        path1.op(path3, Path.Op.UNION);
        path1.op(path4, Path.Op.DIFFERENCE);

        canvas.drawPath(path1, mPaint);
    }
}
