package Application.DAO;

import Application.Utils.JPAConnexion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * Classe abstraite permettant de faire le lien avec les dao évitant
 * d'instancier à nouveau les DAOs et permettant d'accéder aux méthodes de ces
 * DAO.
 * 
 */
public abstract class DaoLien {
	
	static JPAConnexion connexionJPA = new JPAConnexion();
	
	public static EntityManager em = connexionJPA.getEntityManager();
	public static EntityTransaction transaction = em.getTransaction();

	public static PaysDAO paysDao() {
		return new PaysDAO(em);
	}

	public static LangueDAO langueDao() {
		return new LangueDAO(em);
	}

	public static LieuDAO lieuDao() {
		return new LieuDAO(em);
	}
	
	public static ActeurDAO acteurDao() {
		return new ActeurDAO(em);
	}

}
