<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Alumnos</title>
</head>
<body>

<center><h1>Introducir nuevo ALUMNO</h1></center>

<form:form method="post" action="alumnos" modelAttribute="alumno">

<table border = 1>

			<tr>
				<td><form:input path="nombre" placeholder="Nombre" /><form:errors path="nombre" cssClass="error" /></td>
				
			</tr>
			<tr>
			<td><form:input path="apellido" placeholder="Apellidos" /></td>
			</tr>
			<tr>
			<td><form:input path="telefono" placeholder="Teléfono" /></td>
			</tr>
			<tr>
			<td><form:input path="direccion" placeholder="Dirección" /></td>
			</tr>
			<tr>
			<td><form:input path="email" placeholder="Email" /></td>
			</tr>
			<tr>
			<td><form:button>Enviar</form:button></td>
			</tr>
			
</table>
</form:form>


<center><h1>LISTADO DE ALUMNOS</h1></center>
<c:forEach items="${alumnos}" var="alumno">
<p><b>Nombre :</b> ${alumno.nombre}  <b>Apellidos:</b> ${alumno.apellido} <b>Dirección:</b> ${alumno.direccion} <b>Telefono:</b> ${alumno.telefono} <B>Email:</B> ${alumno.email}</p>
</c:forEach>
</body>
</html>