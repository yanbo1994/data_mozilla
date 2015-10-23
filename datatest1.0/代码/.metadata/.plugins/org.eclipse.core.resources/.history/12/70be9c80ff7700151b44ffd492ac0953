package dataprocess_txt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Getdata_rtxt_wtxt {
	public static void main(String[] args) throws IOException {
		try{
			FileInputStream rf;
			rf=new FileInputStream("D:\\文件\\专业实训二\\2011_mozilla\\mail.txt");
			FileOutputStream wf;
			wf=new FileOutputStream("D:\\文件\\专业实训二\\2011_mozilla\\test.txt");
			int n=3000;//偏移量，每次读取长度
			byte buffer[]=new byte[n];
			while((rf.read(buffer, 0, n))!=-1){//循环读取，直至读到末尾
				wf.write(buffer, 0, n);//将读取的buffer中的数据写入
				System.out.println(new String(buffer));
			}
			System.out.println();
			System.out.println("sucess of write");
			rf.close();
			wf.close();
		}
		catch(IOException ioe){
			System.out.println(ioe);
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}
