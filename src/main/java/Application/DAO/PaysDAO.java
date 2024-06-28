package Application.DAO;

import java.util.HashSet;
import java.util.Set;

import Application.Entites.Pays;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

/**
 * 
 */
public class PaysDAO implements GenericDAO<Pays> {
	
	Set<Pays> setPays = new HashSet<>();
	private EntityManager em = DaoLien.em;
	private EntityTransaction transaction = DaoLien.transaction;

	/**
	 * Constructeur
	 */
	public PaysDAO(EntityManager em) { 
		this.setPays = findAll();
	}

	/**
	 * @return
	 */
	public Set<Pays> findAll() {
		TypedQuery<Pays> query = em.createQuery("SELECT p FROM Pays p", Pays.class);
		setPays = new HashSet<>(query.getResultList());

		return setPays;
	}

	/**
	 * @param nom
	 * @return
	 */
	public Pays findByName(String pays) {
		return setPays.stream().filter(l -> l.getNom().equalsIgnoreCase(pays)).findFirst().orElse(null);
	}

	/**
	 * @param langue
	 * @return
	 */
	public boolean ifPaysExists(Pays pays) {
		return setPays.stream().anyMatch(l -> l.getNom().equalsIgnoreCase(pays.getNom()));
	}

	/**
	 *
	 */
	@Override
	public void insert(Pays pays) {

		if (!ifPaysExists(pays)) {
			try {
				transaction.begin();
				em.persist(pays);
				setPays.add(pays);
				transaction.commit();
			} catch (RuntimeException e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw e;
			}

		}
	}

}
