<%@ include file="includes/cabecera.jsp"%>

<div class="row">
	<div class="col-sm-6">
		<div class="thumbnail">
			<img src="fotos/${producto.id}.jpg" alt="${producto.descripcion}">
			<div class="caption">
				<h3>${producto.descripcion}</h3>
				<p>${producto.precio}&euro;</p>
				<p>
					<a href="carrito?id=${producto.id}" class="btn btn-primary" role="button">Carrito <span class="glyphicon glyphicon-shopping-cart"></span></a>
				</p>
			</div>
		</div>
	</div>
	<div class="col-sm-6">
		producto es un producto es un producto producido por productores	
	</div>
</div>
<table class="table">
	<tbody>
		<tr>
			<th>ID</th>
			<td>${producto.id}</td>
		</tr>
		<tr>
			<th>Descripci&oacute;n</th>
			<td>${producto.descripcion}</td>
		</tr>
		<tr>
			<th>Precio</th>
			<td>${producto.precio}&euro;</td>
		</tr>
		<tr>
			<th>Foto</th>
			<td><img src="fotos/${producto.id}.jpg" /></td>
		</tr>
	</tbody>
</table>

<%@ include file="includes/pie.jsp"%>
