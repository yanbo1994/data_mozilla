package chart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Get_time_mysql {
	  char a='k'-'a';
	  public int[] shows={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	  public String[] comp={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
	  
	  void gettime() {
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
		      
		      Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery("select time from commenttime");

		      int sum=0;
		      while (rs.next()) {
		    	  String willcomp=(rs.getString("time")).substring(11, 13);
		    	  for(int i=0;;i++){
		    		  if(willcomp.equals(comp[i])){
		    			  shows[i]++;
		    			  break;
		    		  }
		    	  }
		      }
		      
	          for(int i=0;i<24;i++){
	        	  System.out.println("data"+(i+1)+" is: "+shows[i]);
	        	  sum=sum+shows[i];
	          }
	          
		      System.out.println("sum is:"+sum);
		    }
		    
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
		  }
	  
	  public static void main(String[] args){
		  Get_time_mysql gtm=new Get_time_mysql();
		  gtm.gettime();
	  }
	  
}
