<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<li class="mr-4"><a class="text-white hover:underline" href="<%= request.getContextPath() %>/list">Equipos</a></li>
				<li><a class="text-white hover:underline" href="<%= request.getContextPath() %>/new">Agregar equipos</a></li>
			</ul>
		</nav>
	</header><br>
	<div class="mx-auto w-4/5">
		<h1 class="mb-2 text-2xl font-bold text-red-500">LOS EQUIPOS</h1>
		<div class="grid grid-cols-3 gap-4 w-full">
			<c:forEach var="team" items="${listTeams}">
			<div class="">
				<img class="h-40" src="" />
				<p class="py-2"><c:out value="${team.country}"/></p>
				<p class="text-2xl text-red-500"><c:out value="${team.nombre}"/></p>
				<div class="flex">
					<a class="hover:underline" href="edit?id=<c:out value='${team.id}'/>">Editar</a>
					<a class="hover:underline" href="delete?id=<c:out value='${team.id}'/>">Eliminar</a>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>