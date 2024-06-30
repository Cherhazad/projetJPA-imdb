package Application.DAO;

import java.util.HashSet;
import java.util.Set;

import Application.Entites.Pays;
import Application.Utils.JPAConnexion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * 
 */
public class PaysDAO implements GenericDAO<Pays> {

	Set<Pays> setPays = new HashSet<>();

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
		TypedQuery<Pays> query = JPAConnexion.getEntityManager().createQuery("SELECT p FROM Pays p", Pays.class);
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
		if (pays == null || pays.getNom() == null) {
			return false;
		}
		return setPays.stream().anyMatch(l -> l != null && l.getNom().equalsIgnoreCase(pays.getNom()));
	}

	/**
	 *
	 */
	@Override
	public void insert(Pays pays) {

		JPAConnexion.persist(pays);
		setPays.add(pays);

	}

}
