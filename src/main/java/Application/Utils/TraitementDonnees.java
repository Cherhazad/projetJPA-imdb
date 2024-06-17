package Application.Utils;

import java.util.Set;

import Application.DAO.LangueDAO;
import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Langue;
import Application.Entites.Lieu;
import Application.Entites.Pays;
import Application.Lecteurs.LangueLectureCSV;
import Application.Lecteurs.LieuLectureCSV;
import Application.Lecteurs.PaysLectureCSV;

public class TraitementDonnees {

	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LangueDAO langueDAO = DaoLien.langueDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();

	public static void main(String[] args) {

		// TODO mettre les conditions d'existence en base de données

		// Insertion données pays en bd

//		Set<Pays> listePays = PaysLectureCSV.lireFichier();
//
//		for (Pays p : listePays) {
//			paysDAO.insert(p);
//		}

		// Insertion lieux en bd
//		Set<Lieu> listeLieux = LieuLectureCSV.lireFichier();
//		
//		lieuDAO.insert(null);
//		for (Lieu l : listeLieux) {
//			lieuDAO.insert(l);
//		}

		// Insertion langues en base de données

		Set<Langue> listeLangues = LangueLectureCSV.lireFichier();

		for (Langue langue : listeLangues) {
			langueDAO.insert(langue);
		}
	}

	// Insertion

}
