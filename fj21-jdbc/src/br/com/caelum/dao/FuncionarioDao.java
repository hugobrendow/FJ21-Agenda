package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {
	private Connection connection;

	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Funcionario funcionario){
		try{
			PreparedStatement stmt = connection.prepareStatement("insert into funcionarios (nome,usuario,senha) values (?,?,?)");
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Funcionario> getLista(){
		try{
			List<Funcionario> funcionarios = new ArrayList<>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from funcionarios");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionarios.add(funcionario);
			}
			rs.close();
			stmt.close();
			return funcionarios;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Funcionario funcionario){
		String sql = "delete from funcionarios where id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Funcionario funcionario){
		String sql = "update funcionarios set nome=?, usuario=?, senha=? where id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
