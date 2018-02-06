<%@ include file="includes/cabecera.jsp" %>

<h2>Factura</h2>
<h3>Datos del cliente</h3>
<table class="table">
	<thead>
		<tr>
			<th>nombre</th><th>apellido</th><th>dni</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>${usuario.nombre}</th><th>${usuario.apellidos}</th><th>${usuario.dni}</th>
		</tr>
	</tbody>
</table>
<h3>Datos de la factura</h3>
<table class="table">
	<thead>
		<tr>
			<th>Fecha factura</th><th>IVA</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>${factura.fecha}</td>
				<td>${factura.iva}</td>
			</tr>
	</tbody>
</table>

<h3>Productos comprados</h3>
<table class="table">
	<thead>
		<tr>
			<th>ID</th><th>Descripci&oacute;n</th><th>Precio</th><th>Link</th><th>Cantidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="carrito" items="${factura.c}">	
			<tr>
				<td>${carrito.p.id}</td>
				<td>${carrito.p.descripcion}</td>
				<td>${carrito.p.precio}</td>
				<td><a href="productos?id=${carrito.p.id}">ver ficha</a></td>
				<td>${carrito.cantidad}</td>
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
			<td>${factura.totalSinIva}</td>
			<td>${factura.totalConIva}</td>
			<td class="button"><a href="#">Finalizar pedido</a></td>
		</tr>
	</tbody>
			
</table>

<%@ include file="includes/pie.jsp" %>