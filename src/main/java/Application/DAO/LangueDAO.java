package Application.DAO;

import java.util.ArrayList;
import java.util.List;

import Application.Entites.Langue;
import Application.Utils.DaoLien;
import Application.Utils.JPAConnexion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

/**
 * 
 */
public class LangueDAO implements GenericDAO<Langue> {
	
	List<Langue> listeLangues = new ArrayList<>();
	private EntityManager em = DaoLien.em;
	private EntityTransaction transaction = DaoLien.transaction;

	/**
	 * Constructeur
	 */
	public LangueDAO(EntityManager em) { 
		this.listeLangues = findAll();
	}

	/**
	 * @return
	 */
	public List<Langue> findAll() {
		TypedQuery<Langue> query = em.createQuery("SELECT l FROM Langue l", Langue.class);
		listeLangues = query.getResultList();

		return listeLangues;
	}

	/**
	 * @param nom
	 * @return
	 */
	public Langue findByName(String langue) {
		return listeLangues.stream().filter(l -> l.getNom().equalsIgnoreCase(langue)).findFirst().orElse(null);
	}

	/**
	 * @param langue
	 * @return
	 */
	public boolean ifLangueExists(String langue) {
		return listeLangues.stream().anyMatch(l -> l.getNom().equalsIgnoreCase(langue));
	}

	@Override
	public void insert(Langue langue) {

		if (!ifLangueExists(langue.getNom())) {
			try {
				transaction.begin();
				em.persist(langue);
				listeLangues.add(langue);
				transaction.commit();

			} catch (RuntimeException e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw e;
			}
		}
		// em.close();
	}
}
