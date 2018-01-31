<%@ include file="includes/cabecera.jsp" %>

<h2>Login</h2>

<form action="login" method="post" class="form-horizontal">
   <fieldset class="well">
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
	            <input type="email" id="email" name="email" 
	            	value="${usuario.email}" class="form-control"
	            	required="required" />
	            <span class="text-danger">${errores.email}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Contraseña</label>
            <div class="col-sm-10">
	            <input type="password" id="password" name="password" 
	            	class="form-control" required="required" />
	            <span id="errorpassword" class="text-danger">${errores.password}</span>
            </div>
        </div>
        <div class="form-group">
        	<div class="col-sm-offset-2 col-sm-10">
	            <input type="submit" value="Login" class="btn btn-primary" />
            </div>
        </div>
       	<c:if test="${errores.size() > 0}">
       	   	<div class="alert alert-danger" role="alert">${errores.usuario}</div>
        </c:if>
        
    </fieldset>
</form>

<script src="js/validacionlogin.js"></script>

<%@ include file="includes/pie.jsp" %>