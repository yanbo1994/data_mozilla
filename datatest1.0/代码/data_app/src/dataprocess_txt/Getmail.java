package dataprocess_txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Getmail {
	public String[] country=new String[100];
	public String[][] mail=new String[100][100];
	
	public Getmail(){
		for(int i=0;i<100;i++){
			country[i]="0";
		}
		for(int m=0;m<100;m++){
			for(int n=0;n<100;n++){
				mail[m][n]="0";
			}
		}
	}
	 
	public void readFileByLines(String fileName) {
        try {
        	System.out.println("以行为单位读取文件内容，一次读一整行：");
        	File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            
            int i=0;
            while ((tempString = reader.readLine()) != null) {
                System.out.println(tempString);
				String ss=tempString;//可对tempString修改
				String[] result=ss.split(",");
				
				//System.out.println(ss);
				//for(int g=0;g<result.length;g++){
					//System.out.println(result[g]);
				//}
				
				this.country[i]=result[0].substring(0, result[0].length()-1);
				//for(int k=1;i<result.length;k++){
					//mail[i][k-1]=result[k];
				//}
                
                i++;
            }
            reader.close();
        
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
	

	public static void main(String[] args) {
		Getmail gm=new Getmail();
		gm.readFileByLines("D:\\文件\\专业实训二\\2011_mozilla\\mai_country2.txt");

		for(int i=0;i<gm.country.length;i++){
			System.out.println(gm.country[i]);
		}
		for(int m=0;m<gm.mail.length;m++){
			for(int n=0;n<gm.mail.length;n++){
				System.out.print(gm.mail[m][n]+" ");
			}
			System.out.println();
		}
	}

}
