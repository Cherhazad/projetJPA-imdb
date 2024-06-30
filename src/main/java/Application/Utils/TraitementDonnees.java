package Application.Utils;

import java.util.Set;

import Application.DAO.ActeurDAO;
import Application.DAO.DaoLien;
import Application.DAO.LangueDAO;
import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Acteur;
import Application.Entites.Pays;
import Application.Lecteurs.ActeurLectureCSV;
import Application.Lecteurs.PaysLectureCSV;

public class TraitementDonnees {

	public static final ActeurDAO acteurDAO = DaoLien.acteurDao();
	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LangueDAO langueDAO = DaoLien.langueDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();


	public static void main(String[] args) {

		// Insertion des pays en base


		Set<Pays> setPays = PaysLectureCSV.lireFichier();
		for (Pays p : setPays) {
			paysDAO.insert(p);
		}

		// Insertion des acteurs en base
		Set<Acteur> setActeurs = ActeurLectureCSV.lireFichier();
		for (Acteur a : setActeurs) {
			acteurDAO.insert(a);
		}


		// Insertion langues en base de données

//			Set<Langue> listeLangues = LangueLectureCSV.lireFichier();
//		
//			for (Langue langue : listeLangues) {
//				langueDAO.insert(langue);
//			}

		// Insertion

	}
}
