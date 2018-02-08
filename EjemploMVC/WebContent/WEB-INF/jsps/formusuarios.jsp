<%@ include file="includes/cabecera.jsp" %>

<h2>${mensaje}</h2>

<form action="usuarioaccion" method="post">
	<p>
		<label for="dni">DNI</label>
		<input type="text" id="dni" name="dni" value="${usuario.dni}"/>
	</p>
	<p>
		<label for="email">Email</label>
		<input type="email" id="email" name="email" value="${usuario.email}"/>
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password" />
	</p>
	<p>
		<label for="password2">Password (Repetir)</label>
		<input type="password" id="password2" name="password2" />
	</p>
	<p>
		<label for="nombre">Nombre</label>
		<input type="text" id="nombre" name="nombre" value="${usuario.nombre}" />
	</p>
	<p>
		<label for="apellidos">Apellidos</label>
		<input type="text" id="apellidos" name="apellidos" value="${usuario.apellidos}" />
	</p>
	<p>
		<input type="submit" value="Confirmar" />
		<input type="hidden" name="op" value="${op}" />
		<input type="hidden" name="id" value="${usuario.id}" />
	</p>
</form>

<script src="formusuarios.js"></script>

<%@ include file="includes/pie.jsp" %>
