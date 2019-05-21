package jiwang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

//import netcap.*;
import jpcap.*;
import jpcap.packet.*;
import java.util.*;
import java.sql.Timestamp;

//程序的主要ui+ip地址过滤功能
public class JFrameMain extends javax.swing.JFrame implements ActionListener {

	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	
	private JMenuItem stopMenuItem;
	private JMenuItem startMenuItem;
	private JMenu Menu;
	private JMenuBar jMenuBar1;
	private JMenuItem newJD;
	private JMenuItem newQQ;
	private JMenuItem newTB;
	private JMenuItem newUR;
	private JMenuItem newAnalysis;
	private JMenuItem newChart;
	public static int flag=0;//控制程序执行模式
	JTable tabledisplay = null;
	Vector rows, columns;
	DefaultTableModel tabModel;
	JScrollPane scrollPane;
	JLabel statusLabel;

	Netcaptor captor = new Netcaptor();

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		JFrameMain inst = new JFrameMain();
		inst.setVisible(true);
		
		////////////////////////////////////////////
		//初始化规则数组和txt的路径，所以说改路径在这里鸭
		File TB = new File("TB.txt");
		rule.read(TB, rule.TBA);
		File JD = new File("JD.txt");
		rule.read(JD, rule.JDA);
		File QQ = new File("QQ.txt");
		rule.read(QQ, rule.QQA);
		File UR = new File("USERRULE.txt");
		////////////////////////////////////////
		
		
		
		rule.read(UR, rule.UA);
	}

	public JFrameMain() {
		super("一个无情的流量统计器");
		initGUI();
		
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//保证通过右上角退出后进程也会结束
	}

	private void initGUI() {
		try {
			setSize(800, 600);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
				
					//设置菜单
					Menu = new JMenu();
					jMenuBar1.add(Menu);
					Menu.setText("菜单");
					Menu.setPreferredSize(new java.awt.Dimension(35, 21));
					{
						startMenuItem = new JMenuItem();
						Menu.add(startMenuItem);
						startMenuItem.setText("是个包就抓");
						startMenuItem.setActionCommand("start");
						startMenuItem.addActionListener(this);
					}
					{
						stopMenuItem = new JMenuItem();
						Menu.add(stopMenuItem);
						stopMenuItem.setText("停止");
						stopMenuItem.setActionCommand("stop");
						stopMenuItem.addActionListener(this);
					}
					{
						newAnalysis = new JMenuItem();
						Menu.add(newAnalysis);
						newAnalysis.setText("结果统计");
						newAnalysis.setActionCommand("newanalysis");
						newAnalysis.addActionListener(this);
					}
					//10-10 new add.
					{
						newChart=new JMenuItem();
						Menu.add(newChart);
						newChart.setText("图表显示");
						newChart.setActionCommand("newchart");
						newChart.addActionListener(this);
					}
					{
						newTB=new JMenuItem();
						Menu.add(newTB);
						newTB.setText("只抓淘宝包");
						newTB.setActionCommand("TB");
						newTB.addActionListener(this);
					}
					{
						newJD=new JMenuItem();
						Menu.add(newJD);
						newJD.setText("只抓京东包");
						newJD.setActionCommand("JD");
						newJD.addActionListener(this);
					}
					{
						newQQ=new JMenuItem();
						Menu.add(newQQ);
						newQQ.setText("只抓QQ包");
						newQQ.setActionCommand("QQ");
						newQQ.addActionListener(this);
					}
					{
						newUR=new JMenuItem();
						Menu.add(newUR);
						newUR.setText("自定义规则抓包");
						newUR.setActionCommand("userrule");
						newUR.addActionListener(this);
					}
					{
						jSeparator2 = new JSeparator();
						Menu.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						Menu.add(exitMenuItem);
						exitMenuItem.setText("溜了溜了");
						exitMenuItem.setActionCommand("exit");
						exitMenuItem.addActionListener(this);
					}
					
				}
			}

			rows = new Vector();
			columns = new Vector();

			columns.addElement("数据报时间");
			columns.addElement("源IP地址");
			columns.addElement("目的IP地址");
			columns.addElement("首部长度");
			columns.addElement("数据长度");
			columns.addElement("是否分段");
			columns.addElement("分段偏移量");
			columns.addElement("首部内容");
			columns.addElement("数据内容");

			tabModel = new DefaultTableModel();
			tabModel.setDataVector(rows, columns);
			tabledisplay = new JTable(tabModel);

			statusLabel = new JLabel("");
			this.getContentPane().add(statusLabel, BorderLayout.SOUTH);
			{
				getContentPane().add(new JScrollPane(tabledisplay), BorderLayout.CENTER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent event) {//菜单中每个的功能实现，排序和菜单一样
		String cmd = event.getActionCommand();
		if (cmd.equals("start")) {
			flag=0;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		} else if (cmd.equals("stop")) {
			captor.stopCapture();
		} else if (cmd.equals("exit")) {
			System.exit(0);
		}else if(cmd.equals("newanalysis")) {
			new newCount(this).setVisible(true);
		}else if(cmd.equals("TB")) {
			flag=1;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		}else if(cmd.equals("JD")) {
			flag=2;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		}else if(cmd.equals("QQ")) {
			flag=3;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		}else if(cmd.equals("userrule")) {
			flag=4;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		}else if(cmd.equals("newchart")) {
			new  newChart1(this).setVisible(true);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void dealPacket(Packet packet) {
		try {
			Vector r = new Vector();
			String strtmp;
			Timestamp timestamp = new Timestamp((packet.sec * 1000) + (packet.usec / 1000));
			if(flag==0||(flag==2&&rule.iprule(rule.JDA, packet)==1)||(flag==1&&rule.iprule(rule.TBA, packet)==1)||(flag==3&&rule.iprule(rule.QQA, packet)==1)||(flag==4&&rule.iprule(rule.UA, packet)==1)) {
			r.addElement(timestamp.toString()); // 数据报时间
			r.addElement(((IPPacket) packet).src_ip.toString()); // 源IP地址
			r.addElement(((IPPacket) packet).dst_ip.toString()); // 目的IP地址
			//tb,qq,jd	
			
			if(rule.iprule(rule.TBA, packet)==1) {
				newCount.cTaobao++;
				newCount.dTaobao+=(double)packet.len/1024;
			}if(rule.iprule(rule.JDA, packet)==1) {
				newCount.cJindong++;
				newCount.dJindong+=(double)packet.len/1024;
			}if(rule.iprule(rule.QQA, packet)==1) {
				newCount.cQQ++;
				newCount.dQQ+=(double)packet.len/1024;
			}
			if(flag==4&&rule.iprule(rule.UA, packet)==1) {
				newCount.cUR++;
				newCount.dUR+=(double)packet.len/1024;
			}
			
			
			
				r.addElement(packet.header.length); // 首部长度
				r.addElement(packet.data.length); // 数据长度
				r.addElement(((IPPacket) packet).dont_frag == true ? "分段" : "不分段"); // 是否不分段
				r.addElement(((IPPacket) packet).offset); // 数据长度
				strtmp = "";
				for (int i = 0; i < packet.header.length; i++) {
					strtmp += Byte.toString(packet.header[i]);
				}
				r.addElement(strtmp); // 首部内容

				strtmp = "";
				for (int i = 0; i < packet.data.length; i++) {
					strtmp += Byte.toString(packet.data[i]);
				}
				r.addElement(strtmp); // 数据内容
				rows.addElement(r);
				tabledisplay.addNotify();
			}

		} catch (Exception e) {

		}
	}
}