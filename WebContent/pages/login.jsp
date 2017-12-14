<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css" >
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="../css/style.css" >
</head>
<body>
<c:import url="cabecalho.jsp" />

<c:choose>
	<c:when test="${not empty msgUsuario}">
		<p class="col-md-5 col-md-offset-4 msg alert alert-danger">${msgUsuario} </p>
	</c:when>
</c:choose>

<div class="corpo col-md-5 col-md-offset-4">
	<form action="/actionBtodolist/pages/sistema?logica=AutenticaUsuario" method="post" id="formLogin">	
		<div class="form-group">
			<label for="inputLogin">Login</label>
			<input type="text" name="nomeLogin" class="form-control" id="inputLogin" placeholder="Nome"/>
		</div>
		<div class="form-group">
			<label for="inputSenha">Senha</label>
			<input type="password" name="senha" class="form-control" id="inputSenha" placeholder="Senha"/>
		</div>
		<button type="submit" class="btn btn-default"><i class="fa fa-sign-in"></i> Logar</button>
	
	</form>
</div>

<c:import url="rodape.jsp" />
</body>
</html>