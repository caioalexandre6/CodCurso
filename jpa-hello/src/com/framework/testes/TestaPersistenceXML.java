package com.framework.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.framework.model.Cliente;

public class TestaPersistenceXML {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hello");
		EntityManager entityManager = factory.createEntityManager();

		Cliente cliente = new Cliente();
		cliente.setProfissao("Pedreiro");
		cliente.setNome("Carlos Alexandre");

		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();

		List<Cliente> todasPessoasJPA = entityManager.createQuery(" FROM " + Cliente.class.getName()).getResultList();
		for (Cliente pessoaLaco : todasPessoasJPA) {
			// implementar toString() via suporte da ferramenta
			System.out.println(pessoaLaco);
		}

	}

}
