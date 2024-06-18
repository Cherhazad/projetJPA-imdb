package Application.Utils;

import Application.DAO.GenericDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAConnexion {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("appMovie");
	public EntityManager em = GenericDAO.emf.createEntityManager();
	public EntityTransaction transaction = null;

	
	/** Constructeur
	 * @param emf
	 * @param em
	 * @param transaction
	 */
	public JPAConnexion() {
		this.transaction = em.getTransaction();
	}
	
	public void startTransaction() {
		this.transaction.begin();
	}
	
	public void commitTransaction() {
		this.transaction.commit();
	}
	
	public void closeEm() {
		em.close();
		emf.close();
	}

}
