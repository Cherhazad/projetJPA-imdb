package Application.Utils;

import java.util.Set;

import Application.DAO.PaysDAO;
import Application.Entites.Pays;
import Application.Lecteurs.PaysLectureCSV;

public class TraitementDonnees {

	public static void main(String[] args) {

		// Insertion données pays en bd
		
		Set<Pays> listePays = PaysLectureCSV.lireFichier();
		PaysDAO paysDAO = new PaysDAO();

		for (Pays p : listePays) {
			paysDAO.insert(p);
		}
		System.out.println("-----------------------------------------");
		System.out.println("Fin insertion des pays en base de données");



	}
}
