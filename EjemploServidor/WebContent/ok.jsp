<%@ include file="WEB-INF/includes/cabecera.jsp" %>
<h1>LOGIN CORRECTO</h1>
<h2>Bienvenido <%= session.getAttribute("email") %></h2>
<%@ include file="WEB-INF/includes/pie.jsp" %>