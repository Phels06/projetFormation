package projetFormation.dao;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import projetFormation.context.Context;
import projetFormation.entity.Chien;
import projetFormation.entity.Personne;

public class DaoChienJpaImpl implements DaoChien {

	@Override
	public void insert(Chien obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	@Override
	public Chien update(Chien obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			obj = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
		return obj;
	}

	@Override
	public void delete(Chien obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Personne.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	@Override
	public Optional<Chien> findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Optional<Chien> optional = Optional.ofNullable(em.find(Chien.class, key));
		if (em != null && em.isOpen()) {
			em.close();
		}
		return optional;
	}

	@Override
	public List<Chien> findAll() {
		List<Chien> chiens = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query=em.createNamedQuery("Chien.findAll");
		chiens = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return chiens;
	}

	@Override
	public List<Chien> findBySurnom(String surnom) {
		List<Chien> chiens = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		// création d'une requête
		Query query = em.createNamedQuery("Chien.findBySurnom");
		query.setParameter("surnom", surnom);
		chiens = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return chiens;
	}
	
}
