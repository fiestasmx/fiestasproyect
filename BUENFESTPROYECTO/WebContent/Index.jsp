<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>index.jsp</h1>
<%
String s="Este Mensaje no es muy dinamic�";
out.println(s);
%>
<p>Este Mensaje no es muy dinamico</p>

<%
out.println("Este Mensaje Es dinamico: "+request.getHeader("USER-AGENT"));
%>
</body>
</html>