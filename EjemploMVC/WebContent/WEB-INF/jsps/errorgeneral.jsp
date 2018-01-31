<%@ include file="includes/cabecera.jsp" %>

<%@ page isErrorPage="true" %>

<h2>Error: ${pageContext.exception}</h2>

<pre>
<c:forEach var = "trace" 
	items = "${pageContext.exception.stackTrace}">${trace}
</c:forEach>
</pre>

<%@ include file="includes/pie.jsp" %>
