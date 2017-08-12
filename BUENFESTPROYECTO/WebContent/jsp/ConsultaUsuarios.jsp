<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Consulta de Usuarios</h1> <br/>
	
	<c:out value="${requestScope.mensaje}" /> <br/>
	
	<c:forEach var="user" items="${sessionScope.usuarios}">
		<c:out value="${user.email}" />, ${user.contrasena}, ${user.nombre}, ${user.idUsuarios} <br/>
	
	</c:forEach>

</body>
</html>