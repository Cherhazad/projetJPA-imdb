package Application.DAO;

import java.util.List;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public interface GenericDAO<T> {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("appMovie");
	
	/**
	 * @return
	 */
	List<T> extraire();
	void insert(T nvObjet);
	void update(int id, T nvObjet);
	void delete(int id);

}
