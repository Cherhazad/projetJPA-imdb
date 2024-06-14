package Application.DAO;

import java.util.List;

public interface GenericDAO<T> {
	
	List<T> extraire();
	void insert(T nvObjet);
	void update(int id, T nvObjet);
	void delete(int id);

}
