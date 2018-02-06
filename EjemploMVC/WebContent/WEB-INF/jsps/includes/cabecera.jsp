<%@ page errorPage="errorgeneral.jsp" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TiendaVirtual</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.12.4.min.js"></script>

</head>
<body class="container-fluid">

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/">TiendaVirtual</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="${pageContext.servletContext.contextPath}/productos">Productos</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.servletContext.contextPath}/carrito">Carrito</a></li>
        <c:choose>
	        <c:when test="${usuario.nombre != null}">
	        <li><a href="#">${usuario.nombre}</a></li>
	        <li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
	        </c:when>
	        <c:otherwise>
	        <li><a href="${pageContext.servletContext.contextPath}/login">Login</a></li>
	        <li><a href="${pageContext.servletContext.contextPath}/signup">Sign up</a></li>
	        </c:otherwise>
	    </c:choose>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div id="contenidoprincipal" class="container-fluid">
