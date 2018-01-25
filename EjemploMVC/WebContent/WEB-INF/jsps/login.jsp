<%@ include file="includes/cabecera.jsp" %>

<%--
<jsp:useBean id="usuario" scope="request" 
	class="com.ipartek.ejemplos.ejemploservidor.modelo.Usuario" />
	
<jsp:useBean id="errores" scope="request" 
	class="java.util.Hashtable" />
<input type="email" name="email" value="<jsp:getProperty name="usuario" property="email" />" />
--%>

<form action="login" method="post">
   <fieldset>
       <legend>Login</legend>
        <p>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" 
            	value="${usuario.email}"/>
            <span class="error">${errores.email}</span>
        </p>
        <p>
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password" />
            <span class="error">${errores.password}</span>
        </p>
        <p>
            <input type="submit" value="Login" />
            <span class="error">${errores.usuario}</span>
        </p>
    </fieldset>
</form>

<%@ include file="includes/pie.jsp" %>