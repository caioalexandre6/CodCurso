package com.framework.testes;



import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Remove;

import com.framework.dao.PessoasDao;
import com.framework.dao.PessoasDao;
import com.framework.model.Pessoa;

public class TestaPessoasDao {
	static PessoasDao pessoasDao = PessoasDao.getInstance();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// incluirPessoa();
		// System.out.println("Testando Instâncias do padrão Singlenton");
		// buscarPessoaPorId();
		// merge();
		// listarTodasPessoas();
		//remove();
		testarRemoverobj();
	}

	private static void incluirPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("41545245");
		pessoa.setNome("Mateus");

		pessoasDao.persist(pessoa);
	}

	private static void buscarPessoaPorId() {
		System.out.println(pessoasDao.getById(5));
	}

	public static void merge() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		pessoa.setCpf("454545");
		pessoa.setNome("Carlos");

		pessoasDao.merge(pessoa);
	}

	private static void listarTodasPessoas() {
		List<Pessoa> todasPessoasJPA = pessoasDao.findALL();
		for (Pessoa pessoaLaco : todasPessoasJPA) {
			System.out.println(pessoaLaco);
		}
	}

	private static void remove() {
		pessoasDao.removeByID(1);
	}

	private static void testarRemoverobj() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(3);
		
		pessoasDao.remove(pessoa);
		
	}

}
