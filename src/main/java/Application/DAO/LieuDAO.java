package Application.DAO;

import java.util.ArrayList;
import java.util.List;

import Application.Entites.Lieu;
import Application.Entites.Pays;
import Application.Utils.DaoLien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

/**
 * 
 */
public class LieuDAO implements GenericDAO<Lieu> {

	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	List<Lieu> listeLieux = new ArrayList<>();
	public static final PaysDAO paysDAO = DaoLien.paysDao();

	/**
	 * Constructeur
	 * 
	 * @param listeLieux
	 */
	public LieuDAO() {
		this.listeLieux = findAll();
	}

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public LieuDAO(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode qui extrait et retourne une liste des éléments contenus en base de
	 * données dans la table Lieu
	 * 
	 * @return
	 */
	public List<Lieu> findAll() {
		TypedQuery<Lieu> query = em.createQuery("select l from Lieu l JOIN FETCH l.pays", Lieu.class);
		listeLieux = query.getResultList();

		return listeLieux;
	}

	public boolean ifLieuExists(Lieu lieu) {
		return listeLieux.stream()
				.anyMatch(l -> l.getVille() != null && l.getVille().equals(lieu.getVille()) && l.getEtat() != null
						&& l.getEtat().equals(lieu.getEtat()) && l.getQuartier() != null
						&& l.getQuartier().equals(lieu.getQuartier()) && l.getPays() != null
						&& l.getPays().equals(lieu.getPays()));
	}

	@Override
	public void insert(Lieu lieu) {

		Pays pays = lieu.getPays();
		if (!paysDAO.ifPaysExists(lieu.getPays().getNom())) {
			lieu.setPays(pays);
		}

		if (!ifLieuExists(lieu)) {
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
		}
		// em.close();
	}

}
