<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Contato Adicionado</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<div class="alert alert-success">
		<strong>Sucesso! </strong> <br /> Contato ${param.nome} adicionado com
		sucesso!
	</div>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>