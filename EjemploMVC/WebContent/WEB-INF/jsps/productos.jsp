<%@ include file="includes/cabecera.jsp" %>

<h2>LISTADO DE PRODUCTOS</h2>
<% /*

<table class="table">
	<thead>
		<tr>
			<th>ID</th><th>Descripci&oacute;n</th><th>Precio</th><th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="producto" items="${productos}">	
			<tr>
				<td>${producto.id}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio} &euro;</td>
				<td><a href="productos?id=${producto.id}">Ver ficha</a>
			</tr>
		</c:forEach>
	</tbody>
			
</table>

*/%>
<div class="row">
<c:forEach var="producto" items="${productos}">	
	<div class="col-sm-3">
	
		
		
			<img src="fotos/${producto.id}.jpg" alt="${producto.descripcion}" height="168px" width="200px"/>
			<div class="caption">
				<h3>${producto.nombre}</h3>
				<p>${producto.precio}&euro;</p>
				<p>
					<a href="productos?id=${producto.id}" class="btn btn-primary" role="button">Ver ficha <span class="glyphicon glyphicon-sunglasses"></span></a>
				</p>
				
			</div>
			
		
		
	</div>
	</c:forEach>
</div>	


<%@ include file="includes/pie.jsp" %>
