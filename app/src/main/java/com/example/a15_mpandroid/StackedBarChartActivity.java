package com.example.a15_mpandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.github.mikephil.charting.charts.BarChart;

public class StackedBarChartActivity extends AppCompatActivity {

    private BarChart mStackedBarChart;
    private Runnable mRunnable;
    private Handler mHandler;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stacked_bar_chart);
        mStackedBarChart = findViewById(R.id.chart_stacked_bar);
        ChartUI.mpStackedBarChart(mStackedBarChart, 0, new float[]{0,0,0});
        initialRunnable();
    }

    private void addEntryPoint()
    {
        float tamRandom = (float) (Math.random() * 6 + 25); //25~30
        float humRandom = (float) (Math.random() * 10 + 40);
        float naIonRandom = (float) (Math.random() * 10 + 20);
        ChartUI.mpStackedBarChart(mStackedBarChart, i, new float[]{tamRandom, humRandom, naIonRandom});
        i++;
    }

    private void initialRunnable(){
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                addEntryPoint();
                if(i < 16)
                    mHandler.postDelayed(mRunnable, 100);
            }
        };
        mHandler.postDelayed(mRunnable, 100);
    }
}
