package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        GraphView graph = findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 20630030),
                new DataPoint(2, 11199456),
                new DataPoint(3, 14121722),
        });
        PointsGraphSeries<DataPoint> seriesPoint = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 20630030),
                new DataPoint(2, 11199456),
                new DataPoint(3, 14121722),
        });
        graph.addSeries(series);
        graph.addSeries(seriesPoint);
    }
}