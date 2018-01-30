<%@ include file="includes/cabecera.jsp" %>

<table class="table">
	<thead>
		<tr>
			<th>ID</th><th>Descripción</th><th>Precio</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="producto" items="${productos}">	
			<tr>
				<td>${producto.id}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio} €</td>
			</tr>
		</c:forEach>
	</tbody>
			
</table>

<%@ include file="includes/pie.jsp" %>
