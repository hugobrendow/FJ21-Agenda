<html>
	<body>
		<%@ page import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*" %>
		<% String mensagem = "Bem-vindo ao sistema de agenda do FJ-21!"; %>
		
		<%out.println(mensagem);%>
		
		<br/>
		<%
			String desenvolvido = "Desenvolvido por Hugo Brendow";
		%>
		
		<%= desenvolvido %>
		
		<br/>
		<br/>
		
		<table>
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereco</th>
				<th>Data de Nascimento</th>
			</tr>
			<%
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getLista();
				
				for(Contato contato : contatos) {
			%>
			<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=contato.getDataNascimento().getTime() %></td>
			</tr>
			
			<%
				}
			%>
		</table>
	</body>
</html>