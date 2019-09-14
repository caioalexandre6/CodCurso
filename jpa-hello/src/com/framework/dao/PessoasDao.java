package com.framework.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.framework.model.Pessoa;

public class PessoasDao {

	private static PessoasDao instance;
	EntityManager entityManeger;

	private PessoasDao() {
		entityManeger = getEntityManager();
	}

	public static PessoasDao getInstance() {
		if (instance == null) {
			instance = new PessoasDao();
		}
		return instance;
	}

	private EntityManager getEntityManager() {
		if (entityManeger == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hello");
			entityManeger = factory.createEntityManager();
		}
		return entityManeger;
	}
	
	public void persist(Pessoa pessoa) {
		try {
			entityManeger.getTransaction().begin();
			entityManeger.persist(pessoa);
			entityManeger.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManeger.getTransaction().rollback();
		}
	}
	
	public Pessoa getById(final int id) {
		return entityManeger.find(Pessoa.class,id);
	}
	
	public void merge(Pessoa pessoa) {
		try {
			entityManeger.getTransaction().begin();
			entityManeger.merge(pessoa);
			entityManeger.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManeger.getTransaction().rollback();
		}
	}
	
	public List<Pessoa> findALL() {
		return entityManeger.createQuery(" FROM " + Pessoa.class.getName()).getResultList();
	}

	public void remove(Pessoa pessoa) {
		try {
			entityManeger.getTransaction().begin();
			pessoa = entityManeger.find(Pessoa.class, pessoa.getId());
			entityManeger.remove(pessoa);
			entityManeger.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManeger.getTransaction().rollback();
		}
	}
	public void removeByID(final int id) {
		try {
			Pessoa pessoa = getById(id);
			remove(pessoa);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
