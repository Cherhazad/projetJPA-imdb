package Application.DAO;

import java.util.HashSet;
import java.util.Set;

import Application.Entites.Lieu;
import Application.Utils.DaoLien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

/**
 * 
 */
public class LieuDAO implements GenericDAO<Lieu> {

	Set<Lieu> setLieux = new HashSet<>();
	public static final PaysDAO paysDAO = DaoLien.paysDao();
	private EntityManager em = DaoLien.em;
	private EntityTransaction transaction = DaoLien.transaction;

	/**
	 * Constructeur
	 * 
	 * @param listeLieux
	 */
	public LieuDAO(EntityManager em) {
		this.setLieux = findAll();
		this.em = em;
	}

	/**
	 * Méthode qui extrait et retourne une liste des éléments contenus en base de
	 * données dans la table Lieu
	 * 
	 * @return
	 */
	public Set<Lieu> findAll() {
		TypedQuery<Lieu> query = em.createQuery("select l from Lieu l JOIN FETCH l.pays", Lieu.class);
		setLieux = new HashSet<>(query.getResultList());

		return setLieux;
	}

	/**
	 * @param nom
	 * @return
	 */
	public Lieu findLieu(String quartier, String ville, String etat) {
		return setLieux.stream().filter(l -> l.getQuartier().equalsIgnoreCase(quartier)
				&& l.getVille().equalsIgnoreCase(ville) && l.getEtat().equalsIgnoreCase(etat)).findFirst().orElse(null);
	}

	/**
	 * @param lieu
	 * @return
	 */
	public boolean ifLieuExists(Lieu lieu) {
		return setLieux.stream()
				.anyMatch(l -> l.getVille() != null && l.getVille().equalsIgnoreCase(lieu.getVille())
						&& l.getEtat() != null && l.getEtat().equalsIgnoreCase(lieu.getEtat())
						&& l.getQuartier() != null && l.getQuartier().equalsIgnoreCase(lieu.getQuartier())
						&& l.getPays() != null && l.getPays().equals(lieu.getPays()));
	}

	/**
	 *
	 */
	@Override
	public void insert(Lieu lieu) {

		if (!ifLieuExists(lieu)) {
			try {

				em.persist(lieu);
				setLieux.add(lieu);

			} catch (RuntimeException e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				throw e;
			}
		}
		// em.close();
	}

}
