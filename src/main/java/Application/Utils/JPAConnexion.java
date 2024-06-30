package Application.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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

	/**
	 * Constructeur
	 * 
	 * @param transaction
	 */

	public static void creationEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(nomPersistenceUnit);
		}
	}

	public static EntityManager getEntityManager() {
		if (emf == null) {
			creationEntityManagerFactory();
		}
		return emf.createEntityManager();
	}


	public static void closeEmf() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
	
	public static void persist (Object entite) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entite);
			em.getTransaction().commit();
		} catch (NullPointerException e) {
			System.err.println(e);
		} finally {
			em.close();
		}
	}

}
