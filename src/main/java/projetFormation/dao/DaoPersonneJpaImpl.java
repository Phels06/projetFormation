package projetFormation.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import projetFormation.context.Context;
import projetFormation.entity.Personne;

public class DaoPersonneJpaImpl implements DaoPersonne {

	@Override
	public void insert(Personne obj) {
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
	public Personne update(Personne obj) {
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
	public void delete(Personne obj) {
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
	public Optional<Personne> findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Optional<Personne> optional = Optional.ofNullable(em.find(Personne.class, key));
		if (em != null && em.isOpen()) {
			em.close();
		}
		return optional;
	}

	@Override
	public List<Personne> findAll() {
		List<Personne> personnes = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Personne p");
		personnes = query.getResultList();
		if (em != null && em.isOpen()) {
			em.close();
		}
		return personnes;
	}

}
