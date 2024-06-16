package Application.Utils;

import java.util.Set;

import Application.DAO.LangueDAO;
import Application.Entites.Langue;
import Application.Lecteurs.LangueLectureCSV;

public class TraitementDonnees {

	public static void main(String[] args) {

		// TODO mettre les conditions d'existence en base de données

//		// Insertion données pays en bd
//		
//		Set<Pays> listePays = PaysLectureCSV.lireFichier();
//		PaysDAO paysDAO = new PaysDAO();
//
//		for (Pays p : listePays) {
//			paysDAO.insert(p);
//		}
//		System.out.println("-----------------------------------------");
//		System.out.println("Fin insertion des pays en base de données");

		// Insertion lieux en bd
//		Set<Lieu> listeLieux = LieuLectureCSV.lireFichier();
//		
//		LieuDAO lieuDAO = new LieuDAO();
//
//		for (Lieu l : listeLieux) {
//			lieuDAO.insert(l);
//		}
//		System.out.println("-----------------------------------------");
//		System.out.println("Fin insertion des pays en base de données");

		// Insertion langues en base de données

		Set<Langue> listeLangues = LangueLectureCSV.lireFichier();

		LangueDAO langueDAO = new LangueDAO();

		for (Langue langue : listeLangues) {

			if (!langueDAO.findByName(langue.getNom())) {

				langueDAO.insert(langue);
			}
		}
		System.out.println("-----------------------------------------");
		System.out.println("Fin insertion des pays en base de données");
	}
}
