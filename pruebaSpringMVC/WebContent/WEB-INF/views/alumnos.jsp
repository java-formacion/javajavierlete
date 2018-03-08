<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Alumnos</title>
</head>
<body>
<center><h1>LISTADO DE ALUMNOS</h1></center>
<c:forEach items="${alumnos}" var="alumno">
<p><b>Nombre :</b> ${alumno.nombre}  <b>Apellidos:</b> ${alumno.apellido}  <B>Email:</B> ${alumno.email}</p>
</c:forEach>
</body>
</html>