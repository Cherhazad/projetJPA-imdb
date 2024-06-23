package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Lieu;
import Application.Entites.Pays;
import Application.Utils.DaoLien;

/** 
 * 
 */

//TODO méthode lireFichierRealisateurs et lireFichierFilms à spliter
public abstract class LieuLectureCSV {

	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();
	static Path pathActeurs = Paths.get("src/main/resources/acteurs.csv");
	static Path pathRealisateurs = Paths.get("src/main/resources/realisateurs.csv");
	static Path pathFilms = Paths.get("src/main/resources/films.csv");

	static Set<Lieu> setLieux = new HashSet<>();


	public static Set<Lieu> lireFichierRealisateurs() {

		try {
			List<String> lignesRealisateurs = Files.readAllLines(pathRealisateurs);
			lignesRealisateurs.remove(0);

			List<String> limitedLignes2 = lignesRealisateurs.stream().limit(30).collect(Collectors.toList());

			for (String ligne : limitedLignes2) {
				String[] elements = ligne.split(";");
				Lieu l = splitLieux(elements[3]);
				if (!lieuDAO.ifLieuExists(l) && isValidLieu(l)) {
					setLieux.add(l);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return setLieux;

	}

	public static Set<Lieu> lireFichierFilms() {
		try {
			// Films

			List<String> lignesFilms = Files.readAllLines(pathFilms);
			lignesFilms.remove(0);

			List<String> limitedLignes3 = lignesFilms.stream().limit(30).collect(Collectors.toList());
			for (String ligne : limitedLignes3) {
				String[] elements = ligne.split(";");

				Lieu l = splitLieuxFilms(elements[5]);

				if (!lieuDAO.ifLieuExists(l) && isValidLieu(l)) {
					setLieux.add(l);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return setLieux;

	}

	public static Pays verifPays(String nomPays) {
		if (!nomPays.isEmpty()) {
			if (nomPays.equals("USA")) {
				nomPays = "United States";
			}
			if (nomPays.equals("UK")) {
				nomPays = "United Kingdom";
			}
			Pays pays = paysDAO.findByName(nomPays);
			if (pays == null) {
				pays = new Pays();
				pays.setNom(nomPays);
				paysDAO.insert(pays);
			}
			return pays;
		}
		return null;
	}

	public static boolean isValidLieu(Lieu lieu) {
		return (lieu.getPays() != null || (lieu.getVille() != null && !lieu.getVille().isEmpty())
				|| (lieu.getEtat() != null && !lieu.getEtat().isEmpty())
				|| (lieu.getQuartier() != null && !lieu.getQuartier().isEmpty()));
	}

	/**
	 * Méthode dynamique qui permet, en fonction du nombre d'éléments qui composent
	 * le lieu, d'attribuer le bon élément (quartier, ville, état ou pays) à la
	 * bonne colonne dans la table en base de données à partir des lieux du fichier
	 * films.csv
	 * 
	 * @param ligne
	 * @return
	 */
	public static Lieu splitLieuxFilms(String ligne) {

		Lieu l = new Lieu();
		String[] elementsLieu = ligne.split(",");

		switch (elementsLieu.length) {
		case 1:
			l.setPays(verifPays(elementsLieu[0].trim()));
			break;

		case 2:
			l.setVille(elementsLieu[1].trim());
			l.setPays(verifPays(elementsLieu[0].trim()));
			break;

		case 3:
			l.setVille(elementsLieu[2].trim());
			l.setEtat(elementsLieu[1].trim());
			l.setPays(verifPays(elementsLieu[0].trim()));
			break;
		case 4:
			l.setQuartier(elementsLieu[3].trim());
			l.setVille(elementsLieu[2].trim());
			l.setEtat(elementsLieu[1].trim());
			l.setPays(verifPays(elementsLieu[0].trim()));
			break;
		default:
			break;
		}
		return l;
	}

	/**
	 * Méthode dynamique qui permet, en fonction du nombre d'éléments qui composent
	 * le lieu, d'attribuer le bon élément (quartier, ville, état ou pays) à la
	 * bonne colonne dans la table en base de données à partir des lieux des
	 * fichiers realisateurs.csv et acteurs.csv
	 * 
	 * @param ligne
	 * @return
	 */
	public static Lieu splitLieux(String ligne) {
		Lieu l = new Lieu();

		String[] elementsLieu = ligne.split(",");

		switch (elementsLieu.length) {

		case 1:
			l.setPays(verifPays(elementsLieu[0].trim()));
			break;

		case 2:
			l.setVille(elementsLieu[0].trim());
			l.setPays(verifPays(elementsLieu[1].trim()));
			break;

		case 3:
			l.setVille(elementsLieu[0].trim());
			l.setEtat(elementsLieu[1].trim());
			l.setPays(verifPays(elementsLieu[2].trim()));
			break;
		case 4:
			l.setQuartier(elementsLieu[0].trim());
			l.setVille(elementsLieu[1].trim());
			l.setEtat(elementsLieu[2].trim());
			l.setPays(verifPays(elementsLieu[3].trim()));
			break;
		default:
			break;
		}
		return l;
	}
}
