package Application.DAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.Entites.Lieu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LieuDAO implements GenericDAO<Lieu> {

	Set<Lieu> listeLieux = new HashSet<>();

	/**
	 * Constructeur
	 * 
	 */
	public LieuDAO() {
	}

	@Override
	public List<Lieu> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Lieu lieu) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.persist(lieu);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
		em.close();
	}

	@Override
	public void update(int id, Lieu nvObjet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
