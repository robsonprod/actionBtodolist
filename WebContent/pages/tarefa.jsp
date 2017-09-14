<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tarefa</title>
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
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
		<ul class="list-group">
			<c:choose>
				<c:when test="${not empty tarefaNome}">
					<label>Nome: </label>
					<input class="form-control" type="text" value="${tarefaNome}"
						readonly>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="id" id="inputId" value="" />
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${not empty tarefaDescricao}">
						<label>Descrição: </label>
						<li class="list-group-item list-group-item-info">${tarefaDescricao}</li>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="id" id="inputId" value="" />
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

	<c:import url="rodape.jsp" />
</body>
</html>