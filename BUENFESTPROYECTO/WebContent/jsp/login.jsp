<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio de sesion</title>

</head>
<body>
<h1>Login.jsp</h1>
<%-- 	<%=request.getAttribute("error") %> --%>
	
	<span style="color:red; font-weight:bold;">
		<%
			String error = (String) request.getAttribute("error");
			if(error != null){
				out.println(error);
			}
		%>
	</span> <br/>
	
	<form method="post" action="?accion=iniciarSesion">
		<table>
			<tr> 
				<td>Nombre de usuario: </td>
				<%
					Cookie[] cookies = request.getCookies();
					String valor = "";
					for(Cookie c:cookies){
						if(c.getName().equals("usuario")){
							valor = c.getValue();
						}
						else{
							out.println("No encontrado");
						}
					}
				%>
			<td> <input type="text" name="usuario" size="35" value="<%=valor%>"/> </td>
			</tr>
			<tr> 
				<td>Contrase�a: </td>
				<td> <input type="password" name="contrasena" size="35"/> </td>
			</tr>
			<tr> 
		    <td> </td>
				<td> <input name="ckbox" type="checkbox" checked="checked">Recordar mis datos</input> </td>
			</tr>
			<tr> 
				<td> </td>
				<td> <input type="submit" value="Iniciar Sesi�n" /> </td>
			</tr>
		</table>
	</form>
</body>
</html>