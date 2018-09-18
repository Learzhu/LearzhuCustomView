package com.learzhu.learzhucustomview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.learzhu.learzhucustomview.bean.PieData
import com.learzhu.learzhucustomview.views.PieView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val color = resources.getColor(R.color.red)
        drawPieView()
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
}
