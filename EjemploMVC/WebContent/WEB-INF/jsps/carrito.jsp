<%@ include file="includes/cabecera.jsp" %>

<h2>CARRITO DE LA COMPRA</h2>

<table class="table">
	<thead>
		<tr>
			<th>ID</th><th>Descripci&oacute;n</th><th>Precio</th><th>Link</th><th>Cantidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="producto" items="${carrito}">	
			<tr>
				<td>${producto.id}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio} &euro;</td>
				<td><a href="productos?id=${producto.id}">Ver ficha</a>
				<td>Cantidad</td>
			</tr>
		</c:forEach>
		<tr>
			<td></td><td></td><td></td><td></td><td><a href="factura">Factura</a></td>
		</tr>
	</tbody>
			
</table>

<%@ include file="includes/pie.jsp" %>
