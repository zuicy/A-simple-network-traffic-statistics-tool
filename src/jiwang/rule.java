package jiwang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
//从txt中读取ip规则，ip地址匹配
public class rule {

	public static String [] TBA = new String [50];
	public static String [] JDA = new String [50];
	public static String [] QQA = new String [50];
	public static String [] UA = new String [50];
    public static int read(File file,String[] a){//读文件
        try{
        	int i=0;
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                a[i]=s;
                i++;
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public static int iprule(String[] a,Packet packet){//匹配

    	for(int x=0;x<50;x++)
    	{
    		if(((IPPacket) packet).dst_ip.toString().equals(a[x])||((IPPacket) packet).src_ip.toString().equals(a[x]))
    		{
    			return 1;
    		}
    	}

        
        return 0;
    }
}
