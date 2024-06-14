package Application.Utils;

import java.util.Set;

import Application.DAO.PaysDAO;
import Application.Entites.Pays;
import Application.Lecteurs.PaysLectureCSV;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TraitementDonnees {

	public static void main(String[] args) {

		// Insertion données pays en bd

		Set<Pays> listePays = PaysLectureCSV.lireFichier();
		PaysDAO paysDAO = new PaysDAO();

		for (Pays p : listePays) {
			paysDAO.insert(p);
		}



	}
}
