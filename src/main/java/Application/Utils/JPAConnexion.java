package Application.Utils;

import Application.DAO.GenericDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Clase permettant de créer un EntityManager unique et ses méthodes qui seront
 * utilisés pour l'ensemble des transactions entre les classes et la base de
 * données tout en gérant leurs relations.
 * 
 */
public class JPAConnexion {

	private static final String nomPersistenceUnit = "appMovie";
	private static EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction transaction;

//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("appMovie");
//	public EntityManager em = GenericDAO.emf.createEntityManager();
//	public EntityTransaction transaction = null;

	/**
	 * Constructeur
	 * 
	 * @param transaction
	 */

	public JPAConnexion() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(nomPersistenceUnit);
		}
		this.em = emf.createEntityManager();
		this.transaction = em.getTransaction();
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public EntityTransaction startTransaction() {
		return transaction;
	}

	public void closeEm() {
		if (em != null && em.isOpen()) {
			em.close();
		}
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}

}
