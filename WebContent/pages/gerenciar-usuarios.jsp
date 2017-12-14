<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuários</title>
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" >
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >
</head>
<body class="corpo">
<c:import url="cabecalho.jsp" />

<div class="corpo table-responsive col-md-10 col-md-offset-1">
	<table class="table table-striped">
	
   		<thead>
   			<tr>
   			<th>#</th>
   				<th>Login</th>
   				<th>Cargo</th>
   			</tr>
   		</thead>
		<c:forEach var="usuario" items="${usuarios}" varStatus="id">
			<c:choose>
		   		<c:when test="${not empty usuario.nomeLogin}">
		   		<tbody>
		   			<tr>
		   				<td>${id.count}</td>
		   				<td>${usuario.nomeLogin}</td>
		   				<c:choose>
					   		<c:when test="${usuario.cargo == 1}">
					   			<td>Admin</td>
					   		</c:when>
					   		<c:otherwise>
		 						<td>Usuário</td>
		 					</c:otherwise>
				   		</c:choose>
		   				
		   			</tr>
		   		</tbody>
		   		</c:when>
		   		<c:otherwise>
		   			<tbody>
			   			<tr>
			   				<td>Nenhum usuario cadastrada</td>
			   			</tr>
			   		</tbody>
		   		</c:otherwise>
	   		</c:choose>
		
		</c:forEach>
	</table>
</div>

<c:import url="rodape.jsp" />

</body>
</html>