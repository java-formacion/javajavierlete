<%@ include file="includes/cabecera.jsp" %>

<h2>CARRITO DE LA COMPRA</h2>

<table class="table">
	<thead>
		<tr>
			<th>ID</th><th>Descripci&oacute;n</th><th>Precio</th><th>Link</th><th>Cantidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="carrito" items="${carritos}">	
			<tr>
				<td>${carrito.p.id}</td>
				<td>${carrito.p.descripcion}</td>
				<td>${carrito.p.precio}</td>
				<td><a href="productos?id=${carrito.p.id}">ver ficha</a></td>
				<td>${carrito.cantidad}</td>
				<td><a href="carrito?idProducto=${producto.id}" class="btn btn-danger" role="button">Eliminar <span class="glyphicon glyphicon-trash"></span></a></td>
			</tr>
		</c:forEach>
	</tbody>
			
</table>

<table class="table">
	<thead>
		<tr>
			<th>Total sin iva</th><th>Total con iva</th><th>Ir a factura</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${totalSinIva}</td>
			<td>${totalConIva}</td>
			<td class="button"><a href="factura">Factura</a></td>
		</tr>
	</tbody>
	
</table>

<%@ include file="includes/pie.jsp" %>
