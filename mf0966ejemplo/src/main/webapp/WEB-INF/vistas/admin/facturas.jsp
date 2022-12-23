<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hovered table-striped table-bordered">
	<caption></caption>
	<thead class="table-dark">
		<tr>
			<th id="">Id</th>
			<th id="">Codigo</th>
			<th id="">Fecha</th>
			<th id="">Cliente</th>
			<th id="">Empleado</th>
			<th id="">Productos</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${facturas}" var="f">
			<tr>
				<th id="">${f.id}</th>
				<td>${f.codigo}</td>
				<td>${f.fecha}</td>
				<td>${f.cliente.id}</td>
				<td>${f.empleado.id}</td>
				<td>
					<a href="admin/mostrarlista?id=${f.id}">Mostrar Lista</a>
<%-- 					<c:forEach items="${f.lineas}" var="l"> --%>
<%-- 						<p>${l.producto.id}</p> --%>
<%-- 					</c:forEach> --%>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-sm btn-primary" href="admin/libro">Añadir</a></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>