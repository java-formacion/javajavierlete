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
<h3>Productos comprados</h3>
<h4>Iva de los productos 21%</h4>
<table class="table">
	<thead>
		<tr>
			<th>ID factura</th><th>Id usuario</th><th>Fecha factura</th><th>IVA</th>
		</tr>
	</thead>
	<tbody>
		
			<tr>
				<td>${factura.id}</td>
				<td>${factura.idUsuario}</td>
				<td>${factura.fecha}</td>
				<td>${factura.iva}</td>
			</tr>
			
	</tbody>
</table>

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
				<td></td><td></td><td></td><td colspan="2">total: </td>
		</tr>
	</tbody>
			
</table>

<%@ include file="includes/pie.jsp" %>