<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hovered table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="l">
			<tr>
				<th>${l.id}</th>
				<td>${l.nombre}</td>
				<td>
					<fmt:formatNumber type="currency" value="${l.precio}"></fmt:formatNumber> <%-- Formato para número, ej: 16,00 € --%>
				</td>
				<td>
					<a class="btn btn-sm btn-primary" href="admin/libro?id=${l.id}">Editar</a> 
					<a class="btn btn-sm btn-danger" href="admin/libro/borrar?id=${l.id}">Borrar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-sm btn-primary" href="admin/libro">Añadir</a></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>