package com.phc.bilibiliinfo.royalSoulManagementSystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.phc.bilibiliinfo.R;

import java.util.ArrayList;


public class royalSoulManagementSystem extends Fragment {

    private LineChart lineChar;
    private PieChart pieChar;
    private BarChart barChar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_royal_soul_management_system, container, false);
        initView(inflate);
        onLineView();
        onPieView();
        onBarView();
        return inflate;
    }


    private void onLineView() {
        ArrayList<Entry> yVals = new ArrayList<>();
        yVals.add(new Entry(0, 3));
        yVals.add(new Entry(1, 5));
        yVals.add(new Entry(2, 6));
        yVals.add(new Entry(3, 4));
        yVals.add(new Entry(4, 9));
        LineDataSet lineDataSet = new LineDataSet(yVals, "0");
        LineData data = new LineData(lineDataSet);
        lineChar.setData(data);
        lineChar.invalidate();
    }

    private void onPieView() {
        ArrayList<PieEntry> yVals = new ArrayList<>();
        yVals.add(new PieEntry(3.1F));
        yVals.add(new PieEntry(2.3F));
        yVals.add(new PieEntry(1.3F));
        yVals.add(new PieEntry(1.0F));
        yVals.add(new PieEntry(2.3F));
        PieDataSet dataSet = new PieDataSet(yVals, "1");
        int[] color = {0xffFFB6C1, 0xffEE82EE, 0xff0000FF, 0xffB0C4DE, 0xffAFEEEE};
        dataSet.setColors(color);
        PieData data = new PieData(dataSet);
        pieChar.setData(data);
        pieChar.invalidate();
    }


    private void onBarView() {
        ArrayList<BarEntry> yVals = new ArrayList<>();
        yVals.add(new BarEntry(0, 3));
        yVals.add(new BarEntry(1, 5));
        yVals.add(new BarEntry(2, 8));
        yVals.add(new BarEntry(3, 4));
        yVals.add(new BarEntry(4, 9));
        BarDataSet barDataSet = new BarDataSet(yVals, "2");
        BarData data = new BarData(barDataSet);
        barChar.setData(data);
        barChar.invalidate();
    }

    private void initView(View inflate) {
        lineChar = (LineChart) inflate.findViewById(R.id.line_char);
        pieChar = (PieChart) inflate.findViewById(R.id.pie_char);
        barChar = (BarChart) inflate.findViewById(R.id.bar_char);
    }
}
