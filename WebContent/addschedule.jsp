
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addSchedule.jsp</title>
</head>
<body>
<h3><b>Enter Schedule Details</b></h3>
<form action="MainServlet" method="post">
<br><br>
Source &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="source"><br><br>
Destination &nbsp&nbsp&nbsp<input type="text" name="destination"><br><br>
Start Time &nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="startTime"><br><br>
Arrival Time &nbsp<input type="text" name="arrivalTime"><br><br>
<input type="hidden" name="operation" value="newSchedule">
<input type="submit" value="createSchedule">
</form>
</body>
</html>