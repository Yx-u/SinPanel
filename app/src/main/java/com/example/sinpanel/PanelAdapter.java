package com.example.sinpanel;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.charts.LineChart;
import java.util.ArrayList;
import java.util.List;

public class PanelAdapter extends RecyclerView.Adapter<PanelAdapter.ViewHolder> {

    View view;

    LineChart lineChart1;
    LineChart lineChart2;

    static List<Panel> mPanels;

    LineChartManager leftChartManager;
    LineChartManager rightChartManager;

    public PanelAdapter(List<Panel> panelList) {
        mPanels = panelList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        LineChart leftPanel;
        LineChart rightPanel;

        public ViewHolder(@NonNull View view) {
            super(view);
            leftPanel = (LineChart) view.findViewById(R.id.left_panel);
            rightPanel = (LineChart) view.findViewById(R.id.right_panel);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.panel, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Panel panel = mPanels.get(position);

        /**
         * 初始化数据
         */
        leftChartManager = new LineChartManager(holder.leftPanel);
        rightChartManager = new LineChartManager(holder.rightPanel);

        //设置x轴的数据
        ArrayList<Float> xValues = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            xValues.add((float) i);
        }

        //设置y轴的数据()
        List<List<Float>> yValues = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Float> yValue = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                yValue.add((float) (Math.random() * 80));
            }
            yValues.add(yValue);
        }

        //颜色集合
        List<Integer> colours = new ArrayList<>();
        colours.add(Color.GREEN);
        colours.add(Color.BLUE);
        colours.add(Color.RED);
        colours.add(Color.CYAN);

        //线的名字集合
        List<String> names = new ArrayList<>();
        names.add("折线一");
        names.add("折线二");
        names.add("折线三");
        names.add("折线四");

        //创建多条折线的图表
        leftChartManager.showLineChart(xValues, yValues.get(0), names.get(1), colours.get(3));
//        leftChartManager.setDescription("温度");
//        leftChartManager.setYAxis(100, 0, 11);
//        leftChartManager.setHightLimitLine(70,"高温报警",Color.RED);

        rightChartManager.showLineChart(xValues, yValues, names, colours);
//        rightChartManager.setYAxis(100, 0, 11);
//        rightChartManager.setDescription("温度");
    }

    @Override
    public int getItemCount() {
        return mPanels.size();
    }


    public void addData(int position) {

        view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.panel, null);

        lineChart1 = view.findViewById(R.id.left_panel);
        lineChart2 = view.findViewById(R.id.right_panel);

        Panel p1 = new Panel(lineChart1, lineChart2);

//      在list中添加数据，并通知条目加入一条
        mPanels.add(position, p1);
        //添加动画
        notifyItemInserted(position);
    }
}
