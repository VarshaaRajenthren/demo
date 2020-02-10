package com.wipro.bus.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.util.DBUtil;

public class ScheduleDAO {
	Connection con;
	PreparedStatement pt;
	ResultSet rs;
	public String createSchedule(ScheduleBean scheduleBean){
		Scanner sc=new Scanner(System.in);
		int x = 0;
		con=DBUtil.getDBConnection();
		try {
			pt=con.prepareStatement("insert into SCHEDULE_TBL values(?,?,?,?,?)");
			pt.setString(1,scheduleBean.getScheduleId());
			pt.setString(2,scheduleBean.getSource());
			pt.setString(3,scheduleBean.getDestination());
			pt.setString(4,scheduleBean.getStartTime());
			pt.setString(5,scheduleBean.getArrivalTime());
			x=pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(x>0)
		return "SUCCESS";
		else
			return "Failed";
		}
	public String generateID(String source,String destination){
		int id=0;
		if(con==null)
		con=DBUtil.getDBConnection();
		try {
			rs=pt.executeQuery("select SCHEDULE_SEQ.nextval from dual;");
			id=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return source.toUpperCase().substring(0,2)+destination.toUpperCase().substring(0,2)+id;	
	}
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination){
		ArrayList<ScheduleBean> list=new ArrayList<ScheduleBean>();
		ScheduleBean bean =new ScheduleBean();
		try {
			rs=pt.executeQuery("select * from SCHEDULE_TBL where source='"+source+"' and destination='"+destination+"';");
			while(rs.next()){
				bean.setScheduleId(rs.getString(1));
				bean.setSource(rs.getString(2));
				bean.setDestination(rs.getString(3));
				bean.setStartTime(rs.getString(4));
				bean.setArrivalTime(rs.getString(5));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
