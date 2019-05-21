package jiwang;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


//图形化的统计
public class newChart1 extends javax.swing.JDialog {
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JLabel jLabel1;
	private JPanel jPanel3;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				newChart1 inst = new newChart1(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public newChart1(JFrame frame) {
		super(frame);
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		//流量可视化，也要根据模式输出不同内容啊哦
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(JFrameMain.flag==0) {
			dataset.addValue(newCount.cAll, "总计", "数量");
			dataset.addValue(newCount.ctcp, "TCP", "数量");
			dataset.addValue(newCount.cudp, "UDP", "数量");
			dataset.addValue(newCount.cTaobao, "淘宝", "数量");
			dataset.addValue(newCount.cJindong, "京东", "数量");
			dataset.addValue(newCount.cQQ, "QQ", "数量");
		}
		if(JFrameMain.flag==1) {
			dataset.addValue(newCount.cAll, "总计", "数量");
			dataset.addValue(newCount.ctcp, "TCP", "数量");
			dataset.addValue(newCount.cudp, "UDP", "数量");
			dataset.addValue(newCount.cTaobao, "淘宝", "数量");
		}
		if(JFrameMain.flag==2) {
			dataset.addValue(newCount.cAll, "总计", "数量");
			dataset.addValue(newCount.ctcp, "TCP", "数量");
			dataset.addValue(newCount.cudp, "UDP", "数量");
			dataset.addValue(newCount.cJindong, "京东", "数量");

		}
		if(JFrameMain.flag==3) {
			dataset.addValue(newCount.cAll, "总计", "数量");
			dataset.addValue(newCount.ctcp, "TCP", "数量");
			dataset.addValue(newCount.cudp, "UDP", "数量");

			dataset.addValue(newCount.cQQ, "QQ", "数量");
		}
		if(JFrameMain.flag==4) {
			dataset.addValue(newCount.cAll, "总计", "数量");
			dataset.addValue(newCount.ctcp, "TCP", "数量");
			dataset.addValue(newCount.cudp, "UDP", "数量");
			dataset.addValue(newCount.cUR, "自定义规则", "数量");
		}
		JFreeChart barChart = ChartFactory.createBarChart("数据包统计结果", "数据包类型", "数量(个)", dataset,
				PlotOrientation.HORIZONTAL, true, true, false);
		//数量可视化，要根据模式输出不同内容啊
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		if(JFrameMain.flag==0) {
			dataset1.addValue(newCount.dAll, "总计", "数量");
			dataset1.addValue(newCount.dtcp, "TCP", "流量");
			dataset1.addValue(newCount.dudp, "UDP", "流量");
			dataset1.addValue(newCount.dTaobao, "淘宝", "流量");
			dataset1.addValue(newCount.dJindong, "京东", "流量");
			dataset1.addValue(newCount.dQQ, "QQ", "流量");
		}
		if(JFrameMain.flag==1) {
			dataset1.addValue(newCount.dAll, "总计", "数量");
			dataset1.addValue(newCount.dtcp, "TCP", "流量");
			dataset1.addValue(newCount.dudp, "UDP", "流量");
			dataset1.addValue(newCount.dTaobao, "淘宝", "流量");
		}
		if(JFrameMain.flag==2) {
			dataset1.addValue(newCount.dAll, "总计", "数量");
			dataset1.addValue(newCount.dtcp, "TCP", "流量");
			dataset1.addValue(newCount.dudp, "UDP", "流量");
			dataset1.addValue(newCount.dJindong, "京东", "流量");
		}
		if(JFrameMain.flag==3) {
			dataset1.addValue(newCount.dAll, "总计", "数量");
			dataset1.addValue(newCount.dtcp, "TCP", "流量");
			dataset1.addValue(newCount.dudp, "UDP", "流量");
			dataset1.addValue(newCount.dQQ, "QQ", "流量");
		}
		if(JFrameMain.flag==4) {
			dataset1.addValue(newCount.dAll, "总计", "数量");
			dataset1.addValue(newCount.dtcp, "TCP", "流量");
			dataset1.addValue(newCount.dudp, "UDP", "流量");
			dataset1.addValue(newCount.dUR, "自定义规则", "流量");
		}
		JFreeChart barChart1 = ChartFactory.createBarChart("流量统计结果", "数据包类型", "流量(MB)", dataset1,
				PlotOrientation.HORIZONTAL, true, true, false);
		
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				getContentPane().setLayout(thisLayout);
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1, BorderLayout.NORTH);
					jPanel1.setPreferredSize(new java.awt.Dimension(384, 66));
					jPanel1.setLayout(null);
					{
						jLabel1 = new JLabel();
						jPanel1.add(jLabel1);
						jLabel1.setText("\u7ed3\u679c\u56fe\u8868\u663e\u793a");
						jLabel1.setBounds(159, 12, 81, 42);
					}
				}
				{
					//最下面那个面板
					jPanel2 = new JPanel();
					getContentPane().add(jPanel2);
					jPanel2.setPreferredSize(new java.awt.Dimension(358, 97));
					{
						ChartPanel myChart1 = new ChartPanel(barChart);
						jPanel2.add(myChart1);
						myChart1.setPreferredSize(new java.awt.Dimension(386, 173));
					}
				}
				{
					//中间面板显示
					jPanel3 = new JPanel();
					getContentPane().add(jPanel3, BorderLayout.SOUTH);
					jPanel3.setPreferredSize(new java.awt.Dimension(384, 178));
					{
						ChartPanel myChart = new ChartPanel(barChart1);
						jPanel3.add(myChart);
						myChart.setPreferredSize(new java.awt.Dimension(386, 173));
					}
				}
				{
					
				}
			}
			this.setSize(400, 459);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
