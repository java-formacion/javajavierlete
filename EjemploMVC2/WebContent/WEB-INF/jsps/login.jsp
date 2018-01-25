<%@ include file="includes/cabecera.jsp" %>

<div class="row justify-content-center">

    <div class="col-11 col-sm-6 col-md-6 col-lg-4 col-xl-4">

        <div class="card">
            <div class="card-body">

                <form class="form-signin" action="login" method="POST">

                <h1 class="h3 mb-3 font-weight-normal text-center">Inicia sesión</h1>

                <label for="email" class="sr-only">Email</label>
                <input type="email" id="email" class="form-control" placeholder="Email" name="email" value="${usuario.email}">

                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password">


                <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button>


                <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
                </form>

            </div>
        </div>
		
		<c:if test="${errores.size() > 0}">
	        <div class="alert alert-danger mt-4">
	            <p>${errores.email}</p>
	            <p>${errores.password}</p>
	            <p>${errores.usuario}</p>
	        </div>
        </c:if>

    </div>

</div>

<%@ include file="includes/footer.jsp" %>