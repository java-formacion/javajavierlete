<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>TiendaVirtual</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="css/estilo.css">
</head>
<script>
insertarUsuario(){
	if(document.insertar.nombre.value.leght==0){
		alert("inserta el nombre");
		return 0;
	}
	if(document.insertar.apellido.value.leght==0){
		alert("inserta el apellido");
		return 0;
	}
	if(document.insertar.telefono.value.leght==0){
		alert("inserta el telefono");
		return 0;
	}
	if(document.insertar.dni.value.leght==0){
		alert("inserta el dni");
		return 0;
	}
	alert("usuario insertado"); 
   	document.insertar.submit(); 
}

eliminarUsuario(){
	if(document.eleminar.dni.leght==0){
		alert("inserta el dni para eliminar");
		return 0;
	}
	alert("usuario eliminado"); 
   	document.eliminar.submit(); 
}

actualizarUsuario(){
	if(document.actualizar.id.leght==0){
		alert("Inserta el id del usuario");
		return 0;
	}
	if(document.actualizar.nombre.leght==0){
		alert("Inserta el nombre nuevo");
		return 0;
	}
	if(document.actualizar.apellidos.leght==0){
		alert("inserta los apellidos nuevos")
		return 0;
	}
	if(document.actualizar.telefono.leght==0){
		alert("inserta el telefonon nuevo");
		return 0;
	}
	if(document.actualizar.dni.leght==0){
		alert("inserta el dni nuevo");
		return 0;
	}
	alert("actualizar eliminado"); 
   	document.actualizar.submit(); 
}

</script>
<body class="container-fluid">
<div class="row">

	<h2>Insertar Usuario</h2>
	
	<form name="insertar">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Nombre</label>
	    <input type="text" class="form-control" name="nombre" aria-describedby="emailHelp" placeholder="Nombre" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Apellido</label>
	    <input type="text" class="form-control" name="apellido" placeholder="Apellido" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Telefono</label>
	    <input type="tel" class="form-control" name="telefono" placeholder="Telefono" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Dni</label>
	    <input type="text" class="form-control" name="dni" placeholder="Dni" required>
	  </div>
	  <button type="button" onclick="insertarUsuario" class="btn btn-primary">Insertar</button>
	</form>
	
</div>

<div class="row">

	<h2>Eliminar Usuario</h2>
	
	<form name="eleminar">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Dni de usuario</label>
	    <input type="text" class="form-control" name="dni" placeholder="Dni del usuario" required>
	  </div>
	  <button type="button" onclick="eliminarUsuario" class="btn btn-primary">Eliminar Usuario</button>
	</form>
	
</div>

<div class="row">
	
	<h2>Actualizar usuario</h2>
	
	
	<form name="actualizar">
	
	  <div class="form-group">
	    <label for="exampleInputEmail1">Id del usuario a modificar</label>
	    <input type="text" class="form-control" name="id" aria-describedby="emailHelp" placeholder="Nombre" required>
	  </div>
	
	  <div class="form-group">
	    <label for="exampleInputEmail1">Nombre</label>
	    <input type="text" class="form-control" name="nombre" aria-describedby="emailHelp" placeholder="Nombre" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Apellido</label>
	    <input type="text" class="form-control" name="apellido" placeholder="Apellido" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Telefono</label>
	    <input type="tel" class="form-control" name="telefono" placeholder="Telefono" required>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Dni</label>
	    <input type="text" class="form-control" name="dni" placeholder="Dni" required>
	  </div>
	  <button type="button" onclick="actualizarUsuario" class="btn btn-primary">Actualizar usuario</button>
	</form>
	
</div>


</body>
</html>