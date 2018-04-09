package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setId(2l);
		
		ContatoDao dao = new ContatoDao();
		dao.remove(contato);
		System.out.println("Contato Removido "+ contato.getNome());
	}

}
