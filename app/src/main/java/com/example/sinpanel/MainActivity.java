package com.example.sinpanel;

import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    View view;

    LineChart lineChart1;
    LineChart lineChart2;

    LineChartManager lineChartManager1;
    LineChartManager lineChartManager2;

    private List<Panel> panelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initPanels();

        //初始化面板
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.panel_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        PanelAdapter adapter = new PanelAdapter(panelList);

        recyclerView.setAdapter(adapter);
    }

    //初始化面板
    public void initPanels(){

        view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.panel, null);

        lineChart1 = view.findViewById(R.id.left_panel);
        lineChart2 = view.findViewById(R.id.right_panel);
//
//        lineChartManager1 = new LineChartManager(lineChart1);
//        lineChartManager2 = new LineChartManager(lineChart2);



        for (int i = 0; i<3;i++){
            Panel p1 = new Panel(lineChart1, lineChart2);
            panelList.add(p1);

            Panel p2 = new Panel(lineChart1, lineChart2);
            panelList.add(p2);
        }
    }

}
