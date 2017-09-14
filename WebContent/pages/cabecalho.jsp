<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css" >
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="../css/style.css" >
</head>
<body class="cabecalho">
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/actionBtodolist/pages/index.jsp">
        <p>ToDoList</p>
      </a>
      
	<ul class="nav navbar-nav navbar-right">
        <li>
			<c:choose>
				<c:when test="${userLogado.cargo == 2}">
					<a href="/actionBtodolist/pages/gerenciar-usuarios.jsp">Gerenciar Usuários</a>
				</c:when>
			</c:choose>
        </li>
    </ul>
    </div>
  </div>
</nav>
</body>
</html>