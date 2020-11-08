package com.example.sinpanel;

import com.github.mikephil.charting.charts.LineChart;

public class Panel {
    private LineChart leftPanel;
    private LineChart rightPanel;

    public Panel(LineChart leftPanel, LineChart rightPanel) {
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
    }

    public LineChart getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(LineChart leftPanel) {
        this.leftPanel = leftPanel;
    }

    public LineChart getRightPanel() {
        return rightPanel;
    }

    public void setRightPanel(LineChart rightPanel) {
        this.rightPanel = rightPanel;
    }
}
