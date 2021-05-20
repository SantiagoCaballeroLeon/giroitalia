<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aplicación Gestión de Equipos</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
	<header class="w-full bg-gray-600 py-4">
		<nav class="w-4/5 mx-auto">
			<ul class="flex">
				<li class="mr-4"><a class="text-white hover:underline" href="<%= request.getContextPath() %>/list">Usuarios</a></li>
				<li><a class="text-white hover:underline" href="<%= request.getContextPath() %>/new">Agregar usuarios</a></li>
			</ul>
		</nav>
	</header><br>
	<div class="mx-auto w-4/5">
		<c:if test="${team != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${team == null}">
			<form action="insert" method="post">
		</c:if>
		<c:if test="${team != null}">
			<p class="mb-4 font-bold text-2xl">Editar equipo</p>
		</c:if>
		<c:if test="${team == null}">
			<p class="mb-4 font-bold text-2xl">Agregar equipo</p>
		</c:if>
			<div class="">
				<c:if test="${team != null}">
					<input required type="text" name="id" value="<c:out value='${team.id }'/>" />
				</c:if>
				<input class="border border-black block mb-2 p-1" required type="text" name="nombre" placeholder="nombre" value="<c:out value='${team.name }'/>" />
				<input class="border border-black block mb-2 p-1" required type="text" name="email" placeholder="email" value="<c:out value='${team.country }'/>" />
				<input class="bg-blue-500 text-white py-2 px-4" type="submit" value="Guardar" />
			</div>
		</form>
	</div>
</body>
</html>