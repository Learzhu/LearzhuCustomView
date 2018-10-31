package com.learzhu.learzhucustomview.bezierviewpager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.learzhu.learzhucustomview.R

class BezierViewPagerActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bezier_view_pager)

    }

//    fun initViewPager() {
//        ImageLoadFactory.getInstance().setImageClient(new GlideImageClient ());
//        initImgList();
//
//        int mWidth = getWindowManager ().getDefaultDisplay().getWidth();
//        float heightRatio = 0.565f;  //高是宽的 0.565 ,根据图片比例
//
//        CardPagerAdapter cardAdapter = new CardPagerAdapter(getApplicationContext());
//        cardAdapter.addImgUrlList(imgList);
//
//
//        //设置阴影大小，即vPage  左右两个图片相距边框  maxFactor + 0.3*CornerRadius   *2
//        //设置阴影大小，即vPage 上下图片相距边框  maxFactor*1.5f + 0.3*CornerRadius
//        int maxFactor = mWidth / 25;
//        cardAdapter.setMaxElevationFactor(maxFactor);
//
//        int mWidthPading = mWidth / 8;
//
//        //因为我们adapter里的cardView CornerRadius已经写死为10dp，所以0.3*CornerRadius=3
//        //设置Elevation之后，控件宽度要减去 (maxFactor + dp2px(3)) * heightRatio
//        //heightMore 设置Elevation之后，控件高度 比  控件宽度* heightRatio  多出的部分
//        float heightMore =(1.5f * maxFactor + dp2px(3)) - (maxFactor + dp2px(3)) * heightRatio;
//        int mHeightPading =(int)(mWidthPading * heightRatio - heightMore);
//
//        BezierViewPager viewPager =(BezierViewPager) findViewById (qdx.bezierviewpager_compile.R.id.view_page);
//        viewPager.setLayoutParams(new RelativeLayout . LayoutParams (mWidth, (int)(mWidth * heightRatio)));
//        viewPager.setPadding(mWidthPading, mHeightPading, mWidthPading, mHeightPading);
//        viewPager.setClipToPadding(false);
//        viewPager.setAdapter(cardAdapter);
//        viewPager.showTransformer(0.2f);
//
//
//        BezierRoundView bezRound =(BezierRoundView) findViewById (qdx.bezierviewpager_compile.R.id.bezRound);
//        bezRound.attach2ViewPage(viewPager);
//
//        ImageView iv_bg =(ImageView) findViewById (qdx.bezierviewpager_compile.R.id.iv_bg);
//        iv_bg.setLayoutParams(new RelativeLayout . LayoutParams (mWidth, (int)((mWidth * heightRatio) + dp2px(60))));
//    }

}
