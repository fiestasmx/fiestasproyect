<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Registro de pregunta secreta</h1>
	<br/>
	
	<form>
		Captura la pregunta secreta: <br/>
		<input type="text" name="pregunta" size="35" /> <br/>
		<input type="hidden" name="accion" value="registrarPregunta" />
		<%-- String accion = "registrarPregunta"; --%>
		<input type="submit" value="Registrar" />
	</form>
	
</body>
</html>