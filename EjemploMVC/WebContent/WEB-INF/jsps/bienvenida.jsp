<%@ include file="includes/cabecera.jsp" %>

<h2>Bienvenido <c:if test="${usuario.email != null}"><c:set>${usuario.email}</c:set></c:if> a nuestra tienducha</h2>

<%@ include file="includes/pie.jsp" %>
