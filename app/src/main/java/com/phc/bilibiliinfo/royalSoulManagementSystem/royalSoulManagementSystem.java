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
import com.google.gson.Gson;
import com.phc.bilibiliinfo.R;
import com.phc.bilibiliinfo.gsonBean.bilibilionline;
import com.phc.bilibiliinfo.interfaceAll.upUi;
import com.phc.bilibiliinfo.utils.httpUtil;

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

        httpUtil util = new httpUtil(false, getContext(), new upUi() {
            @Override
            public void NewView(String callBackJson) {
                int[] item = new int[12];
                bilibilionline bill = new Gson().fromJson(callBackJson, bilibilionline.class);
                item[0] = bill.getData().getRegion_count().get_$13();
                item[1] = bill.getData().getRegion_count().get_$167();
                item[2] = bill.getData().getRegion_count().get_$119();
                item[3] = bill.getData().getRegion_count().get_$202();
                item[4] = bill.getData().getRegion_count().get_$1();
                item[5] = bill.getData().getRegion_count().get_$3();
                item[6] = bill.getData().getRegion_count().get_$129();
                item[7] = bill.getData().getRegion_count().get_$181();
                item[8] = bill.getData().getRegion_count().get_$5();
                item[9] = bill.getData().getRegion_count().get_$188();
                item[10] = bill.getData().getRegion_count().get_$155();
                item[11] = bill.getData().getRegion_count().get_$4();
                onLineView(item);
                onPieView(item);
                onBarView(item);
            }
        });
        util.execute("https://api.bilibili.com/x/web-interface/online?&amp;jsonp=jsonp");
        return inflate;
    }


    private void onLineView(int[] item) {
        ArrayList<Entry> yVals = new ArrayList<>();
        for (int i = 0; i < item.length; i++) {
            yVals.add(new Entry(i, item[i]));
        }
        LineDataSet lineDataSet = new LineDataSet(yVals, "0");
        LineData data = new LineData(lineDataSet);
        lineChar.setData(data);
        lineChar.invalidate();
    }

    private void onPieView(int[] item) {
        ArrayList<PieEntry> yVals = new ArrayList<>();
        for (int i = 0; i < item.length; i++) {
            yVals.add(new PieEntry(item[i]));
        }
        PieDataSet dataSet = new PieDataSet(yVals, "1");
        int[] color = {0xffFFB6C1, 0xffEE82EE, 0xff0000FF, 0xffB0C4DE, 0xffAFEEEE};
        dataSet.setColors(color);
        PieData data = new PieData(dataSet);
        pieChar.setData(data);
        pieChar.setDrawHoleEnabled(false);
        pieChar.setRotationEnabled(false);
        pieChar.invalidate();
    }


    private void onBarView(int[] item) {
        ArrayList<BarEntry> yVals = new ArrayList<>();
        for (int i = 0; i < item.length; i++) {
            yVals.add(new BarEntry(i, item[i]));
        }
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
