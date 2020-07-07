<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%
	Boolean showIngreso = false;
	showIngreso = (Boolean) request.getAttribute("mostrarMensaje");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>

<link href="${pageContext.request.contextPath}/css/estilos.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<div class="row my-5">

			<div class="col-4"></div>

			<div class="row-4">

				<h1>Ingresar nuevo usuario</h1>

				<div class="wrapper fadeInDown">
					<div id="formContent">
						<form action="ingresarUsuario" method="POST">
							<div class="form-group">
								<label for="nombre">Nombre Completo</label> <input type="text"
									class="form-control" name="nombre" id="nombre"
									placeholder="ingrese su nombre..." required="required" />
							</div>

							<div class="form-group">
								<label for="username">Correo</label> <input type="text"
									class="form-control" name="correo" id="correo"
									placeholder="ingrese su correo..." required="required" />
							</div>

							<div class="form-group">
								<label for="password">Contraseña</label> <input type="password"
									class="form-control" name="contrasenia" id="contrasenia"
									placeholder="ingrese su contraseña..." required="required" />
							</div>

							<div class="form-group">
								<label for="anio_nac">Año de nacimiento</label> <input
									type="number" class="form-control" name="anioNacimiento"
									id="anioNacimiento"
									placeholder="ingrese su año de nacimiento..."
									required="required" />
							</div>

							<button type="submit" class="btn btn-primary">Ingresar</button>
							<a href="index.jsp" class="btn btn-secondary active"
								role="button" aria-pressed="true">Volver ...</a>
						</form>

					</div>
				</div>
			</div>
		</div>

		<div class="row-4"></div>
	</div>

	<!-- The Modal: Usuario ingresado-->
	<div class="modal" id="modalIngreso">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Usuario ingresado</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">nuevo usuario registrado</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<a href="index.jsp" class="btn btn-secondary active" role="button"
						aria-pressed="true">Cerrar</a>
				</div>

			</div>
		</div>
	</div>


	<%
		if (showIngreso != null && showIngreso.equals(true)) {
	%>
	<Script>
		$('#modalIngreso').modal('show')
	</Script>
	<%
		}
	%>

</body>
</html>