<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<!DOCTYPE>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<hr />
	<form class="form-inline" action="adicionaContato" method="POST">
		<div class="form-group">
			<label for="nome">Nome:</label> <input type="text"
				class="form-control" name="nome">
		</div>
		<div class="form-group">
			<label for="email">E-mail:</label> <input type="text"
				class="form-control" name="email">
		</div>
		<div class="form-group">
			<label for="endereco">Endereço:</label> <input type="text"
				class="form-control" name="endereco">
		</div>
		<div class="form-group">
			Data Nascimento
			<caelum:campoData id="dataNascimento"/>
			<br />
		</div>
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>