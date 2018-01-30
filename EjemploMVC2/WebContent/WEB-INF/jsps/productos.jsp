<%@ include file="includes/cabecera.jsp" %>

<div class="mt-4">

    <h1 class="display-4">Productos</h1>
    <p class="lead">Listado de Productos de la Tienda Virtual</p>

	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="/">Inicio</a></li>
	    <li class="breadcrumb-item active" aria-current="page">Productos</li>
	  </ol>
	</nav>
	
	<div class="card">
	  <div class="card-body">
	  
			<div class="table-responsive table-bordered table-striped table-hover">
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="producto" items="${productos}">
							<tr>
								<td>${producto.id}</td>
								<td>${producto.nombre}</td>
								<td>${producto.descripcion}</td>
								<td>${producto.precio} €</td>
								<td width="80"><a href="productos?id=${producto.id}" class="btn btn-secondary">Ver Producto</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>

</div>


<%@ include file="includes/footer.jsp" %>