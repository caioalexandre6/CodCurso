package com.framework.testes;

import java.util.List;

import com.framework.dao.ClienteDao;
import com.framework.model.Cliente;


public class TestaClienteDao {
	static ClienteDao clienteDao = ClienteDao.getInstance();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// incluirCliente();
		// System.out.println("Testando Instâncias do padrão Singlenton");
		// buscarClientePorId();
		// merge();
		// listarTodasClientes();
		//remove();
		// testarRemoverobj();
	}

	private static void incluirCliente() {
		Cliente Cliente = new Cliente();
		Cliente.setCpf("41545245");
		Cliente.setNome("teste");
		Cliente.setProfissao("Pedreiro");
	

		clienteDao.persist(Cliente);
	}

	public static void merge() {
		Cliente Cliente = new Cliente();
		Cliente.setId(1);
		Cliente.setCpf("454545");
		Cliente.setNome("Carlos");

		clienteDao.merge(Cliente);
	}

}



