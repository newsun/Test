package com.symbio.sbtm.ui.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class FruitService {
	public static JFreeChart createBarChart() {
		CategoryDataset dataset = getDataSet2();
		JFreeChart chart = ChartFactory.createBarChart3D("bug throughout", // 图表标题
				"product", // label1
				"count", // label2
				dataset, // dataset
				PlotOrientation.VERTICAL, // graph direction:
											// vertical/horizontal
				true, // 是否显示图例(对于简单的柱状图必须是false)
				true, // 是否生成工具
				true // 是否生成URL链接
				);
		return chart;
	}

	private static CategoryDataset getDataSet2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "user1", "area1");
		dataset.addValue(100, "user2", "area1");
		dataset.addValue(100, "user3", "area1");
		dataset.addValue(200, "user1", "area2");
		dataset.addValue(200, "user2", "area2");
		dataset.addValue(200, "user3", "area2");
		dataset.addValue(300, "user1", "area3");
		dataset.addValue(300, "user2", "area3");
		dataset.addValue(300, "user3", "area3");
		dataset.addValue(400, "user1", "area4");
		dataset.addValue(400, "user2", "area4");
		dataset.addValue(400, "user3", "area4");
		dataset.addValue(500, "user1", "area5");
		dataset.addValue(500, "user2", "area5");
		dataset.addValue(500, "user3", "area4");
		return dataset;
	}

	public static JFreeChart createPaiChart() {
		DefaultPieDataset data = getDataSet();
		JFreeChart chart = ChartFactory.createPieChart3D("bug throughout", // 图表标题
				data, true, // 是否显示图例
				false, false);
		PiePlot plot = (PiePlot) chart.getPlot();
		resetPiePlot(plot);
		return chart;
	}

	private static void resetPiePlot(PiePlot plot) {
		String unitSytle = "{0}={1}({2})";

		plot.setNoDataMessage("No data。");
		plot.setNoDataMessagePaint(Color.red);

		// 指定 section 轮廓线的厚度(OutlinePaint不能为null)
		plot.setOutlineStroke(new BasicStroke(0));

		// 设置第一个 section 的开始位置，默认是12点钟方向
		plot.setStartAngle(90);

		plot.setToolTipGenerator(new StandardPieToolTipGenerator(unitSytle,
				NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));

		// 指定图片的透明度
		plot.setForegroundAlpha(0.65f);

		// 引出标签显示样式
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator(unitSytle,
				NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));

		// 图例显示样式
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
				unitSytle, NumberFormat.getNumberInstance(), new DecimalFormat(
						"0.00%")));
	}

	private static DefaultPieDataset getDataSet() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("area1", 100);
		dataset.setValue("area2", 200);
		dataset.setValue("area3", 300);
		dataset.setValue("area4", 400);
		dataset.setValue("area5", 500);
		return dataset;
	}
}
