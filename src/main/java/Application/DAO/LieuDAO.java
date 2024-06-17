package Application.DAO;

import java.util.ArrayList;
import java.util.List;

import Application.Entites.Lieu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * 
 */
public class LieuDAO implements GenericDAO<Lieu> {

	List<Lieu> listeLieux = new ArrayList<>();

	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	/**
	 * Constructeur
	 * 
	 * @param listeLieux
	 */
	public LieuDAO() {
		this.listeLieux = findAll();
	}

	// requête dans la database
	public List<Lieu> findAll() {
		return em.createQuery("select l from Lieu l", Lieu.class).getResultList();
	}
	
	// vérif si existence
	

	@Override
	public void insert(Lieu lieu) {

		try {
			transaction.begin();
			em.persist(lieu);
			listeLieux.add(lieu);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw e;
		}
		em.close();
	}

}
