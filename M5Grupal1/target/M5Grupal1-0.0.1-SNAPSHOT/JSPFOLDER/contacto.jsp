<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<link rel="stylesheet" href="../Style.css">
<link rel="stylesheet" type="text/css" href="./Style.css">
<script src="funciones.js"></script>
<title>formulario</title>


</head>
<header>
	<nav>

		<a class="navbar-brand"><svg xmlns="http://www.w3.org/2000/svg"
				width="32" height="32" fill="currentColor"
				class="bi bi-person-circle" viewBox="0 0 16 16">
			<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
			<path fill-rule="evenodd"
					d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
			</svg> <!-- verificar si existe una sesion activa --> <% 
			HttpSession SessionExistente = request.getSession(false);
			String UserName = null;
			if(SessionExistente != null && SessionExistente.getAttribute("UserName") != null){
				//Si encuentra sesion activa , mostrará el nombre del usuario 
				UserName = (String) SessionExistente.getAttribute("UserName"); 
			}else{
				//response.sendRedirect("./SrvLogin2");
				response.sendRedirect(request.getContextPath() + "/SrvLogin2");
			}
			%> <!-- Integracion del nombreusuario al dom -->
			<p>
				<%= UserName  %></p> </a>

		<ul>
			<li><form action="./Inicio" method="GET">
					<button class="nav" type="submit">Inicio</button>
				</form></li>
			<li><form action="./Contacto" method="GET">
					<button class="nav" type="submit">Contacto</button>
				</form></li>

			<li><form action="./CrearCapacitacion" method="GET">
					<button class="nav" type="submit">Crear Capacitación</button>
				</form></li>
			<li><form action="./SrvCerrarSesion" method="POST">
					<button class="nav" type="submit">Cerrar Sesión</button>
				</form></li>
		</ul>
	</nav>
</header>

<body>

	<div class="containercontacto">

		<div class="cuestionario">
			<h1>Contactanos!</h1>
			<div class="d-flex justify-content-center align-items-center">
				<form id="login-form" action="../SrvlInsertar" method="POST">
					<div class="form-row">
						<div class="col-md-12 mb-3">
							<label for="validationCustom01">Nombre</label> <input type="text"
								class="form-control" id="validationCustom01"
								name="validationCustom01" placeholder="Nombre"> <small
								id="nombreHelp" class="form-text text-danger"></small>



						</div>
						<div class="col-md-12 mb-3">
							<label for="validationCustom02">Apellido</label> <input
								type="text" class="form-control" id="validationCustom02"
								name="validationCustom02" placeholder="Apellido"> <small
								id="apellidoHelp" class="form-text text-danger"></small>
						</div>


					</div>
					<div class="form-row">
						<div class="col-md-12 mb-3">
							<label for="validationCustom03">Ciudad</label> <select
								class="form-control form-control-sm" id="ciudad"
								name="validationCustom03">
								<option selected disabled value="">Selecciona tu ciudad</option>
								<option>Viña del Mar</option>
								<option>Antofagasta</option>
								<option>Santiago</option>
							</select> <small id="ciudadHelp" class="form-text text-danger"></small>
						</div>

						<div class="col-md-12 mb-3">
							<label for="validationCustom05">Mensaje</label>
							<textarea class="form-control" id="validationCustom05"
								name="validationCustom05" cols="30" rows="3"
								placeholder="250 caracteres max"></textarea>
							<small id="mensajeHelp" class="form-text text-danger"></small>
						</div>
					</div>
					<div class="form-group">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="invalidCheck"> <label class="form-check-label"
								for="invalidCheck"> Acepto los términos y condiciones </label><br>
							<small id="checkHelp" class="form-text text-danger"></small>
						</div>

					</div>
					<div class="d-flex justify-content-center">
						<button class="btn btn-primary" type="submit">Enviar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<p>LyleanTozhaa&copy; 2023 - Todos los derechos reservados.</p>
	</footer>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
	crossorigin="anonymous"></script>
</html>