package Application.DAO;

import java.util.ArrayList;
import java.util.List;

import Application.Entites.Pays;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class PaysDAO implements GenericDAO<Pays> {

	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	List<Pays> listePays = new ArrayList<>();

	/**
	 * Constructeur
	 */
	public PaysDAO() {
		this.listePays = findAll();
	}

	/**
	 * @return
	 */
	public List<Pays> findAll() {
		TypedQuery<Pays> query = em.createQuery("SELECT p FROM Pays p", Pays.class);
		listePays = query.getResultList();

		return listePays;
	}

	/**
	 * @param nom
	 * @return
	 */
	public Pays findByName(String pays) {
		return listePays.stream().filter(l -> l.getNom().equalsIgnoreCase(pays)).findFirst().orElse(null);
	}
	

	/**
	 * @param langue
	 * @return
	 */
	public boolean ifPaysExists(Pays pays) {
		return listePays.stream().anyMatch(l -> l.getNom().equalsIgnoreCase(pays.getNom()));
	}

	@Override
	public void insert(Pays pays) {

		if (!ifPaysExists(pays)) {
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
		//	em.close();

		}
	}


}
