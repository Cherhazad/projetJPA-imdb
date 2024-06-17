package Application.Utils;

import Application.DAO.LangueDAO;
import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;

/**
 * Classe abstraite permettant de faire le lien avec les dao évitant
 * d'instancier à nouveau les DAOs et permettant d'accéder aux méthodes de ces
 * DAO.
 * 
 */
public abstract class DaoLien {

	public static PaysDAO paysDao() {
		return new PaysDAO();
	}

	public static LangueDAO langueDao() {
		return new LangueDAO();
	}

	public static LieuDAO lieuDao() {
		return new LieuDAO();
	}

}
