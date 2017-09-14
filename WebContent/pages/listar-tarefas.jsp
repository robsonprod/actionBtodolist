<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Tarefas</title>
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" >
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >
</head>
<body>
<c:import url="cabecalho.jsp" />

<c:choose>
	<c:when test="${not empty msgUsuario}">
		<p class="col-md-4 col-md-offset-4 msg alert alert-danger">${msgUsuario} </p>
	</c:when>
</c:choose>

<div class="corpo table-responsive col-md-10 col-md-offset-1">
	<table class="table table-striped">
	
   		<thead>
   			<tr>
   			<th>#</th>
   				<th>Nome</th>
   				<th>Descrição</th>
   				<th>Opções</th>
   			</tr>
   		</thead>
		<c:forEach var="tarefa" items="${tarefas}" varStatus="id">
			<c:choose>
		   		<c:when test="${not empty tarefa.nome}">
		   		<tbody>
		   			<tr>
		   				<td>${id.count}</td>
		   				<td>${tarefa.nome}</td>
		   				<td>${tarefa.descricao}</td>
		   				<td>
		   					<a href='<c:url value="/sistema?logica=EditaTarefa&id=${tarefa.id}" />' >
		   						<i style="padding-right: 12px;" class="fa fa-file-text-o fa-1x"></i>
		   					</a>
		   					
		   					<a href='<c:url value="/sistema?logica=RemoveTarefa&id=${tarefa.id}" />'>
		   						<i style="color: red;" class="fa fa-times fa-1x"></i>
		   					</a> 
		   				</td>
		   				
		   			</tr>
		   		</tbody>
		   		</c:when>
		   		<c:otherwise>
		   			Campo não preenchido.
		   		</c:otherwise>
	   		</c:choose>
		
		</c:forEach>
	</table>
</div>

	
<c:import url="rodape.jsp" />
</body>
</html>