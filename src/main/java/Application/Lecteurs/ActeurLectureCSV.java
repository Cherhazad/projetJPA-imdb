package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import Application.DAO.ActeurDAO;
import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Acteur;
import Application.Entites.Lieu;
import Application.Utils.DaoLien;

public class ActeurLectureCSV {

	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();
	public static final ActeurDAO acteurDAO = DaoLien.acteurDao();
//	private static EntityTransaction transaction = DaoLien.transaction;

	public static Set<Acteur> lireFichier() {

		Set<Acteur> setActeurs = new HashSet<>();
		Set<Lieu> setLieux = new HashSet<>();

//		Set<ActeurLieu> acteurLieuSets = new HashSet<>();

		Path path = Paths.get("src/main/resources/acteurs.csv");

		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);

//			transaction.begin();
			for (String ligne : lignes) {

				String[] elementsActeurs = ligne.split(";");
				List<String> elementsActeurs2 = new ArrayList<>(Arrays.asList(ligne.split(";")));
				Acteur a = new Acteur();

				a.setId(elementsActeurs[0]);
				a.setIdentite(elementsActeurs[1]);

				// ajout date de Naissance
				LocalDate date = parseDate(elementsActeurs[2]);
				a.setDateNaissance(date);

				// association lieu

				String elementsLieux = elementsActeurs[3];
				Lieu l = LieuLectureCSV.splitLieux(elementsLieux);

//				if (l == null) {
//					continue;
//				} else {					
//					setLieux.add(l);
//					a.setLieuNaissance(l);
//				}

				if (l != null) {
//					lieuDAO.insert(l);
					setLieux.add(l);
					a.setLieuNaissance(l);
				}

				// association taille

				String tailleString = elementsActeurs[4].replace(",", ".").split(" ")[0];
				elementsActeurs2.forEach((akjh)->System.out.println(akjh));
				
				if (!tailleString.isEmpty()) {
					System.out.println(Arrays.toString(tailleString.split(" ")));
					Double taille = Double.parseDouble(tailleString.split(" ")[0]);
					a.setTaille(taille);
				} 
				
				a.setUrl(elementsActeurs[5]);

				// Mise à jour du Set d'Acteur s'il n'existe pas en base
				if (!acteurDAO.ifActeurExists(a)) {
				setActeurs.add(a);
//				acteurDAO.insert(a);
				}

				// Ajout des acteurs et lieux dans acteurLieuSets
//                acteurLieuSets.add(new ActeurLieu(a));
//                acteurLieuSets.add(new ActeurLieu(l));

			}
//			transaction.commit();

		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return setActeurs;

	}

	private static LocalDate parseDate(String dateString) {
		if (dateString == null || dateString.trim().isEmpty()) {
			return null; // Gestion des cas où la date est vide
		}

		try {
			String[] elementsDate = dateString.split(" ");
			DateTimeFormatter formatter;

			switch (elementsDate.length) {
			case 1:
				// Parsing pour une année seule "yyyy"
				formatter = DateTimeFormatter.ofPattern("yyyy");
				return Year.parse(dateString, formatter).atDay(1); // Attribue le 1er janvier de l'année

			case 2:
				// Parsing pour le format "MMMM/yyyy"
				formatter = DateTimeFormatter.ofPattern("MMMM/yyyy", Locale.ENGLISH);
				return YearMonth.parse(dateString, formatter).atDay(1); // Attribue le 1er jour du mois

			case 3:
				// Parsing pour le format complet "MMMM d yyyy"
				formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMMM d yyyy")
						.toFormatter(Locale.ENGLISH);
				return LocalDate.parse(dateString, formatter);

			default:
				throw new DateTimeParseException("Unsupported date format", dateString, 0);
			}
		} catch (DateTimeParseException e) {
			System.err.println("Error parsing date: " + dateString + ". Error: " + e.getMessage());
			return null;
		}
	}

}
