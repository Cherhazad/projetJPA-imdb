package Application.DAO;

import java.util.HashSet;
import java.util.Set;

import Application.Entites.Acteur;
import Application.Utils.JPAConnexion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ActeurDAO implements GenericDAO<Acteur> {

	Set<Acteur> setActeurs = new HashSet<>();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();
	public static final PaysDAO paysDAO = DaoLien.paysDao();

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public ActeurDAO(EntityManager em) {
		this.setActeurs = findAll();
	}

	public Acteur findById(String id) {
		return setActeurs.stream().filter(acteur -> acteur.getId().equals(id)).findFirst().orElse(null);
	}

	public Set<Acteur> findAll() {
		TypedQuery<Acteur> query = JPAConnexion.getEntityManager()
				.createQuery("select a from Acteur a JOIN FETCH a.lieuNaissance l JOIN FETCH l.pays p", Acteur.class);
		setActeurs = new HashSet<>(query.getResultList());
		return setActeurs;
	}

	public boolean ifActeurExists(Acteur acteur) {
		return setActeurs.stream().anyMatch(a -> a.getId().equals(acteur.getId()));
	}

	@Override
	public void insert(Acteur acteur) {

		if (!ifActeurExists(acteur)) {
			JPAConnexion.persist(acteur);
			setActeurs.add(acteur);
		}
	}
}
