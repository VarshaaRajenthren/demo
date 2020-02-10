package com.wipro.bus.service;

import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.dao.ScheduleDAO;
import com.wipro.bus.util.InvalidInputException;

public class Administrator {
	InvalidInputException i =new InvalidInputException();
	public String addSchedule(ScheduleBean scheduleBean){
		if(scheduleBean.equals("null")){
			return i.toString();
		}
		String source=scheduleBean.getSource();
		String destination=scheduleBean.getDestination();
		if((source.equals("null"))|| (destination.equals("null"))|| (scheduleBean.getArrivalTime().equals("null"))|| (scheduleBean.getStartTime().equals("null"))){
			return i.toString();
		}
		if((source.length()<2)|| (destination.length()<2)){
			return i.toString();
		}
		if(source.equals(destination)){
			return "source and destination are same";
		}
		String id=new ScheduleDAO().generateID(scheduleBean.getSource(),scheduleBean.getDestination());
		scheduleBean.setScheduleId(id);
		return new ScheduleDAO().createSchedule(scheduleBean);
	}
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination){
		return new ScheduleDAO().viewSchedule(source,destination);
	}
	
}
