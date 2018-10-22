package com.learzhu.learzhucustomview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * CanvasDynamicView.java是Canvas之画布操作类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-09-25 11:27
 * @update Learzhu 2018-09-25 11:27
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class CanvasDynamicView extends View {
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

    public CanvasDynamicView(Context context) {
//        super(context);
        this(context, null);
    }

    public CanvasDynamicView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
        initPaint();
    }

    public CanvasDynamicView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvasDynamicView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
//        translate(canvas);
//        scale(canvas);
//        scaleChangeCenter(canvas);
//        sacleMinus(canvas);
//        scaleMultiply(canvas);
//        rotate(canvas);
//        rotateMultiply(canvas);
//        skew(canvas);
        saveAndRestore(canvas);
    }

    /**
     * translate是坐标系的移动，可以为图形绘制选择一个合适的坐标系。
     * 请注意，位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动
     *
     * @param canvas
     */
    private void translate(Canvas canvas) {
        // 在坐标原点绘制一个黑色圆形
        mPaint.setColor(Color.BLACK);
        canvas.translate(200, 200);
        canvas.drawCircle(0, 9, 100, mPaint);

        // 在坐标原点绘制一个蓝色圆形
        mPaint.setColor(Color.BLUE);
        canvas.translate(200, 200);
        canvas.drawCircle(0, 0, 100, mPaint);
    }

    /**
     * 这两个方法中前两个参数是相同的分别为x轴和y轴的缩放比例。
     * 而第二种方法比前一种多了两个参数，用来控制缩放中心位置的。
     *
     * @param canvas
     */
    private void scale(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rect = new RectF(0, -400, 400, 0);   // 矩形区域
        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect, mPaint);
        canvas.scale(0.5f, 0.5f);                // 画布缩放

        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect, mPaint);
    }

    private void scaleChangeCenter(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rect = new RectF(0, -400, 400, 0);   // 矩形区域
        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect, mPaint);
        canvas.scale(0.5f, 0.5f, 200, 0);          // 画布缩放  <-- 缩放中心向右偏移了200个单位
        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect, mPaint);
    }


    /**
     * 当缩放比例为负数的时候会根据缩放中心轴进行翻转
     *
     * @param canvas
     */
    private void sacleMinus(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rect = new RectF(0, -400, 400, 0);   // 矩形区域
        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect, mPaint);
        canvas.scale(-0.5f, -0.5f);          // 画布缩放
        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect, mPaint);
    }

    /**
     * @param canvas
     */
    private void scaleMultiply(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rect = new RectF(-400, -400, 400, 400);   // 矩形区域
        for (int i = 0; i <= 20; i++) {
            canvas.scale(0.9f, 0.9f);
            canvas.drawRect(rect, mPaint);
        }
    }

    /**
     * 和缩放一样，第二种方法多出来的两个参数依旧是控制旋转中心点的。
     *
     * @param canvas
     */
    private void rotate(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rect = new RectF(0, -400, 400, 0);   // 矩形区域
        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect, mPaint);
        canvas.rotate(180);                     // 旋转180度 <-- 默认旋转中心为原点
        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect, mPaint);
    }

    /**
     * 旋转也是可叠加的
     *
     * @param canvas
     */
    private void rotateMultiply(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawCircle(0, 0, 400, mPaint);          // 绘制两个圆形
        canvas.drawCircle(0, 0, 380, mPaint);
        for (int i = 0; i <= 360; i += 10) {               // 绘制圆形之间的连接线
            canvas.drawLine(0, 380, 0, 400, mPaint);
            canvas.rotate(10);
        }
    }

    /**
     * skew这里翻译为错切，错切是特殊类型的线性变换
     *
     * @param canvas
     */
    private void skew(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rect = new RectF(0, 0, 200, 200);   // 矩形区域
        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect, mPaint);
        canvas.skew(1, 0);                       // 水平错切 <- 45度
        canvas.skew(0, 1);                       // 垂直错切
        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect, mPaint);
    }

    /**
     * 快照(save)和回滚(restore)
     * 画布的操作是不可逆的，而且很多画布操作会影响后续的步骤，
     * save	把当前的画布的状态进行保存，然后放入特定的栈中
     * saveLayerXxx	新建一个图层，并放入特定的栈中
     * restore	把栈中最顶层的画布状态取出来，并按照这个状态恢复当前的画布
     * restoreToCount	弹出指定位置及其以上所有的状态，并按照指定位置的状态进行恢复
     * getSaveCount	获取栈中内容的数量(即保存次数)
     * 保存全部状态
     * public int save()
     * // 根据saveFlags参数保存一部分状态
     * public int save (int saveFlags)
     * <p>
     * restore
     * 状态回滚，就是从栈顶取出一个状态然后根据内容进行恢复。
     * <p>
     * save();      //保存状态
     * ...          //具体操作
     * restore();   //回滚到之前的状态
     *
     * @param canvas
     */
    private void saveAndRestore(Canvas canvas) {
        scale(canvas);
        scaleChangeCenter(canvas);
        sacleMinus(canvas);
//        save(canvas);
        canvas.save();
        canvas.restoreToCount(1);
    }
}
