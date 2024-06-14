package Application.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TODOConnexionApp {

	/** entityManager **/

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("appMovie");
	EntityManager em = emf.createEntityManager();

	/**
	 * Constructeur
	 * 
	 */
	public TODOConnexionApp() {
	}

	/**
	 * Constructeur
	 * 
	 * @param emf
	 * @param em
	 */
	public TODOConnexionApp(EntityManager em) {
		this.em = em;
	}

	public <T> T executeInTransaction(TODOTransactionOperation<T> operation) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			T result = operation.execute(em);
			transaction.commit();
			return result;
		} catch (RuntimeException e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
	}

}
