<%@ include file="includes/cabecera.jsp" %>
<%@page import="java.util.Date"%>


<h4>Factura nº:${factura.id}</h4>
<h4>Fecha:${factura.fecha}</h4>

<br>

<h4>Cliente:</h4>

<br>

<table class="table">
	<thead>
		<tr>
			<th>Producto</th><th>Nombre</th><th>Precio</th><th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="producto" items="${carrito}">	
			<tr>
				<td>${producto.id}</td>
				<td>${producto.nombre}</td>
				<td>${producto.precio} &euro;</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2" style="text-align:right">Importe:</td>
			<td>${factura.importe}</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right">IVA:</td>
			<td>${factura.iva}%</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right">Total:</td>
			<td>${factura.total}</td>
		</tr>
	</tbody>
</table>


<%@ include file="includes/pie.jsp" %>