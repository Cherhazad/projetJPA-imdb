package Application.DAO;

import java.util.HashSet;
import java.util.Set;

import Application.Entites.Pays;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PaysDAO implements GenericDAO<Pays> {

	Set<Pays> listePays = new HashSet<>();

	/**
	 * Constructeur
	 * 
	 */
	public PaysDAO() {
	}

	@Override
	public void insert(Pays pays) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.persist(pays);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
		em.close();

	}

}
