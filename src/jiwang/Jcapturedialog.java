package jiwang;

import javax.swing.JFrame;
import jpcap.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//读取，选择网卡，开始界面
public class Jcapturedialog extends javax.swing.JDialog implements ActionListener {


	static JpcapCaptor jpcap = null;
	private JPanel buttonPanel;
	private JButton cancelButton;
	private JButton okButton;
	private JPanel netPanel;
	@SuppressWarnings("rawtypes")
	private JComboBox netJComboBox;
	private JPanel jPanel_east;
	private JPanel jPanel_west;

	NetworkInterface[] devices;

	 public static void main(String[] args) {
		 JFrame frame = new JFrame();
		 Jcapturedialog inst = new Jcapturedialog(frame);
		 inst.setVisible(true);
	 }

	public Jcapturedialog(JFrame frame) {
		super(frame, "选择一个最帅的网卡", true);

		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS);
			getContentPane().setLayout(thisLayout);
			{
				jPanel_west = new JPanel();
				jPanel_west.setLayout(new BoxLayout(jPanel_west, BoxLayout.Y_AXIS));
				getContentPane().add(jPanel_west);
				{
					netPanel = new JPanel();
					FlowLayout netPanelLayout = new FlowLayout();
					netPanelLayout.setAlignOnBaseline(true);
					netPanel.setBorder(BorderFactory.createTitledBorder("选择网卡"));
					netPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
					jPanel_west.add(netPanel);
					netPanel.setLayout(netPanelLayout);			
					{
						devices = JpcapCaptor.getDeviceList();
						if (devices == null) {
							JOptionPane.showMessageDialog(frame, "没有找到网卡");
							dispose();
							return;
						} else {
							System.out.println("找到网卡");
							String[] names = new String[devices.length];
							for (int i = 0; i < names.length; i++) {
								names[i] = (devices[i].description == null ? devices[i].name : devices[i].description);
								
							}
							netJComboBox = new JComboBox(names);
						}
						netPanel.add(netJComboBox);
					}
				}
			}
			{
				jPanel_east = new JPanel();
				jPanel_east.setLayout(new BoxLayout(jPanel_east, BoxLayout.Y_AXIS));
				getContentPane().add(jPanel_east);
				{
					buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));		
					jPanel_east.add(buttonPanel);

					{
						okButton = new JButton();
						buttonPanel.add(okButton);
						FlowLayout cancelButtonLayout = new FlowLayout();
						cancelButtonLayout.setAlignOnBaseline(true);
						okButton.setText("就决定是你了");

						okButton.setActionCommand("ok");
						okButton.addActionListener(this);
					}
					{
						cancelButton = new JButton();
						buttonPanel.add(cancelButton);
						cancelButton.setText("取消");

						cancelButton.setActionCommand("cancel");
						cancelButton.addActionListener(this);
					}				
				}
			}

			pack();

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setLocationRelativeTo(null);
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();


            if (cmd.equals("ok")) {//就决定是你了
			try {
				int caplen = 1514;		
				jpcap = JpcapCaptor.openDevice(devices[netJComboBox.getSelectedIndex()], caplen, false,
						50);				
			} catch (java.io.IOException e) {

			} finally {
				dispose();
			}

		} else if (cmd.equals("cancel")) {//取消
			dispose();
		}
	}

	public static JpcapCaptor getJpcap(JFrame parent) {
		new Jcapturedialog(parent).setVisible(true);
		return jpcap;
	}
}