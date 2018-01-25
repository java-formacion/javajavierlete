<%@ include file="includes/cabecera.jsp" %>

<div class="row justify-content-center mt-4">

    <div class="col-11 col-sm-6 col-md-6 col-lg-4 col-xl-4">

        <div class="card">
            <div class="card-body">

                <form class="form-signin" action="login" method="POST">

	                <h1 class="h3 mb-3 font-weight-normal text-center">Inicia Sesión</h1>
	
	                <label for="email" class="sr-only">Email</label>
	                <input type="email" id="email" class="form-control" placeholder="Email" name="email" value="${usuario.email}">
	
	                <label for="password" class="sr-only">Password</label>
	                <input type="password" id="password" name="password" class="form-control" placeholder="Password">
	
	                <button class="btn btn-primary btn-block" type="submit">Iniciar Sesión</button>
                
                </form>

            </div>
            
			<div class="card-footer text-muted">
				&copy; 2017-2018
			</div>
        </div>
		
		<c:if test="${errores.size() > 0}">
	        <div class="alert alert-danger alert-dismissible fade show mt-4">
	         	<h4 class="alert-heading">¡Atención!</h4>
	         	<hr />
	            <p>${errores.email}</p>
	            <p>${errores.password}</p>
	            <p>${errores.usuario}</p>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
	        </div>
        </c:if>

    </div>

</div>

<%@ include file="includes/footer.jsp" %>