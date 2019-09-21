package com.framework.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.framework.model.Cliente;

public class ClienteDao {
	
	private static ClienteDao instance;
	EntityManager entityManeger;

	 ClienteDao() {
		entityManeger = getEntityManager();
	}

	 public static ClienteDao getInstance() {
		if (instance == null) {
			instance = new ClienteDao();
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

	public void persist(Cliente Cliente) {
		try {
			entityManeger.getTransaction().begin();
			entityManeger.persist(Cliente);
			entityManeger.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManeger.getTransaction().rollback();
		}
	}

	public Cliente getById(final int id) {
		return entityManeger.find(Cliente.class, id);
	}

	public void merge(Cliente Cliente) {
		try {
			entityManeger.getTransaction().begin();
			entityManeger.merge(Cliente);
			entityManeger.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManeger.getTransaction().rollback();
		}
	}

	public List<Cliente> findALL() {
		return entityManeger.createQuery(" FROM " + Cliente.class.getName()).getResultList();
	}

	public void remove(Cliente Cliente) {
		try {
			entityManeger.getTransaction().begin();
			Cliente = entityManeger.find(Cliente.class, Cliente.getId());
			entityManeger.remove(Cliente);
			entityManeger.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManeger.getTransaction().rollback();
		}
	}

	public void removeByID(final int id) {
		try {
			Cliente Cliente = getById(id);
			remove(Cliente);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
