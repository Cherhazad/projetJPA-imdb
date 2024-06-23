package Application.Utils;

import java.util.Set;

import Application.DAO.ActeurDAO;
import Application.DAO.LangueDAO;
import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Acteur;
import Application.Entites.Lieu;
import Application.Entites.Pays;
import Application.Lecteurs.ActeurLectureCSV;
import Application.Lecteurs.PaysLectureCSV;
import jakarta.persistence.EntityTransaction;

public class TraitementDonnees {

	public static final ActeurDAO acteurDAO = DaoLien.acteurDao();
	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LangueDAO langueDAO = DaoLien.langueDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();
	
	private static EntityTransaction transaction = DaoLien.transaction;

	public static void main(String[] args) {

		
		
		// Insertion des pays en base

		Set<Pays> setPays = PaysLectureCSV.lireFichier();
		transaction.begin();
		for (Pays p : setPays) {
			paysDAO.insert(p);
		}


		ActeurLieuSets acteurLieuSets = ActeurLectureCSV.lireFichier();
		

		// Insertion des acteurs en base
		Set<Acteur> setActeurs = acteurLieuSets.getActeurs();
		for (Acteur a : setActeurs) {
		    acteurDAO.insert(a);
		}
	
		
		transaction.commit();
		
		
		
		// Insertion langues en base de données

//			Set<Langue> listeLangues = LangueLectureCSV.lireFichier();
//		
//			for (Langue langue : listeLangues) {
//				langueDAO.insert(langue);
//			}

		// Insertion

	}

}
