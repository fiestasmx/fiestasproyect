<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h1>Ingresado como: <%=session.getAttribute("email") %> </h1>
		
	<table>
		<tr>
			<td><a href="?accion=logout">Cerrar sesión</a></td>
		</tr>
		<tr>
			<td>Consultar administradores</td>
		</tr>
	</table>

	<p>
		Contenido principal
		
	</p>

</body>
</html>