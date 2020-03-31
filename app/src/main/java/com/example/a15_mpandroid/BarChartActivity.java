package com.example.a15_mpandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.github.mikephil.charting.charts.BarChart;

public class BarChartActivity extends AppCompatActivity {

    private BarChart mBarChart;
    private Runnable mRunnable;
    private Handler mHandler;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        mBarChart = findViewById(R.id.chart_bar);
        ChartUI.mpBarChart(mBarChart, 0, 0); //time is x axis, value is y axis
        initRunnable();
    }

    private void addEntryPoint() {
        float random = (float) (Math.random() * 10 + 2);
        ChartUI.mpBarChart(mBarChart, i, random);
        i++;
    }

    private void initRunnable() {
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                addEntryPoint();
                if (i < 15)
                    mHandler.postDelayed(mRunnable, 100);
            }
        };
        mHandler.postDelayed(mRunnable, 100);
    }
}
