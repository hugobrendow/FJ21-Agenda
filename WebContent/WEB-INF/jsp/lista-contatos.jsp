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
	<hr />
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereco</th>
			<th>Data Nascimento</th>
			<th>REMOVER</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'E8E8E8' : 'CDC9C9' }">
				<td>${contato.nome}</td>
				<td><c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if> <c:if test="${empty contato.email}">
							E-mail não informado
						</c:if></td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy" />
				</td>
				<td>
				<button type="button" class="btn btn-default">
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</button>
				</td>		
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>