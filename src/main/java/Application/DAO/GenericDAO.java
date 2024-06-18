package Application.DAO;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public interface GenericDAO<T> {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("appMovie");
	
	/**
	 * @return
	 */

	void insert(T nvObjet);

}
