<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","onClipEvent");
PreparedStatement ps = c.prepareStatement("INSERT INTO authors VALUES(NULL, ?, ?, ?)");
ps.setString(1, "aAmir");
ps.setString(2, "gmail.com");
ps.setString(3, "amir.s@acm.org");
if (ps.execute()) {
	out.println("OK");
}else {
	out.println("NOT OK");
}
%>
<hr />
asdasd
</body>
</html>
