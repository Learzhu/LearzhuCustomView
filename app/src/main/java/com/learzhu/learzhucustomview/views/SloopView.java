package com.learzhu.learzhucustomview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.learzhu.learzhucustomview.R;

/**
 * SloopView.java是自定义View的类。
 *
 * @author Learzhu
 * @version 2.0.0 2018-09-18 15:38
 * @update Learzhu 2018-09-18 15:38
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class SloopView extends View {
    /**
     * 1.构造函数
     * 构造函数是View的入口，可以用于初始化一些的内容，和获取自定义属性。
     *
     * @param context
     */
    //一般在直接New一个View的时候调用。
    public SloopView(Context context) {
        super(context);
    }

    ////一般在layout文件中使用的时候会调用，关于它的所有属性(包括自定义属性)都会包含在attrs中传递进来。
    public SloopView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, R.attr.imageButtonStyle);
    }
    //即使你在View中使用了Style这个属性也不会调用三个参数的构造函数，所调用的依旧是两个参数的构造函数。

    //有三个参数的构造函数中第三个参数是默认的Style，这里的默认的Style是指它在当前Application或Activity所用的Theme中的默认Style，且只有在明确调用的时候才会生效，以系统中的ImageButton为例
    public SloopView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
        this(context, attrs, defStyleAttr, 0);
    }

    //有四个参数的构造函数在API21的时候才添加上，暂不考虑。
    public SloopView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    /**
     *2. 测量View大小(onMeasure)
     Q: 为什么要测量View大小？
     A: View的大小不仅由自身所决定，同时也会受到父控件的影响，为了我们的控件能更好的适应各种情况，一般会自己进行测量。
     */
    /**
     * 但它们其实不是宽和高， 而是由宽、高和各自方向上对应的测量模式来合成的一个值：
     * <p>
     * 测量模式一共有三种， 被定义在 Android 中的 View 类的一个内部类View.MeasureSpec中：
     * <p>
     * 模式	二进制数值	描述
     * UNSPECIFIED	00	默认值，父控件没有给子view任何限制，子View可以设置为任意大小。
     * EXACTLY	01	表示父控件已经确切的指定了子View的大小。
     * AT_MOST	10	表示子View具体大小没有尺寸限制，但是存在上限，上限一般为父View大小。
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    /**
     * mark1:在实际运用之中只需要记住有三种模式，用 MeasureSpec 的 getSize是获取数值， getMode是获取模式即可。
     * 注意：
     * 2.如果对View的宽高进行修改了，不要调用 super.onMeasure( widthMeasureSpec, heightMeasureSpec); 要调用 setMeasuredDimension( widthsize, heightsize); 这个函数。
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);      //取出宽度的确切数值
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);      //取出宽度的测量模式

        int heightsize = MeasureSpec.getSize(heightMeasureSpec);    //取出高度的确切数值
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);    //取出高度的测量模式
    }

    /**
     * 3.确定View大小(onSizeChanged)
     这个函数在视图大小发生改变时调用。
     */
    /**
     * 测量完View并使用setMeasuredDimension函数之后View的大小基本上已经确定了
     * View的大小不仅由View本身控制，而且受父控件的影响，所以我们在确定View大小的时候最好使用系统提供的onSizeChanged回调函数。
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 4. 确定子View布局位置(onLayout)
     * 确定布局的函数是onLayout，它用于确定子View的位置，在自定义ViewGroup中会用到，他调用的是子View的layout函数。
     *
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 5.绘制内容(onDraw)
     * onDraw是实际绘制的部分，也就是我们真正关心的部分，使用的是Canvas绘图。
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /**
     * 6.对外提供操作方法和监听回调
     自定义完View之后，一般会对外暴露一些接口，用于控制View的状态等，或者监听View的变化.
     */
}
