<%@ include file="includes/cabecera.jsp" %>

<h2>${mensaje}</h2>

<form action="usuarioaccion" method="post" class="form-horizontal">
	<fieldset class="well">
	<div class="form-group">
	<div class="col-sm-10">
	<p>
		<label for="dni" class="col-sm-2 control-label" >DNI</label>
		<input type="text" id="dni" name="dni" class="form-control" required="required" value="${usuario.dni}"/>
	</p>
	<p>
		<label for="email" class="col-sm-2 control-label">Email</label>
		<input type="email" id="email" name="email" class="form-control" required="required" value="${usuario.email}"/>
	</p>
	<p>
		<label for="password" class="col-sm-2 control-label">Password</label>
		<input type="password" id="password" name="password" class="form-control" required="required" />
	</p>
	<p>
		<label for="password2" class="col-sm-2 control-label">Password (Repetir)</label>
		<input type="password" id="password2" name="password2" class="form-control" required="required"/>
	</p>
	<p>
		<label for="nombre" class="col-sm-2 control-label">Nombre</label>
		<input type="text" id="nombre" name="nombre" class="form-control" required="required" value="${usuario.nombre}" />
	</p>
	<p>
		<label for="apellidos" class="col-sm-2 control-label">Apellidos</label>
		<input type="text" id="apellidos" name="apellidos" class="form-control" required="required" value="${usuario.apellidos}" />
	</p>
	<p>
	</div>
		</div>
	<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Confirmar" class="btn btn-primary" />
				<input type="hidden" name="op" value="${op}" />
				<input type="hidden" name="id" value="${usuario.id}" />
			</div>
		</div>
		
	</p>
	</fieldset>
	
</form>

<script src="formusuarios.js"></script>

<%@ include file="includes/pie.jsp" %>
