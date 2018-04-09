<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Lista de Contatos</title>
<meta charset="UTF-8">
</head>
<body>
	<c:import url="cabecalho.jsp" />

	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao" />
	<hr />

	<table class="table table-striped">
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereco</th>
			<th>Data Nascimento</th>
		</tr>
		<c:forEach var="contato" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'E8E8E8' : 'CDC9C9' }">
				<td>${contato.nome}</td>
				<td><c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if> <c:if test="${empty contato.email}">
							E-mail não informado
						</c:if></td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
			</tr>
		</c:forEach>
	</table>

	<c:import url="rodape.jsp" />
</body>
</html>