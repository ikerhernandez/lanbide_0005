<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hovered table-striped table-bordered">
	<caption></caption>
	<thead class="table-dark">
		<tr>
			<th id="">Id</th>
			<th id="">Email</th>
			<th id="">Contraseña</th>
			<th id=""></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="u">
			<tr>
				<th id="">${u.id}</th>
				<td>${u.email}</td>
				<td>${u.password}</td>

				<td><a class="btn btn-sm btn-primary"
					href="admin/usuario?id=${u.id}">Editar</a> <a
					class="btn btn-sm btn-danger"
					href="admin/usuario/borrar?id=${u.id}">Borrar</a></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-sm btn-primary" href="admin/usuario">Añadir</a></td>
		</tr>
	</tfoot>
</table>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>