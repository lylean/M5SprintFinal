<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="./Style.css">
<link rel="stylesheet" type="text/css" href="../Style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<script src="funciones.js"></script>
<title>capacitacion</title>
</head>
<body>
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
 if (SessionExistente != null && SessionExistente.getAttribute("UserName") != null) {
 	//Si encuentra sesion activa , mostrará el nombre del usuario 
 	UserName = (String) SessionExistente.getAttribute("UserName");
 } else {
 	//response.sendRedirect("./SrvLogin2");
 	response.sendRedirect(request.getContextPath() + "/SrvLogin2");
 }
 %> <!-- Integracion del nombreusuario al dom -->
				<p>
					<%=UserName%></p> </a>

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

	<div class="Contanier">
		<h1>Editar Informacion de Capacitaciones</h1>
		<form action="./ServletEditarCapacitaciones" method="POST">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Detalle</th>
						<th>Creador</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=request.getAttribute("id")%></td>
						<td><input type="text" class="form-control" name="nombre"
							value="<%=request.getAttribute("nombre")%>"></td>
						<td><input type="text" class="form-control" name="detalle"
							value="<%=request.getAttribute("detalle")%>"></td>
						<td><input type="text" class="form-control" readonly
							name="nombreUsuario"
							value="<%=request.getAttribute("nombreUsuario")%>"></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="id"
				value="<%=request.getAttribute("id")%>">
			<div class="d-grid gap-2 col-6 mx-auto">
				<button type="submit" name="actualizar" class="btn btn-primary">Actualizar</button>
			</div>
		</form>
	</div>

	<footer>
		<p>LyleanTozhaa&copy; 2023 - Todos los derechos reservados.</p>
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
		crossorigin="anonymous"></script>
</body>
</html>
