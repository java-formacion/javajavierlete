<%@ include file="includes/cabecera.jsp" %>
<%@page import="java.util.Date"%>


<h4>Factura nº  ${factura.numeroFactura }  con fecha: ${factura.fecha }   </h4>

<br><br>
<h4>Cliente:</h4>
<div clas="form-group">
<p><label for="nombre" class="col-sm-1 control-label">Nombre:</label>${sessionScope.usuario.nombre}</p>
<p><label for="apellidos" class="col-sm-1 control-label">Apellido:</label> ${sessionScope.usuario.apellidos}</p>
<p><label for="email" class="col-sm-1 control-label">Email:</label> ${sessionScope.usuario.email}</p>
<p><label for="dni" class="col-sm-1 control-label">DNI:</label> ${sessionScope.usuario.dni}</p>
<p><label for="cp" class="col-sm-1 control-label">C.P:</label> 49840</p>
<p><label for="direccion" class="col-sm-1 control-label">Dirección:</label> c\La Avenida piruleta nº14</p>
<p><label for="localidad" class="col-sm-1 control-label">Localidad:</label> Leioa</p>
<p><label for="provincia" class="col-sm-1 control-label">Provincia:</label> Bizkaia</p>
<p><label for="pais" class="col-sm-1 control-label">Pais:</label> España</p>
</div>
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
		<c:forEach var="carrito" items="${carritoNew}">	
			<tr>
				<td>${carrito.id}</td>
				<td></td>
				<td>${carrito.cantidad} &euro;</td>
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
		<tr>
			<td></td>
			<td></td>
			<td><a href="productos">Realizar Pago</a></td>
		</tr>
	</tbody>
			
</table>


<%@ include file="includes/pie.jsp" %>
