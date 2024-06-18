package Application.DAO;

import java.util.HashSet;
import java.util.Set;

import Application.Entites.Acteur;
import Application.Entites.Lieu;
import Application.Utils.DaoLien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ActeurDAO implements GenericDAO<Acteur> {

	Set<Acteur> setActeurs = new HashSet<>();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();	
	public static final PaysDAO paysDAO = DaoLien.paysDao();
	private EntityManager em = DaoLien.em;
	private EntityTransaction transaction = DaoLien.transaction;
	
	
	
	
	/** Constructeur
	 * @param em
	 */
	public ActeurDAO(EntityManager em) {
		this.setActeurs = findAll();
		this.em = em;
	}


	/**
	 * @param id
	 * @return
	 */
	public Acteur findById(String id) {
		return setActeurs.stream().filter(acteur -> acteur.getId().equals(id)).findFirst().orElse(null);
	}
	
	/**
	 * @return
	 */
	public Set<Acteur> findAll() {
		TypedQuery<Acteur> query = em.createQuery("select a from Acteur a JOIN FETCH a.lieuNaissance l JOIN FETCH l.pays p", Acteur.class);
		setActeurs = new HashSet<>(query.getResultList());
		
		return setActeurs;
	}
	


	public boolean ifActeurExists(Acteur acteur) {
		return setActeurs.stream().anyMatch(a -> a.getId().equals(acteur.getId()));
	}
	
	@Override
	public void insert(Acteur acteur) {
		
		if (!ifActeurExists(acteur)) {
			try {
				transaction.begin();
				em.persist(acteur);
				setActeurs.add(acteur);
				transaction.commit();

			} catch (RuntimeException e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw e;
			}
		}
		
	}

}
