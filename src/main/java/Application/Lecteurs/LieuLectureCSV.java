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

public class LieuLectureCSV {

	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();

	public static Set<Lieu> lireFichier() {

		Set<Lieu> setLieux = new HashSet<>();

		Path pathActeurs = Paths.get("src/main/resources/acteurs.csv");
		Path pathRealisateurs = Paths.get("src/main/resources/realisateurs.csv");
		Path pathFilms = Paths.get("src/main/resources/films.csv");

		try {
			// Acteurs
			
			List<String> lignesActeurs = Files.readAllLines(pathActeurs);
			lignesActeurs.remove(0);
			
			List<String> limitedLignes = lignesActeurs.stream().limit(30).collect(Collectors.toList());
			for (String ligne : limitedLignes) {

				Lieu l = splitLieux(ligne);
				boolean isValidLieu = (l.getPays() != null) || (l.getVille() != null && !l.getVille().isEmpty())
						|| (l.getEtat() != null && !l.getEtat().isEmpty())
						|| (l.getQuartier() != null && !l.getQuartier().isEmpty());

				if (isValidLieu && !lieuDAO.ifLieuExists(l)) {
					lieuDAO.insert(l);
					setLieux.add(l);
				}
			}

			// realisateurs

			List<String> lignesRealisateurs = Files.readAllLines(pathRealisateurs);
			lignesRealisateurs.remove(0);
			
			List<String> limitedLignes2 = lignesRealisateurs.stream().limit(30).collect(Collectors.toList());
			
			for (String ligne : limitedLignes2) {
				Lieu l = splitLieux(ligne);
				boolean isValidLieu = (l.getPays() != null) || (l.getVille() != null && !l.getVille().isEmpty())
						|| (l.getEtat() != null && !l.getEtat().isEmpty())
						|| (l.getQuartier() != null && !l.getQuartier().isEmpty());

				if (isValidLieu && !lieuDAO.ifLieuExists(l)) {
					lieuDAO.insert(l);
					setLieux.add(l);
				}

			}

			// Films

			List<String> lignesFilms = Files.readAllLines(pathFilms);
			lignesFilms.remove(0);
			
			List<String> limitedLignes3 = lignesFilms.stream().limit(30).collect(Collectors.toList());
			for (String ligne : limitedLignes3) {
				Lieu l = splitLieuxFilms(ligne);

				boolean isValidLieu = (l.getPays() != null) || (l.getVille() != null && !l.getVille().isEmpty())
						|| (l.getEtat() != null && !l.getEtat().isEmpty())
						|| (l.getQuartier() != null && !l.getQuartier().isEmpty());

				if (isValidLieu && !lieuDAO.ifLieuExists(l)) {
					lieuDAO.insert(l);
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
		String[] elements = ligne.split(";");
		Lieu l = new Lieu();

		String[] elementsLieu = elements[5].split(",");

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
		String[] elements = ligne.split(";");
		Lieu l = new Lieu();

		String[] elementsLieu = elements[3].split(",");

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
