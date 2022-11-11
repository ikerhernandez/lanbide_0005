<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<c:if test="${empty libros}">
	<style>
		body{
			background-image: url("https://www.librimundi.com/assets/template/img/no_hay_resultados.png");
			background-repeat: no-repeat;
			background-position: center;
		}
	</style>
</c:if>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<c:forEach items="${libros}" var="l">
		<div class="col">
			<div class="card h-100">
				<img src="https://placeimg.com/640/480/tech?${l.id}" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${l.nombre}</h5>
					<p class="card-text">${l.precio}</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">${l.id}</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>