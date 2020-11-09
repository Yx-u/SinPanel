package com.example.sinpanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    View view;

    LineChart lineChart1;
    LineChart lineChart2;

    LineChartManager lineChartManager1;
    LineChartManager lineChartManager2;

    PanelAdapter adapter;
    Button add;

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
        adapter = new PanelAdapter(panelList);
        recyclerView.setAdapter(adapter);
    }

    //初始化面板
    public void initPanels(){

        //设置按钮点击事件，点击按钮，添加面板
        add = (Button) findViewById(R.id.add_panel);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addData(panelList.size());
            }
        });


        //引入布局
        view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.panel, null);

        lineChart1 = view.findViewById(R.id.left_panel);
        lineChart2 = view.findViewById(R.id.right_panel);

//        lineChartManager1 = new LineChartManager(lineChart1);
//        lineChartManager2 = new LineChartManager(lineChart2);



        for (int i = 0; i<2;i++){
            Panel p1 = new Panel(lineChart1, lineChart2);
            panelList.add(p1);

//            Panel p2 = new Panel(lineChart1, lineChart2);
//            panelList.add(p2);
        }
    }

}
