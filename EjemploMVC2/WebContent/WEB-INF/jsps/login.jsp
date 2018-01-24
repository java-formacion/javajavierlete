<%@ include file="includes/cabecera.jsp" %>

<form action="" method="POST">
	<p>
		<label for="email">Email</label>
		<input type="email" id="email" name="email" value="${usuario.getEmail()}" />
	</p>
	<p>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" />
	</p>
	<input type="submit" value="Login" />
</form>

<%@ include file="includes/footer.jsp" %>