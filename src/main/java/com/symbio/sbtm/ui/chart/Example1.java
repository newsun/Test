package com.symbio.sbtm.ui.chart;

import org.jfree.chart.JFreeChart;

import com.opensymphony.xwork2.ActionSupport;

public class Example1 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private JFreeChart chart;
	org.apache.struts2.dispatcher.ChartResult dd;

	@Override
	public String execute() throws Exception {
		chart = FruitService.createBarChart();
		return SUCCESS;
	}

	public JFreeChart getChart() {
		return chart;
	}
}
