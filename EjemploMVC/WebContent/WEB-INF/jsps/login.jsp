<%@ include file="includes/cabecera.jsp" %>

<form action="login" method="post">
   <fieldset>
       <legend>Login</legend>
        <p>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" />
        </p>
        <p>
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password" />
        </p>
        <p>
            <input type="submit" value="Login" />
            <span class="error"></span>
        </p>
    </fieldset>
</form>

<%@ include file="includes/pie.jsp" %>