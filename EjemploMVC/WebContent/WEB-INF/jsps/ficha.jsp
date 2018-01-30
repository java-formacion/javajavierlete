<%@ include file="includes/cabecera.jsp" %>

<table class="table">
	<tbody>
		<tr><th>ID</th><td>${producto.id}</td></tr>
		<tr><th>Descripci&oacute;n</th><td>${producto.descripcion}</td></tr>
		<tr><th>Precio</th><td>${producto.precio} &euro;</td></tr>
	</tbody>
</table>

<%@ include file="includes/pie.jsp" %>
