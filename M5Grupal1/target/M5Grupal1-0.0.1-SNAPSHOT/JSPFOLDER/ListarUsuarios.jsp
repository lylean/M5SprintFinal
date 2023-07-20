<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="java.util.List"%>
<%@ page import="patronDAO.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar capacitaciones</title>
<link rel="stylesheet" type="text/css" href="./Style.css">
<link rel="stylesheet" type="text/css" href="../Style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
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

	<div>
		<h1>Lista de Usuario</h1>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Tipo</th>
					<th>Opciones</th>
				</tr>
			</thead>
			<tbody>
				<%List<Usuario> usuarios = (List<Usuario>)(request.getAttribute("usuarios")); %>
				<%if(usuarios != null){ %>
				<%for(Usuario usuario : usuarios) {%>
				<tr>
					<td><%=usuario.getId() %></td>
					<td><%=usuario.getNombre() %></td>
					<td><%=usuario.getTipo() %></td>
					<td><form action="./ServletEditarUsuario" method="GET">
							<input type="hidden" name="idEditar" value="<%=usuario.getId()%>">
							<button type="submit" class="btn btn-primary">Editar</button>
						</form></td>
				</tr>
				<%} %>
				<%} %>
			</tbody>
		</table>
	</div>



	<footer>
		<p>LyleanTozhaa&copy; 2023 - Todos los derechos reservados.</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>