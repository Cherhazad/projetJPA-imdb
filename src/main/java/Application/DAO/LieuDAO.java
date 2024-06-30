package Application.DAO;

import java.util.HashSet;
import java.util.Set;

import Application.Entites.Lieu;
import Application.Entites.Pays;
import Application.Utils.JPAConnexion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * 
 */
public class LieuDAO implements GenericDAO<Lieu> {

	Set<Lieu> setLieux = new HashSet<>();
//	public static final PaysDAO paysDAO = DaoLien.paysDao();

	/**
	 * Constructeur
	 * 
	 * @param listeLieux
	 */
	public LieuDAO(EntityManager em) {
		this.setLieux = findAll();
	}

	/**
	 * Méthode qui extrait et retourne une liste des éléments contenus en base de
	 * données dans la table Lieu
	 * 
	 * @return
	 */
	public Set<Lieu> findAll() {
		TypedQuery<Lieu> query = JPAConnexion.getEntityManager().createQuery("select l from Lieu l JOIN FETCH l.pays",
				Lieu.class);
		setLieux = new HashSet<>(query.getResultList());

		return setLieux;
	}

	/**
	 * @param lieu
	 * @return
	 */
	public Lieu findLieu(String quartier, String ville, String etat, Pays pays) {
		return setLieux.stream()
				.filter(l -> (quartier == null ? l.getQuartier() == null : quartier.equalsIgnoreCase(l.getQuartier()))
						&& (ville == null ? l.getVille() == null : ville.equalsIgnoreCase(l.getVille()))
						&& (etat == null ? l.getEtat() == null : etat.equalsIgnoreCase(l.getEtat()))
						&& (pays == null ? l.getPays() == null : pays.equals(l.getPays())))
				.findFirst().orElse(null);
	}

	/**
	 *
	 */
	@Override
	public void insert(Lieu lieu) {

		if (findLieu(lieu.getQuartier(), lieu.getVille(), lieu.getEtat(), lieu.getPays()) == null && lieu != null) {
			JPAConnexion.persist(lieu);
			setLieux.add(lieu);
		}
	}

}
