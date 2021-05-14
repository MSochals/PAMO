package com.example.bmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.series.PointsGraphSeries
import com.jjoe64.graphview.series.DataPoint

class GraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        val graph = findViewById(R.id.graph) as GraphView

        fun DP(a: Int, b: Int): DataPoint {
            return DataPoint(a.toDouble(), b.toDouble())
        }

        val points = arrayOf(DP(1, 20630030), DP(2, 11199456), DP(3, 14121722))
        val series = LineGraphSeries<DataPoint>(points)
        val seriesPoint = PointsGraphSeries<DataPoint>(points)

        graph.addSeries(series)
        graph.addSeries(seriesPoint)
    }

}