<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Tarefa</title>
<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css" >
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="../css/style.css" >
</head>
<body>
<c:import url="cabecalho.jsp" />

<div class="corpo col-md-6 col-md-offset-4">
	<form class="add-tarefa" action="sistema?logica=AdicionaTarefa" method="post">
		<c:choose>
			<c:when test="${not empty id}">
				<input  type="hidden" name="id" id="inputId" value="${id}"/>
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>
		<div class="form-group">
			<label for="inputNome">Nome da Tarefa</label>
			<c:choose>
				<c:when test="${not empty nome}">
					<input type="text" name="nome" class="form-control" id="inputNome" value="${nome}"/>
				</c:when>
				<c:otherwise>
					<input type="text" name="nome" class="form-control" id="inputNome" placeholder="tarefa"/>
				</c:otherwise>
			</c:choose>
			
		</div>
		<div class="form-group">
			<label for="inputDescricao">Descrição</label>
			<c:choose>
				<c:when test="${not empty descricao}">
					<input type="text" name="descricao" class="form-control" id="inputDescricao" value="${descricao}"/>
				</c:when>
				<c:otherwise>
					<input type="text" name="descricao" class="form-control" id="inputDescricao" placeholder="descrição da tarefa"/>
				</c:otherwise>
			</c:choose>
		</div>
		
		<button type="submit" class="btn btn-default"><i class="fa fa-sign-in"></i> Salvar</button>
	</form>
</div>

	
<c:choose>
	<c:when test="${not empty msgUsuario}">
		<p class="col-md-5 col-md-offset-4 msg alert alert-danger">${msgUsuario} </p>
	</c:when>
	<c:otherwise>
		<p style="display: none;" class="alert alert-danger">Não foi possivel efetuar operação!</p>
	</c:otherwise>
</c:choose>
	
<c:import url="rodape.jsp" />
</body>
</html>