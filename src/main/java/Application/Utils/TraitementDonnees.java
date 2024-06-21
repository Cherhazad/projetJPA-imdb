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
import Application.Lecteurs.LieuLectureCSV;
import Application.Lecteurs.PaysLectureCSV;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TraitementDonnees {

	public static final ActeurDAO acteurDAO = DaoLien.acteurDao();
	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LangueDAO langueDAO = DaoLien.langueDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();
	
	private static EntityTransaction transaction = DaoLien.transaction;

	public static void main(String[] args) {

		
		
		// Insertion pays en bd

		Set<Pays> setPays = PaysLectureCSV.lireFichier();
		transaction.begin();
		for (Pays p : setPays) {
			paysDAO.insert(p);
		}

		// Insertion lieux en bd
		Set<Lieu> setLieux = LieuLectureCSV.lireFichier();

		for (Lieu l : setLieux) {
			lieuDAO.insert(l);
		}

		// Insertion Acteurs en base

//		Set<Acteur> setActeurs = ActeurLectureCSV.lireFichier();
//	
//		for (Acteur a : setActeurs) {
//			
//			Acteur acteur = a;
//			Lieu lieu = new Lieu();
//			 
//			Lieu l = lieuDAO.findLieu(a.getLieuNaissance().getQuartier(), a.getLieuNaissance().getVille(), a.getLieuNaissance().getEtat());
//			if (l == null) {
//				lieu.setQuartier(a.getLieuNaissance().getQuartier());
//				lieu.setVille(a.getLieuNaissance().getVille());
//				lieu.setEtat(a.getLieuNaissance().getEtat());
//				lieu.setPays(a.getLieuNaissance().getPays());
//				lieuDAO.insert(lieu);
//				acteur.setLieuNaissance(lieu);
//			}
//			
//			acteur.setDateNaissance(a.getDateNaissance());
//			acteur.setId(a.getId());
//			acteur.setLieuNaissance(l);
//			acteur.setTaille(a.getTaille());
//			acteur.setIdentite(a.getIdentite());
//			acteur.setUrl(a.getUrl());
//			
//			acteurDAO.insert(acteur);
////			System.out.println(a.getLieuNaissance().getQuartier() + " " + a.getLieuNaissance().getVille() + " " + a.getLieuNaissance().getEtat());
//		}
		
		
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
