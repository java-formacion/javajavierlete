<%@ include file="includes/cabecera.jsp" %>

<%--
<jsp:useBean id="usuario" scope="request" 
	class="com.ipartek.ejemplos.ejemploservidor.modelo.Usuario" />
	
<jsp:useBean id="errores" scope="request" 
	class="java.util.Hashtable" />

<input type="email" name="email" value="<jsp:getProperty name="usuario" property="email" />" />
--%>

<h2>Login</h2>

<form action="login" method="post" class="form-horizontal">
   <fieldset class="well">
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
	            <input type="email" id="email" name="email" 
	            	value="${usuario.email}" class="form-control"/>
	            <span class="text-danger">${errores.email}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Contraseña</label>
            <div class="col-sm-10">
	            <input type="password" id="password" name="password" 
	            	class="form-control"/>
	            <span class="text-danger">${errores.password}</span>
            </div>
        </div>
        <div class="form-group">
        	<div class="col-sm-offset-2 col-sm-10">
	            <input type="submit" value="Login" class="btn btn-primary" />
            </div>
        </div>
       	<% if(request.getAttribute("errores") != null) { %>
           	<div class="alert alert-danger" role="alert">${errores.usuario}</div>
        <% } %>
        
    </fieldset>
</form>

<%@ include file="includes/pie.jsp" %>