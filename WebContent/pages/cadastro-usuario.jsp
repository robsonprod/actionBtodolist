<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<c:import url="cabecalho.jsp" />

<span>Cadastrar um novo usuário</span>
<form action="sistema" method="post">
	<input type="hidden" name="logica" value="CadastroUsuario" />
	<div class="form-group">
		<label for="newLogin">Login</label>
		<input type="text" name="nomeLogin" class="form-control" id="newLogin" placeholder="Nome"/>
	</div>
	<div class="form-group">
		<label for="newSenha">senha</label>
		<input type="password" name="senha" class="form-control" id="newSenha" placeholder="Senha"/>
	</div>
	<button type="submit" class="btn btn-default">Cadastrar</button>
</form>

<c:import url="rodape.jsp" />

</body>
</html>