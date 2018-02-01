<%@ include file="includes/cabecera.jsp" %>
<%@page import="java.util.Date"%>


<h4>Factura nº  ${factura.numeroFactura }  con fecha: ${factura.fecha }   </h4>

<br><br>
<h4>Cliente:</h4>

<table class="table">
	<thead>
		<tr>
			<th>Producto</th><th>Cantidad</th><th>Precio</th><th></th>
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
			<td></td>
			<td>Importe</td>
			<td>${factura.importe}</td>
		</tr>
		<tr>
			<td></td>
			<td>IVA</td>
			<td>${factura.iva}%</td>
		</tr>
		<tr>
			<td></td>
			<td>Total</td>
			<td>${factura.total}</td>
		</tr>
	</tbody>
			
</table>


<%@ include file="includes/pie.jsp" %>