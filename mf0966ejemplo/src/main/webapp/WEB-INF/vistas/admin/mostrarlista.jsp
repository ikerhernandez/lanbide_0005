<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hovered table-striped table-bordered">
	<caption></caption>
	<thead class="table-dark">
		<tr>
			<th id="">Id</th>
			<th id="">Nombre</th>
			<th id="">Descripcion</th>
			<th id="">Categoria</th>
			<th id="">Cantidad</th>
			<th id="">Precio/ud</th>
			<th id="">Total</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<th id="">${p.producto.id}</th>
				<td>${p.producto.nombre}</td>
				<td>${p.producto.descripcion}</td>
				<td>${p.producto.categoria.id}</td>
				<td>${p.cantidad}</td>
				<td><fmt:formatNumber type="currency">${p.producto.precio}</fmt:formatNumber></td>
				<td class="text-end"><fmt:formatNumber type="currency">${p.producto.precio*p.cantidad}</fmt:formatNumber></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr style="color=white;">
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td class="text-end">TOTAL:</td>
			<td class="text-end"><fmt:formatNumber type="currency">${total}</fmt:formatNumber></td>
			
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>