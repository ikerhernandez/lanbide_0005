<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="es-ES" />

<!DOCTYPE html>
<html class="h-100" lang="">
<head>

<base href="${pageContext.request.contextPath}/" />

<meta charset="UTF-8">
<title>UF2218 Ejemplo</title>

<link rel="stylesheet" href="css/stripe.css" />
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">

<script src="js/jquery-3.5.1.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/dataTables.bootstrap5.min.js"></script>
<script src="js/cantidad.js"></script>

<c:if test="${sessionScope.usuario.rol.nombre!='ADMIN' && sessionScope.usuario.rol.nombre == 'USER'}">
	<script src="js/cantidad-total.js"></script>
</c:if>


<script>
	$(document).ready(function() {
		$('table').DataTable({
			language : {
				url : 'json/es-ES.json'
			}
		});
	});
</script>

<style type="text/css">
	img{
		height: 80px;
	}
</style>

</head>
<body class="d-flex flex-column h-100">
	<nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">UF2218 Ejemplo</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#">Principal</a></li>
					<c:if test="${sessionScope.usuario != null}">
					<c:if test="${sessionScope.usuario.rol.nombre=='ADMIN'}">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> Admin </a>
							<ul class="dropdown-menu">
								<li class="nav-item"><a class="dropdown-item" href="admin/facturas">Facturas</a></li>
								<li class="nav-item"><a class="dropdown-item" href="admin/index">Administración</a></li>
							</ul>
						</li>
					</c:if>
					</c:if>
					<c:if test="${sessionScope.usuario != null}">
					<c:if test="${sessionScope.usuario.rol.nombre == 'USER'}">
						<li class="nav-item"><a class="nav-link" href="facturas?id=${sessionScope.usuario.cliente.id }">Facturas</a></li>
					</c:if>
					</c:if>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<c:if test="${sessionScope.usuario.rol.nombre != 'ADMIN' && sessionScope.usuario != null}">
					<li class="nav-item me-3">
						<a class="nav-link d-flex" href="carrito">
							<span class="ms-1">Carrito</span>
							<span class="notification">
								<svg xmlns="http://www.w3.org/2000/svg" width=25" height="25" fill="currentcolor" class="bi bi-cart notification" viewBox="0 0 16 16">
									<path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
								</svg>
								<span class="badge">
									${cantidadcarrito}
								</span>
							</span>
						</a>
					</li>
					</c:if>
					<c:if test="${sessionScope.usuario != null}">
						<li class="navbar-text text-white">
							${sessionScope.usuario.email}/${sessionScope.usuario.rol.nombre}</li>
						<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
					</c:if>
					<c:if test="${sessionScope.usuario == null}">	
						<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<c:if test="${alertaMensaje != null}">
		<div class="alert alert-${alertaNivel} alert-dismissible fade show"
			role="alert">
			${alertaMensaje}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>

	<div class="container-fluid mt-4">