<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/libro" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control ${libro.errores.id == null ? '': 'is-invalid' }" id="id" name="id" value="${libro.id}">
			<div class="invalid-feedback">
				${libro.errores.id}
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control ${libro.errores.nombre == null ? '': 'is-invalid' }" id="nombre" name="nombre" value="${libro.nombre}">
			<div class="invalid-feedback">
				${libro.errores.nombre}
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm-10">
			<input type="number" step=".01" class="form-control ${libro.errores.precio == null ? '': 'is-invalid' }" id="precio" name="precio" value="${libro.precio}">
			<div class="invalid-feedback">
				${libro.errores.precio}
			</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="descuento" class="col-sm-2 col-form-label">Descuento</label>
		<div class="col-sm-10">
			<input type="number" class="form-control ${libro.errores.descuento == null ? '': 'is-invalid' }" id="descuento" name="descuento" value="${libro.descuento}">
			<div class="invalid-feedback">
				${libro.errores.descuento}
			</div>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>