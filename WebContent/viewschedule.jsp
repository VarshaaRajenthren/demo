<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>viewSchedule.jsp</title>
</head>
<body>
<form action="MainServlet" method="post">
<br><br>
Source &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="source"><br><br>
Destination &nbsp&nbsp&nbsp<input type="text" name="destination"><br><br>
<input type="hidden" name="operation" value="viewSchedule">
<input type="submit" value="searchSchedule">
</form>
</body>
</html>