<%@ include file="includes/cabecera.jsp" %>

<h2>CARRITO DE LA COMPRA</h2>


<table class="table">
	<thead>
		<tr>
			<th>ID</th><th>Nombre</th><th>Descripci&oacute;n</th><th>Precio</th><th>cantidad</th><th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="carrito" items="${carritoNew}">	
			<tr>
				<td>${carrito.producto.id}</td>
				<td>${carrito.producto.nombre}</td>
				<td>${carrito.producto.descripcion}</td>
				<td>${carrito.producto.precio} &euro;</td>
				<td>${carrito.cantidad}</td>
				<td><a href="productos?id=${producto.id}">Ver ficha</a>
			</tr>
			
		</c:forEach>
		<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="factura?id=${producto.id}">Realizar compra</a></td>
			</tr>
	</tbody>
			
</table>

<%@ include file="includes/pie.jsp" %>
