<%@ include file="includes/cabecera.jsp" %>

<h2>Bienvenido <c:if test="${usuario.email != null}">${usuario.nombre} </c:if>a nuestra tienducha</h2>

<%@ include file="includes/pie.jsp" %>
