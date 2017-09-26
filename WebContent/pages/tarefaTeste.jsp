<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tarefas</title>
<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<c:import url="cabecalho.jsp" />
<body>
	<c:choose>
		<c:when test="${not empty msgUsuario}">
			<p class="col-md-5 col-md-offset-4 msg alert alert-danger">${msgUsuario}
			</p>
		</c:when>
	</c:choose>
	
	<div class="corpo col-md-5 col-md-offset-4">
	<c:forEach var="tarefa" items="${tarefas}" varStatus="id">
			<c:choose>
		   		<c:when test="${not empty tarefa.nome}">
		   		<tbody>
		   			<tr>
		   				<td>${id.count}</td>
		   				<td>${tarefa.nome}</td>
		   				<td>${tarefa.descricao}</td>
		   			</tr>
		   		</tbody>
		   		</c:when>
		   		<c:otherwise>
		   			<tbody>
			   			<tr>
			   				<td>Nenhuma tarefa cadastrada</td>
			   			</tr>
			   		</tbody>
		   		</c:otherwise>
	   		</c:choose>
		
	</c:forEach>
	</div>
		
	<c:import url="rodape.jsp" />
</body>
</html>