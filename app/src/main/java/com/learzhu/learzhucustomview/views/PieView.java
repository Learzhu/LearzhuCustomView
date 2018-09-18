package com.learzhu.learzhucustomview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.learzhu.learzhucustomview.bean.PieData;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * PieView.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-09-18 17:20
 * @update Learzhu 2018-09-18 17:20
 * @updateDes
 * @include {@link }
 * @used {@link }
 */

/**
 * 1	构造函数	初始化(初始化画笔Paint)
 * 2	onMeasure	测量View的大小(暂时不用关心)
 * 3	onSizeChanged	确定View大小(记录当前View的宽高)
 * 4	onLayout	确定子View布局(无子View，不关心)
 * 5	onDraw	实际绘制内容(绘制饼状图)
 * 6	提供接口	提供接口(提供设置数据的接口)
 */
public class PieView extends View {
    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private ArrayList<PieData> mData;
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();

    public PieView(Context context) {
//        super(context);
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, 0);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData) {
            return;
        }
        float currentStartAngle = mStartAngle; //当前开始角度
        canvas.translate(mWidth / 2, mHeight / 2);    // 将画布坐标原点移动到中心位置
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);// // 饼状图半径
        RectF rect = new RectF(-r, -r, r, r); // // 饼状图绘制区域

        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);
            mPaint.setColor(pieData.getColor());
            canvas.drawArc(rect, currentStartAngle, pieData.getAngle(), true, mPaint);
            currentStartAngle += pieData.getAngle();
        }
    }

    public void setStartAngle(int startAngle) {
        this.mStartAngle = startAngle;
        invalidate();//刷新
    }

    public void setData(ArrayList<PieData> data) {
        this.mData = data;
        initData(mData);
        invalidate();//刷新
    }

    private void initData(ArrayList<PieData> data) {
        if (null == data || data.size() == 0) {
            //数据异常 直接返回
            return;
        }

        float sumValue = 0;
        for (int i = 0; i < data.size(); i++) {
            PieData pieData = data.get(i);
            sumValue += pieData.getValue(); //计算数值的和

            int j = i % mColors.length;
            pieData.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < data.size(); i++) {
            PieData pieData = data.get(i);
            float percentange = pieData.getValue() / sumValue; //百分比
            float angle = percentange * 360; //对于的角度
            pieData.setPercentage(percentange);
            pieData.setAngle(angle);
            sumAngle += angle;
            Log.i(TAG, " " + pieData.getAngle());

        }
    }
}
