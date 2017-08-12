<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insertar pregunta secreta</h1>
	<br />

	<c:set var="str" value="${param.pregunta}" />
	La longitud de la pregunta es: ${fn:length(str)}


	<c:catch var="ex">
		<sql:update var="row" dataSource="jdbc/BuenFestJDBC"
			sql="INSERT INTO PreguntaSeguridad(Pregunta) VALUES (?)">
			<sql:param value="${param.pregunta}"></sql:param>
		</sql:update>
		Row: ${row}
		<c:choose>
			<c:when test="${row != 0}">Pregunta registrada correctamente. <br />
			</c:when>
			<c:otherwise>Error al registrar la pregunta <br />
			</c:otherwise>
		</c:choose>
	</c:catch>

	<c:if test="${ex != null}">
		<span style="color: red;"> * Error en la conexión. <br />
		</span>
	</c:if>


</body>
</html>