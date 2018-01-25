<%@ include file="includes/cabecera.jsp" %>

<form action="login" method="POST">
	<p>
		<label for="email">Email</label>
		<input type="email" id="email" name="email" value="${usuario.email}" />
		<span class="error">${errores.email}</span>
	</p>
	<p>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" />
		<span class="error">${errores.password}</span>
	</p>
	<input type="submit" value="Login" />
	<span class="error">${errores.usuario}</span>
</form>

<%@ include file="includes/footer.jsp" %>