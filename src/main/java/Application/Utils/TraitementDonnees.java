package Application.Utils;

import java.util.Set;

import Application.DAO.LieuDAO;
import Application.Entites.Lieu;
import Application.Lecteurs.LieuLectureCSV;

public class TraitementDonnees {

	public static void main(String[] args) {

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
		Set<Lieu> listeLieux = LieuLectureCSV.lireFichier();
		
		LieuDAO lieuDAO = new LieuDAO();

		for (Lieu l : listeLieux) {
			lieuDAO.insert(l);
		}
		System.out.println("-----------------------------------------");
		System.out.println("Fin insertion des pays en base de données");


	}
}
