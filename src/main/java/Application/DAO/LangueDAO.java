package Application.DAO;

import java.util.List;

import Application.Entites.Film;
import Application.Entites.Langue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class LangueDAO implements GenericDAO<Langue> {

	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	public boolean findByName(String nom) {
		
		TypedQuery<Langue> query = em.createQuery("SELECT l.nom FROM Langue l WHERE l.nom = :nom", Langue.class);
		query.setParameter("nom", nom);
		return !query.getResultList().isEmpty(); 
	}

	@Override
	public List<Langue> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Langue langue) {

		
			try {
				transaction.begin();
				em.persist(langue);
				transaction.commit();

			} catch (RuntimeException e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw e;
			}
//			em.close();
		}
	

	@Override
	public void update(int id, Langue nvObjet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}


}
