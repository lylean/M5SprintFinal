<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Log</title>
<link rel="stylesheet" type="text/css" href="./Style.css">
<link rel="stylesheet" type="text/css" href="../Style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>

	<div class="modal fade" id="errorModal" tabindex="-1"
		aria-labelledby="errorModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="errorModalLabel">Error de
						autenticación</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Usuario o contraseña incorrectos. Por favor, inténtalo de
						nuevo.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cerrar</button>
				</div>
			</div>
		</div>
	</div>

	<section>

		<div class="login-box">
			<form action="./SrvLogin2" method="post">
				<h2>Login</h2>

				<div class="input-box">
					<span class="icon"><ion-icon name="mail-outline"></ion-icon></span>
					<input type="text" name="User" required autocomplete="off">
					<label>Email</label>
				</div>

				<div class="input-box">
					<span class="icon"><ion-icon name="lock-closed-outline"></ion-icon></span>
					<input type="password" name="Pass" required autocomplete="off">
					<label>Password</label>
				</div>


				<div class="remember-forgot">
					<label><input type="checkbox">Recordar contraseña?</label>
					<a href="#">Recuperar contraseña</a>
				</div>


				<button class="login" type="submit">Login</button>
				<div class="register-link">
					<p>No esta registrado?</p>
				</div>
			</form>
			<form action="./ServletCrearUsuario" method="get">
				<button type="submit" class="register-button">Registrar</button>
			</form>
		</div>


	</section>

	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>

	<script>
		// Verifica si el parámetro de error está presente en la URL
		const urlParams = new URLSearchParams(window.location.search);
		const error = urlParams.get('error');

		// Si hay un error, muestra el modal automáticamente
		if (error === 'incorrect') {
			const errorModal = new bootstrap.Modal(document
					.getElementById('errorModal'));
			errorModal.show();
		}
	</script>


</body>
</html>