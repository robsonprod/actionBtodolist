<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pesquisar</title>
<link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<c:import url="cabecalho.jsp" />

	<div class="corpo" style="padding-top: 150px;">
		<form action="sistema?logica=PesquisaTarefa" method="post" id="formPesquisar">
			<div class="col-md-6 col-md-offset-3">
				<div class="input-group">
					<input type="text" class="form-control" name="nome"
						placeholder="Pesquisar tarefa pelo nome" />
						
						<span class="input-group-btn">
							<button class="btn btn-default" type="submit" >Pesquisar</button>
						</span>
				</div>
			</div>
		</form>
	</div>


	<c:import url="rodape.jsp" />

</body>
</html>