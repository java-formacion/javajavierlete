<%@ include file="includes/cabecera.jsp" %>

<h2>CARRITO DE LA COMPRA</h2>

<table class="table">
	<thead>
		<tr>
			<th>ID</th><th>Descripci&oacute;n</th><th>Precio</th><th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="producto" items="${carrito}">	
			<tr>
				<td>${producto.id}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio} &euro;</td>
				<td><a href="productos?id=${producto.id}">Ver ficha</a>
				<td><a href="carrito?id=${producto.id}">x</a>
			</tr>
		</c:forEach>
		
	</tbody>
			
</table>
<p>
			<a href="factura?id=${usuario.id}" class="btn btn-primary" role="button">Factura</a>
		</p>
<%@ include file="includes/pie.jsp" %>
