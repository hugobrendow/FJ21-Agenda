package br.com.caelum.jdbc.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaFuncionarios {
	public static void main(String[] args) {
		FuncionarioDao dao = new FuncionarioDao();
		Funcionario func = new Funcionario();
		func.setId(1l);
		dao.remove(func);
//		func.setNome("Frederico");
//		func.setSenha("papagaio");
//		func.setUsuario("frederico.cunha");
		System.out.println("Funcionario removido");
		
//		List<Funcionario> funcionarios = new ArrayList<>();
//		funcionarios = dao.getLista();
//		
//		for(Funcionario funcionario : funcionarios){
//			System.out.println("ID: "+ funcionario.getId());
//			System.out.println("Nome: "+ funcionario.getNome());
//			System.out.println("Usuário: "+ funcionario.getUsuario());
//			System.out.println("Senha: *******\n");
//		}
		
	}
}
