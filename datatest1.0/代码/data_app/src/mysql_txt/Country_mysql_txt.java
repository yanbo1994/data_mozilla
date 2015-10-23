package mysql_txt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Country_mysql_txt {

	private static int record=0;
	private static String id="0";

	public static void main(String[] args) {
	    try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/github_db","root","");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      
		      //Statement stmt = connect.createStatement();
		      //ResultSet rs1 = stmt.executeQuery("select Login_ID from info_level2");
		      //ResultSet rs2 = stmt.executeQuery("select Comment_Time from info_level2");
			  FileOutputStream wf=new FileOutputStream("D:\\文件\\专业实训二\\2011_mozilla\\mail.txt");
		         
			  PreparedStatement ps1 = connect.prepareStatement("select Login_ID from info_level2", 
		      ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
			  //PreparedStatement ps2 = connect.prepareStatement("select Comment_Time from info_level2", 
			  //ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		      ps1.setFetchSize(Integer.MIN_VALUE);
		      //ps2.setFetchSize(Integer.MIN_VALUE);
		      ResultSet rs1 = ps1.executeQuery();
		      //ResultSet rs2 = ps2.executeQuery();
			  
		      while (rs1.next()) {

		  		Get_mail getmail=new Get_mail();
		  		 String mail0=getmail.mail(rs1.getString("Login_ID"));
		  		 String mail=id+","+mail0+"\n";
		  		 String sttrr=mail;//+","+rs2.getString("Comment_Time");
		  		 //System.out.println(rs2.getString("Comment_Time"));
		  		 
		 		try{
					byte buffer[] = sttrr.getBytes();
					wf.write(buffer,0,buffer.length);
					System.out.println("write:"+record++);
					int id1=Integer.parseInt(id);
					System.out.println("write:"+id1++);
					id=String.valueOf(id1);
				}
				catch(IOException ieo){
					System.out.println(ieo);
				} 
				catch(Exception e){
					System.out.println(e);
				}		  		 
		          
		      }
		      wf.close();
		      connect.close();
		      System.out.print("sucess of write:"+record);
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
	}

}
