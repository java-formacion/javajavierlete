<%@ include file="includes/cabecera.jsp" %>


<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="#">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Library</li>
  </ol>
</nav>

<div class="card mt-4">
  <div class="card-body">
  
		<div class="table-responsive table-bordered table-striped table-hover">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Descripción</th>
						<th>Precio</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${productos}">
						<tr>
							<td>${producto.id}</td>
							<td>${producto.descripcion}</td>
							<td>${producto.precio} €</td>
							<td><a href="productos?id=${producto.id}">Ver Producto</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</div>


<%@ include file="includes/footer.jsp" %>