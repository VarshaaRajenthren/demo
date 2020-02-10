package com.wipro.bus.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
private static Connection con;
public static Connection getDBConnection(){
	if(con==null)
	try{
		Class.forName("oracle.jdbc.Driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@172.16.100.13:1521:orcl","l17104","pass321");
		System.out.println("connected...");
	}catch(Exception e){
	System.out.println(e);
	}
	return con;
}
}
