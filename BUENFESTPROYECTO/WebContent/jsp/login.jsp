<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio de sesion</title>
</head>
<body>
<h1>Login.jsp</h1>
<p>
	<form method="post" action="?accion=iniciarSesion">
		<table>
			<tr> 
				<td>Nombre de usuario: </td>
				<td> <input type="text" name="usuario"  size="35"/> </td>
			</tr>
			<tr> 
				<td>Contrase�a: </td>
				<td> <input type="password" name="contrasena" size="35"/> </td>
			</tr>
			<tr> 
		    <td> </td>
				<td> <input type="checkbox" checked="checked">Recordar mis datos</input> </td>
			</tr>
			<tr> 
				<td> </td>
				<td> <input type="submit" value="Iniciar Sesi�n" /> </td>
			</tr>
		</table>
	</form>
</p>
</body>
</html>