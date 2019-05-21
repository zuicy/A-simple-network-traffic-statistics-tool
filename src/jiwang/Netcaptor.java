package jiwang;

import java.io.File;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import jpcap.JpcapCaptor;
import jpcap.PacketReceiver;
import jpcap.JpcapWriter;
import jpcap.packet.ARPPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;
//抓包，区分tcp，udp包
public class Netcaptor {

	JpcapCaptor jpcap = null;
	JFrameMain frame;


	public void setJFrame(JFrameMain frame) {
		this.frame = frame;
	}

	public void capturePacketsFromDevice() {

		if (jpcap != null)
			jpcap.close();

		jpcap = Jcapturedialog.getJpcap(frame);

		if (jpcap != null) {
			startCaptureThread();
		}

	}

	private Thread captureThread;

	private void startCaptureThread() {

		if (captureThread != null)
			return;
		captureThread = new Thread(new Runnable() {
			public void run() {
				while (captureThread != null) {
					jpcap.processPacket(1, handler);
				}
			}
		});
		captureThread.setPriority(Thread.MIN_PRIORITY);
		captureThread.start();
	}

	void stopcaptureThread() {
		captureThread = null;
	}

	public void stopCapture() {
		System.out.println("已正确停止");
		stopcaptureThread();
	}

	
	public void newdeal(Packet packet) {//统计，区分tcp，udp
		if(JFrameMain.flag==0||(JFrameMain.flag==2&&rule.iprule(rule.JDA, packet)==1)||(JFrameMain.flag==1&&rule.iprule(rule.TBA, packet)==1)||(JFrameMain.flag==3&&rule.iprule(rule.QQA, packet)==1)||(JFrameMain.flag==4&&rule.iprule(rule.UA, packet)==1)) {
			newCount.cAll++;
			newCount.dAll+=(double)packet.len/1024;
		
			if(packet.getClass().equals(UDPPacket.class)) {
				newCount.ctcp++;
				newCount.dtcp+=(double)packet.len/1024;
			}
			else if(packet.getClass().equals(TCPPacket.class)) {
				newCount.cudp++;
				newCount.dudp+=(double)packet.len/1024;
			}
		}
	}
	private PacketReceiver handler = new PacketReceiver() {
		public void receivePacket(Packet packet) {
			if(packet instanceof IPPacket) {//判断是否是ip包，不是的话就丢弃
			frame.dealPacket(packet);
			System.out.println(packet.toString());//控制台打印所有抓到的包，无视规则，看着爽但是没什么用嘤嘤嘤。
			
				newdeal(packet);
			}
			
		}

	};
}