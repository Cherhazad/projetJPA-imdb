package Application.Lecteurs;

import static Application.Lecteurs.LieuLectureCSV.verifPays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import Application.DAO.ActeurDAO;
import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Acteur;
import Application.Entites.Lieu;
import Application.Entites.Pays;
import Application.Utils.DaoLien;

public class ActeurLectureCSV {

	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();
	public static final ActeurDAO acteurDAO = DaoLien.acteurDao();

	public static Set<Acteur> lireFichier() {

		Set<Acteur> SetActeurs = new HashSet<>();

		Path path = Paths.get("src/main/resources/acteurs.csv");

		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);

			// pour faire des tests en base sans tout charger
			List<String> limitedLignes = lignes.stream().limit(30).collect(Collectors.toList());

			for (String ligne : limitedLignes) {

				String[] elements = ligne.split(";");
				Acteur a = new Acteur();

				a.setId(elements[0]);
				a.setIdentite(elements[1]);

				// ajout date de Naissance
				LocalDate date = parseDate(elements[2]);
				a.setDateNaissance(date);

				// association lieu
				splitLieuActeurs(elements);

//				a.setLieuNaissance(lieuNaissance);

				String tailleString = elements[4].replace(" m", "").trim();
				if (!tailleString.isEmpty()) {
					Double taille = Double.parseDouble(tailleString);
					a.setTaille(taille);
				}

				a.setUrl(elements[5]);

				SetActeurs.add(a);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SetActeurs;

	}

	private static void splitLieuActeurs(String[] elements) {
		String[] lieuComplet = elements[3].split(",");
		Lieu l = null;
		if (lieuComplet == null) {
			System.out.println("ce lieu n'existe pas");
		} else {
			l = new Lieu();
			
			switch (lieuComplet.length) {

			case 1:
				l.setPays(verifPays(lieuComplet[0].trim()));
				break;

			case 2:
				l.setVille(lieuComplet[0].trim());
				l.setPays(verifPays(lieuComplet[1].trim()));
				break;

			case 3:
				l.setVille(lieuComplet[0].trim());
				l.setEtat(lieuComplet[1].trim());
				l.setPays(verifPays(lieuComplet[2].trim()));
				break;
			case 4:
				l.setQuartier(lieuComplet[0].trim());
				l.setVille(lieuComplet[1].trim());
				l.setEtat(lieuComplet[2].trim());
				l.setPays(verifPays(lieuComplet[3].trim()));
				break;
			default:
				break;
			}
		}
	}

	private static LocalDate parseDate(String dateString) {
		String[] elementsDate = dateString.split(" ");
		DateTimeFormatter formatter;

		try {
			switch (elementsDate.length) {
			case 1:
				formatter = DateTimeFormatter.ofPattern("yyyy");
				return LocalDate.parse(dateString, formatter);
			case 2:
				formatter = DateTimeFormatter.ofPattern("MMMM/yyyy");
				return LocalDate.parse(dateString, formatter);
			case 3:
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
