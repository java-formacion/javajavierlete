<%@ include file="includes/cabecera.jsp" %>

<h2>LISTADO DE PRODUCTOS</h2>

<table class="table">
	<thead>
		<tr>
			<th>ID</th><th>Descripci&oacute;n</th><th>Precio</th><th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="producto" items="${productos}">	
			<tr>
				<td>${producto.id}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio} &euro;</td>
				<td><a href="productos?id=${producto.id}">Ver ficha</a>
			</tr>
		</c:forEach>
	</tbody>
			
</table>

<%@ include file="includes/pie.jsp" %>
