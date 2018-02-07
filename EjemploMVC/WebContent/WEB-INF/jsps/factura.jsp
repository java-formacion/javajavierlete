<%@ include file="includes/cabecera.jsp"%>

<div class="container">
	<div class="row">
		<div
			class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<address>
						<strong>TiendaVirtual.com</strong> <br> P.O. Box 2012 <br>
						Bilbao, Mi 48001 
					</address>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6 text-right">
					<p>
						<em>${factura.fecha}</em>
					</p>
					<p>
						<em>${factura.codigo}</em>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="text-center">
					<h1>Factura</h1>
				</div>
				</span>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Producto</th>
							<th>Cantidad</th>
							<th class="text-center">Precio</th>
							<th class="text-center">Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="producto" items="${carrito}">
							<tr>
								<td>${producto.descripcion}</td>
								<td><p class="text-center">${producto.id}</p></td>
								<td><p class="text-center">${producto.precio}&euro;</p></td>
								<td><p class="text-center">${producto.precio}&euro;</p></td>
							</tr>
						</c:forEach>
						
						<tr>
							<td> </td>
							<td> </td>
							<td class="text-right">
								<p>
									<strong>Subtotal: </strong>
								</p>
								<p>
									<strong>Tax: </strong>
								</p>
							</td>
							<td class="text-center">
								<p>
									<strong>$6.94</strong>
								</p>
								<p>
									<strong>$6.94</strong>
								</p>
							</td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							<td class="text-right"><h4>
									<strong>Total: </strong>
								</h4></td>
							<td class="text-center text-danger"><h4>
									<strong>$31.53</strong>
								</h4></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>




	<%@ include file="includes/pie.jsp"%>