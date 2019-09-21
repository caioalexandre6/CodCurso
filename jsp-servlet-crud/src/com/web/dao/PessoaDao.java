package com.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.web.model.Pessoa;

public class PessoaDao {
	/**
	 * Método utilizado para obter o entity manager.
	 */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		try {
			// Obtém o factory a partir da unidade de persistência.
			factory = Persistence.createEntityManagerFactory("ExemplosJPAPU");
			// Cria um entity manager.
			entityManager = factory.createEntityManager();
			// Fecha o factory para liberar os recursos utilizado.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// factory.close();
		}
		return entityManager;
	}

	public Pessoa salvar(Pessoa pessoa) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			System.out.println("Salvando a pessoa");
			if (pessoa.getId() == null) {
				entityManager.persist(pessoa);
			} else {
				pessoa = entityManager.merge(pessoa);
			}

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return pessoa;
	}

	/**
	 * Método que apaga a pessoa do banco de dados.
	 */
	public void excluir(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			// Inicia uma transação com o banco de dados.
			entityManager.getTransaction().begin();
			// Consulta a pessoa na base de dados através do seu ID.
			Pessoa pessoa = entityManager.find(Pessoa.class, id);
			System.out.println("Excluindo os dados de: " + pessoa.getNome());
			// Remove a pessoa da base de dados.
			entityManager.remove(pessoa);
			// Finaliza a transação.
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	/**
	 * Consulta o pessoa pelo ID.
	 */
	public Pessoa consultarPorId(Long id) {
		EntityManager entityManager = getEntityManager();
		Pessoa pessoa = null;
		try {
			// Consulta uma pessoa pelo seu ID.
			pessoa = entityManager.find(Pessoa.class, id);
		} finally {
			entityManager.close();
		}
		return pessoa;
	}

	// Listar todas as pessoas.
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarTodos() {
		EntityManager entityManager = getEntityManager();
		return entityManager.createQuery("Select p from Pessoa p").getResultList();
	}

}
