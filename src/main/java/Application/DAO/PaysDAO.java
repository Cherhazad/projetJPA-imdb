package Application.DAO;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.Entites.Pays;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PaysDAO implements GenericDAO<Pays> {

	Set<Pays> listePays = new HashSet<>();

	/**
	 * Constructeur
	 * 
	 */
	public PaysDAO() {
	}

	@Override
	public List<Pays> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Pays pays) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("appMovie");
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.persist(pays);
			transaction.commit();
			em.close();

		} catch (RuntimeException e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
		

	}

	@Override
	public void update(int id, Pays nvObjet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
