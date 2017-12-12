<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css" >
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="../css/style.css" >
</head>
<body>
<c:import url="cabecalho.jsp" />

<c:choose>
	<c:when test="${not empty msgUsuario}">
		<span class="col-md-4 col-md-offset-4 msg alert alert-success">${msgUsuario} </span>
	</c:when>
	<c:otherwise>
		<div class="jumbotron texto-menu">
			<div class="col-md-5 col-md-offset-4">
				<h2>Seja bem vindo,</h2><p style="font-size: 20px;"> ${userLogado.nomeLogin} </p>
				a sua agenda de tarefas!!!
			</div>
		</div>
 	</c:otherwise>
</c:choose>
	
	
	<div class="row col-md-5 col-md-offset-4">
		<p>Opções</p>
	<ul class="nav nav-pills nav-stacked">
		<li class="presentation">
			<a href='<c:url value="/pages/adiciona-tarefa.jsp" />'>
				Adicionar Tarefa
			</a>
		</li>

		<li>
			<a href='<c:url value="/pages/sistema?logica=ListaTarefa" />'>
				Listar Suas Tarefas
			</a>
		</li>
	</ul>

	</div>
	

<c:import url="rodape.jsp" />
</body>
</html>