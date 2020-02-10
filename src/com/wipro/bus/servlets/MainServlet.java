package com.wipro.bus.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.service.Administrator;
import com.wipro.bus.util.InvalidInputException;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {	
public String addSchedule(HttpServletRequest request){
	ScheduleBean obj=new ScheduleBean();
	obj.setSource(request.getParameter("source"));
	obj.setSource(request.getParameter("destination"));
	obj.setSource(request.getParameter("startTime"));
	obj.setSource(request.getParameter("arrivalTime"));
	return new Administrator().addSchedule(obj);
	}
public ArrayList<ScheduleBean> viewSchedule(HttpServletRequest request){
	return new Administrator().viewSchedule(request.getParameter("source"),request.getParameter("destination"));
	 
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String operation=request.getParameter("operation");
		switch(operation){
		case "newSchedule":{
			String x=addSchedule(request);
			if(x.equals("SUCCESS")){
				response.sendRedirect("success.jsp");
			}else{
				response.sendRedirect("error.html");
			}
		}
		case "viewSchedule":{
			ArrayList<ScheduleBean> y=viewSchedule(request);
			if(y.equals("null")){
				out.println("no matching schedules exists! please try again");
			}
			else{
				request.setAttribute("bean",viewSchedule(request));
				RequestDispatcher rd=request.getRequestDispatcher("displaySchedule.jsp");
				rd.forward(request,response);
			}
		}
		}
	}

}
