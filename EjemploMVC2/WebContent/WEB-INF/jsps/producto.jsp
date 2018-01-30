<%@ include file="includes/cabecera.jsp" %>

<div class="mt-4">

    <h1 class="display-4">Productos</h1>
    <p class="lead">Listado de Productos de la Tienda Virtual</p>

	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="/">Inicio</a></li>
	    <li class="breadcrumb-item"><a href="productos">Productos</a></li>
	    <li class="breadcrumb-item active" aria-current="page">${producto.nombre}</li>
	  </ol>
	</nav>
	
</div>

<%@ include file="includes/footer.jsp" %>