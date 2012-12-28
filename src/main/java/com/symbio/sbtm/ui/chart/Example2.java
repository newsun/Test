package com.symbio.sbtm.ui.chart;

import org.jfree.chart.JFreeChart;

import com.opensymphony.xwork2.ActionSupport;

public class Example2 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private JFreeChart chart;

	@Override
	public String execute() throws Exception {
		chart = FruitService.createPaiChart();
		return SUCCESS;
	}

	public JFreeChart getChart() {
		return chart;
	}
}
