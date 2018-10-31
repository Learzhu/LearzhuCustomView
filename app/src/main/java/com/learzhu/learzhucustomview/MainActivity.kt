package com.learzhu.learzhucustomview

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.learzhu.learzhucustomview.bean.PieData
import com.learzhu.learzhucustomview.bezierviewpager.BezierViewPagerActivity
import com.learzhu.learzhucustomview.views.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val color = resources.getColor(R.color.red)
//        drawPieView()
//        drawDynamicView()
//        drawPathView()
        drawPathBezierView()
        drawPathBezier2View()
        drawPathLoveView()
        startActivity1()
    }

    private fun startActivity1() {
//        startActivity(Intent(this, BezierViewPagerActivity.class))
        //方法有3
        startActivity(Intent(MainActivity@ this, BezierViewPagerActivity::class.java))
//        startActivity(Intent(this@MainActivity, BezierViewPagerActivity::class.java))
//        startActivity(Intent(this, BezierViewPagerActivity::class.java))
    }

    private fun drawPathLoveView() {
        findViewById<LoveView>(R.id.path_love_view)
    }

    private fun drawPathBezier2View() {
        findViewById<Bezier2>(R.id.path_bezier2)
    }

    private fun drawPathBezierView() {
        val pathBezierView: PathBezierView = findViewById<PathBezierView>(R.id.path_bezier_view)

    }

    private fun drawPathView() {
        val pathView = findViewById<PathView>(R.id.path_view)
    }

    /**
     * 画一个饼状图
     */
    private fun drawPieView() {
        val pieView = findViewById<PieView>(R.id.pieview)
        pieView.setStartAngle(0)
        val data = listOf<PieData>()
        val pieDataA = PieData("A", 20f)
        val pieDataB = PieData("B", 50f)
        val pieDataC = PieData("C", 70f)
        val pieDataD = PieData("D", 90f)
        val pieDatas = ArrayList<PieData>();
        pieDatas.add(pieDataA)
        pieDatas.add(pieDataB)
        pieDatas.add(pieDataC)
        pieDatas.add(pieDataD)
        //        pieDatas.add(pieDataA, pieDataB, pieDataC, pieDataD)
        //        pieView.setData(listOf<PieData>(pieDataA, pieDataB, pieDataC, pieDataD))
        pieView.setData(pieDatas)
        pieView.invalidate()
    }

    private fun drawDynamicView() {
        val dynamicView = findViewById<CanvasDynamicView>(R.id.canvas_dynamic_view)
    }
}
