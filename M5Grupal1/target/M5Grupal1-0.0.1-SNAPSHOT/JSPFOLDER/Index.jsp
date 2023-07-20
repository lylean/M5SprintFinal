<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<title>Seguro Laboral</title>
<link rel="stylesheet" type="text/css" href="./Style.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav>
			<ul>
				<li>
					<form action="./Inicio" method="GET">
						<button class="nav" type="submit">Inicio</button>
					</form>
				</li>
				<li><form action="./Contacto" method="GET">
						<button class="nav" type="submit">Contacto</button>
					</form></li>

				<li><form action="./CrearCapacitacion" method="GET">
						<button class="nav" type="submit">Crear Capacitación</button>
					</form></li>

				<% 
			HttpSession SessionExistente = request.getSession(false);
			String UserName = null; 
			if(SessionExistente != null && SessionExistente.getAttribute("UserName") != null){
			
			%>
				<li>
					<form action="./SrvCerrarSesion" method="POST">
						<button class="nav" type="submit">Cerrar Sesión</button>
					</form>
				</li>
				<%
			}else{
			%>
				<li>
					<form action="./SrvLogin2" method="GET">
						<button class="nav" type="submit">Iniciar Sesión</button>
					</form>
				</li>
				<%
			}
			%>
			</ul>
		</nav>
	</header>

	<!-- diseño de las 3 columnas -->

	<div class="container2">
		<div class="columna columna-1">
			<div class="accordion accordion-flush" id="accordionFlushExample">
				<div class="accordion-item">
					<h2 class="accordion-header">
						<button class="accordion-button collapsed" type="button"
							data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
							aria-expanded="false" aria-controls="flush-collapseOne">
							Consultar</button>
					</h2>
					<div id="flush-collapseOne" class="accordion-collapse collapse"
						data-bs-parent="#accordionFlushExample">
						<div class="accordion-body">
							<ul class="list-group list-group-flush">
								<li class="list-group-item"><form
										action="./ServletListarUsuarios" method="GET">
										<button class="invisble">Listar usuarios</button>
									</form></li>
								<li class="list-group-item"><form
										action="./SrvListarCapacitaciones" method="GET">
										<button class="invisble">Listar Capacitaciones</button>
									</form></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="columna columna-2">
			<div class="scroll-content">
				<div id="carouselExampleIndicators" class="carousel slide">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<div class="hero">
								<h1>Seguridad y Salud en el Trabajo</h1>
								<p>Protegemos a los trabajadores y mejoramos la gestión de
									seguridad y salud en las empresas.</p>
							</div>
							<img src="./imagenes/rie.jpg" class="d-block" alt="...">
						</div>
						<div class="carousel-item">
							<h1>Servicios de Prevención</h1>
							<p>Ofrecemos servicios de prevención de riesgos laborales,
								evaluación de ambientes de trabajo y capacitación para fomentar
								una cultura de seguridad.</p>
							<img src="./imagenes/z.jpg" class="d-block" alt="...">
						</div>
						<div class="carousel-item">
							<h1>Seguro Laboral</h1>
							<p>Nuestro seguro laboral protege a los trabajadores en caso
								de accidentes o enfermedades profesionales, garantizando su
								atención médica y compensaciones correspondientes.</p>
							<img src="./imagenes/3sh5.webp" class="d-block" alt="...">
						</div>

					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>


			</div>
		</div>
		<div class="columna columna-3">
			<h3>Columna 3</h3>
		</div>
	</div>
	<!-- fin del diseño de las 3 columnas -->

	<footer>
		<p>LyleanTozhaa&copy; 2023 - Todos los derechos reservados.</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>