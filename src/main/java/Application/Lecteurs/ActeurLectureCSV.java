package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.DAO.ActeurDAO;
import Application.DAO.DaoLien;
import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Acteur;
import Application.Entites.Lieu;
import Application.Utils.DateUtils;

public class ActeurLectureCSV {

	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();
	public static final ActeurDAO acteurDAO = DaoLien.acteurDao();
//	private static EntityTransaction transaction = DaoLien.transaction;

	public static Set<Acteur> lireFichier() {

		Set<Acteur> setActeurs = new HashSet<>();
		Set<Lieu> setLieux = new HashSet<>();

		Path path = Paths.get("src/main/resources/acteurs.csv");

		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);

			for (String ligne : lignes) {

				String[] elementsActeurs = ligne.split(";");
				List<String> elementsActeurs2 = new ArrayList<>(Arrays.asList(ligne.split(";")));
				Acteur a = new Acteur();

				a.setId(elementsActeurs[0]);
				a.setIdentite(elementsActeurs[1]);

				// ajout date de Naissance
				LocalDate date = DateUtils.parseDate(elementsActeurs[2]);
				a.setDateNaissance(date);

				// association lieu

				String elementsLieux = elementsActeurs[3];
				Lieu l = LieuLectureCSV.splitLieux(elementsLieux);

				if (l != null) {
					setLieux.add(l);
					a.setLieuNaissance(l);
				}

				// association taille

				String tailleString = elementsActeurs[4].replace(",", ".").split(" ")[0];
				elementsActeurs2.forEach((akjh) -> System.out.println(akjh));

				if (!tailleString.isEmpty()) {
					Double taille = Double.parseDouble(tailleString.split(" ")[0]);
					a.setTaille(taille);
				}

				a.setUrl(elementsActeurs[5]);

				// Mise à jour du Set d'Acteur s'il n'existe pas en base
				if (!acteurDAO.ifActeurExists(a)) {
					setActeurs.add(a);
				}

			}

		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return setActeurs;

	}

}
