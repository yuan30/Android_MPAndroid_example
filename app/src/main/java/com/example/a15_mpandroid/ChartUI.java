package com.example.a15_mpandroid;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class ChartUI {

    //MP Bar Chart
    public static void mpBarChart(BarChart barChart, float time, float value)
    {
        BarData barData = barChart.getData(); //範型 Template
        if(barData == null){
            barData = new BarData();
            barChart.setData(barData);

            barChart.setTouchEnabled(true);
        } else{
            IBarDataSet iBarDataSet = barData.getDataSetByIndex(0);
            if(iBarDataSet == null){
                iBarDataSet = createBarDataSet();
                barData.addDataSet(iBarDataSet);
            }
            iBarDataSet.addEntry(new BarEntry(time, value));
            barData.notifyDataChanged();
            barChart.notifyDataSetChanged();
            barChart.moveViewToX(time);
        }
    }

    private static BarDataSet createBarDataSet(){
        List<BarEntry> barEntryList = new ArrayList<>();
        BarDataSet barDataSet = new BarDataSet(barEntryList, "First data");
        barDataSet.setHighlightEnabled(true);
        barDataSet.setHighLightColor(Color.parseColor("#FF0000"));
        return barDataSet;
    }

    public static void mpStackedBarChart(BarChart stackedBarChart, float time, float[] value)
    {
        BarData barData = stackedBarChart.getData(); //範型 Template
        if(barData == null){
            barData = new BarData();
            stackedBarChart.setData(barData);

            stackedBarChart.setTouchEnabled(true);
        } else{
            IBarDataSet iBarDataSet = barData.getDataSetByIndex(0);
            if(iBarDataSet == null){
                iBarDataSet = createStackedBarDataSet();
                barData.addDataSet(iBarDataSet);
            }
            iBarDataSet.addEntry(new BarEntry(time, value[(int)time % 3]));
            barData.notifyDataChanged();
            stackedBarChart.notifyDataSetChanged();
            stackedBarChart.moveViewToX(time);
        }
    }

    private static BarDataSet createStackedBarDataSet(){
        List<BarEntry> barEntryList = new ArrayList<>();
        BarDataSet barDataSet = new BarDataSet(barEntryList, "Mutipied data");
        barDataSet.setColors(getChartColors());
        barDataSet.setHighlightEnabled(true);
        barDataSet.setHighLightColor(Color.parseColor("#FF0000"));
        return barDataSet;
    }

    private static int[] getChartColors() {
        int[] colors = new int[]{Color.parseColor("#576F86"),
                Color.parseColor("#E7655A"),
                Color.parseColor("#F6CE5D")
                };
        return colors;
    }
}
