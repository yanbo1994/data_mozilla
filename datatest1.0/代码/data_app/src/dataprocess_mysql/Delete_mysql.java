/*package dataprocess_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete_mysql {
	  public static void main(String args[]) {
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

		      PreparedStatement ps1 = connect.prepareStatement("alter table info_level2_beijingtime drop Type");
		      PreparedStatement ps2 = connect.prepareStatement("alter table info_level2_beijingtime drop Comment_User");
		      PreparedStatement ps3 = connect.prepareStatement("alter table info_level2_beijingtime drop Text_Length");
		      ps1.executeUpdate();
		      ps2.executeUpdate();
		      ps3.executeUpdate();
		          
		      connect.close();
		      System.out.print("sucess of delete");
		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
		  }
}*/