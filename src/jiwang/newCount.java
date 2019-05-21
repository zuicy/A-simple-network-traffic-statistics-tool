package jiwang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


//数字化的统计

@SuppressWarnings("serial")
public class newCount extends JDialog{

	//包数量
	static int ctcp=0;
	static int cudp=0;
	static int cTaobao=0;
	static int cJindong=0;
	static int cQQ=0;
	static int cAll=0;
	static int cUR=0;
	//包流量
	static double dtcp=0;
	static double dudp=0;
	static double dTaobao=0;
	static double dJindong=0;
	static double dQQ=0;
	static double dAll=0;
	static double dUR=0;
	
	private JLabel jLabel1;
	private JTable jTable1;

	public newCount(JFrame frame) {
		super(frame, "统计", true);
		initGUI();
		this.setLocationRelativeTo(null);
		try {
			
		}catch(Exception e) {
			
		}
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setName("no");
				this.setSize(406, 332);
				{//根据不同的模式输出不同的内容嗷
					if(JFrameMain.flag==0) {
						
					
						String [][] cs=new String[][] { {"类型","数量","流量(MB)"},
							{"All",String.valueOf(cAll),String.valueOf(dAll/1024) },
							{"TCP",String.valueOf(ctcp),String.valueOf(dtcp/1024) },
							{"UDP",String.valueOf(cudp),String.valueOf(dudp/1024) },
							{"淘宝",String.valueOf(cTaobao),String.valueOf(dTaobao/1024)},
							{"京东",String.valueOf(cJindong),String.valueOf(dJindong/1024)},
							{"QQ",String.valueOf(cQQ),String.valueOf(dQQ/1024)}
						};
						TableModel jTable1Model = 
								new DefaultTableModel(cs,new String[] { "Column 1", "Column 2","Column 3" });
						jTable1 = new JTable();
						getContentPane().add(jTable1);
						jTable1.setModel(jTable1Model);
						jTable1.setBounds(19, 61, 359, 225);
						jTable1.setFont(new java.awt.Font("Microsoft YaHei UI",0,16));
						jTable1.setRowHeight(22);
					}
					if(JFrameMain.flag==1) {
						
						
						String [][] cs=new String[][] { {"类型","数量","流量(MB)"},
							{"All",String.valueOf(cAll),String.valueOf(dAll/1024) },
							{"TCP",String.valueOf(ctcp),String.valueOf(dtcp/1024) },
							{"UDP",String.valueOf(cudp),String.valueOf(dudp/1024) },
							{"淘宝",String.valueOf(cTaobao),String.valueOf(dTaobao/1024)},
						};
						TableModel jTable1Model = 
								new DefaultTableModel(cs,new String[] { "Column 1", "Column 2","Column 3" });
						jTable1 = new JTable();
						getContentPane().add(jTable1);
						jTable1.setModel(jTable1Model);
						jTable1.setBounds(19, 61, 359, 225);
						jTable1.setFont(new java.awt.Font("Microsoft YaHei UI",0,16));
						jTable1.setRowHeight(22);
					}
					if(JFrameMain.flag==2) {
						
						
						String [][] cs=new String[][] { {"类型","数量","流量(MB)"},
							{"All",String.valueOf(cAll),String.valueOf(dAll/1024) },
							{"TCP",String.valueOf(ctcp),String.valueOf(dtcp/1024) },
							{"UDP",String.valueOf(cudp),String.valueOf(dudp/1024) },
							{"京东",String.valueOf(cJindong),String.valueOf(dJindong/1024)},
						};
						TableModel jTable1Model = 
								new DefaultTableModel(cs,new String[] { "Column 1", "Column 2","Column 3" });
						jTable1 = new JTable();
						getContentPane().add(jTable1);
						jTable1.setModel(jTable1Model);
						jTable1.setBounds(19, 61, 359, 225);
						jTable1.setFont(new java.awt.Font("Microsoft YaHei UI",0,16));
						jTable1.setRowHeight(22);
					}
					if(JFrameMain.flag==3) {
						
						
						String [][] cs=new String[][] { {"类型","数量","流量(MB)"},
							{"All",String.valueOf(cAll),String.valueOf(dAll/1024) },
							{"TCP",String.valueOf(ctcp),String.valueOf(dtcp/1024) },
							{"UDP",String.valueOf(cudp),String.valueOf(dudp/1024) },
							{"QQ",String.valueOf(cQQ),String.valueOf(dQQ/1024)}
						};
						TableModel jTable1Model = 
								new DefaultTableModel(cs,new String[] { "Column 1", "Column 2","Column 3" });
						jTable1 = new JTable();
						getContentPane().add(jTable1);
						jTable1.setModel(jTable1Model);
						jTable1.setBounds(19, 61, 359, 225);
						jTable1.setFont(new java.awt.Font("Microsoft YaHei UI",0,16));
						jTable1.setRowHeight(22);
					}
					if(JFrameMain.flag==4) {
						
						
						String [][] cs=new String[][] { {"类型","数量","流量(MB)"},
							{"All",String.valueOf(cAll),String.valueOf(dAll/1024) },
							{"TCP",String.valueOf(ctcp),String.valueOf(dtcp/1024) },
							{"UDP",String.valueOf(cudp),String.valueOf(dudp/1024) },
							{"自定义规则",String.valueOf(cUR),String.valueOf(dUR/1024)}
						};
						TableModel jTable1Model = 
								new DefaultTableModel(cs,new String[] { "Column 1", "Column 2","Column 3" });
						jTable1 = new JTable();
						getContentPane().add(jTable1);
						jTable1.setModel(jTable1Model);
						jTable1.setBounds(19, 61, 359, 225);
						jTable1.setFont(new java.awt.Font("Microsoft YaHei UI",0,16));
						jTable1.setRowHeight(22);
					}
				}
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("\u6570\u636e\u5305\u6570\u91cf\u7edf\u8ba1\u7ed3\u679c");
					jLabel1.setBounds(125, 12, 147, 43);
					jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI",0,16));
				}

			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
