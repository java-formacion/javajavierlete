<%@ include file="includes/cabecera.jsp"%>

<h2>Sign up</h2>

<form action="login" method="post" class="form-horizontal">
	<fieldset class="well">
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<input type="email" id="email" name="email" value="${usuario.email}"
					class="form-control" required="required" /> <span
					class="text-danger">${errores.email}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Contrase&ntildea</label>
			<div class="col-sm-10">
				<input type="password" id="password" name="password"
					class="form-control" required="required" /> <span
					id="errorpassword" class="text-danger">${errores.password}</span>
			</div>
		</div>
		<div class="form-group">
			<label for="password2" class="col-sm-2 control-label">Confirma Contrase&ntildea</label>
			<div class="col-sm-10">
				<input type="password" id="password2" name="password2"
					class="form-control" required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="first-name" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
				<input type="text" id="nombre" name="first-name"
					class="form-control" required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="last-name" class="col-sm-2 control-label">Apellido</label>
			<div class="col-sm-10">
				<input type="text" id="apellido" name="last-name"
					class="form-control" required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="dni" class="col-sm-2 control-label">DNI</label>
			<div class="col-sm-10">
				<input type="text" id="dni" name="dni" class="form-control"
					required="required" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Sign up" class="btn btn-primary" />
			</div>
		</div>
		<c:if test="${errores.size() > 0}">
			<div class="alert alert-danger" role="alert">${errores.usuario}</div>
		</c:if>

	</fieldset>
</form>
<%
	// Añadir valores para  dni, confirmacion de contraseña, nombre y apellidos
%>
<script src="js/validacionlogin.js"></script>

<%@ include file="includes/pie.jsp"%>