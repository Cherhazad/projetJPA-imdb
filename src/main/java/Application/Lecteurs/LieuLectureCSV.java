package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Lieu;
import Application.Entites.Pays;
import Application.Utils.DaoLien;

public class LieuLectureCSV {

	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();

	public static Set<Lieu> lireFichier() {

		Set<Lieu> listeLieux = new HashSet<>();

		Path pathActeurs = Paths.get("src/main/resources/acteurs.csv");
		Path pathRealisateurs = Paths.get("src/main/resources/realisateurs.csv");
		Path pathFilms = Paths.get("src/main/resources/films.csv");

		try {
			List<String> lignesActeurs = Files.readAllLines(pathActeurs);
			lignesActeurs.remove(0);

			// Acteurs

			for (String ligne : lignesActeurs) {

				Lieu l = splitPays(ligne);
				boolean isValidLieu = (l.getPays() != null) || (l.getVille() != null && !l.getVille().isEmpty())
						|| (l.getEtat() != null && !l.getEtat().isEmpty())
						|| (l.getQuartier() != null && !l.getQuartier().isEmpty());

				if (isValidLieu
						&& !lieuDAO.ifLieuExists(l)) {
					lieuDAO.insert(l);
					listeLieux.add(l);
				}
			}

			// realisateurs

			List<String> lignesRealisateurs = Files.readAllLines(pathRealisateurs);
			lignesRealisateurs.remove(0);

			for (String ligne : lignesActeurs) {
				Lieu l = splitPays(ligne);
				boolean isValidLieu = (l.getPays() != null) || (l.getVille() != null && !l.getVille().isEmpty())
						|| (l.getEtat() != null && !l.getEtat().isEmpty())
						|| (l.getQuartier() != null && !l.getQuartier().isEmpty());

				if (isValidLieu
						&& !lieuDAO.ifLieuExists(l)) {
					lieuDAO.insert(l);
					listeLieux.add(l);
				}

			}

			// Films

			List<String> lignesFilms = Files.readAllLines(pathFilms);
			lignesFilms.remove(0);

			for (String ligne : lignesFilms) {
				Lieu l = splitPaysFilms(ligne);

				boolean isValidLieu = (l.getPays() != null) || (l.getVille() != null && !l.getVille().isEmpty())
						|| (l.getEtat() != null && !l.getEtat().isEmpty())
						|| (l.getQuartier() != null && !l.getQuartier().isEmpty());

				if (isValidLieu
						&& !lieuDAO.ifLieuExists(l)) {
					lieuDAO.insert(l);
					listeLieux.add(l);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeLieux;

	}

	private static Lieu splitPaysFilms(String ligne) {
		String[] elements = ligne.split(";");
		Lieu l = new Lieu();

		String[] elementsLieu = elements[5].split(",");

		switch (elementsLieu.length) {

		case 1:
			l.setPays(new Pays(elementsLieu[0].trim(), null));
			break;

		case 2:
			l.setVille(elementsLieu[1].trim());
			l.setPays(new Pays(elementsLieu[0].trim(), null));
			break;

		case 3:
			l.setVille(elementsLieu[2].trim());
			l.setEtat(elementsLieu[1].trim());
			l.setPays(new Pays(elementsLieu[0].trim(), null));
			break;
		case 4:
			l.setQuartier(elementsLieu[3].trim());
			l.setVille(elementsLieu[2].trim());
			l.setEtat(elementsLieu[1].trim());
			l.setPays(new Pays(elementsLieu[0].trim(), null));
			break;
		default:
			break;
		}
		return l;
	}

	private static Lieu splitPays(String ligne) {
		String[] elements = ligne.split(";");
		Lieu l = new Lieu();

		String[] elementsLieu = elements[3].split(",");

		switch (elementsLieu.length) {

		case 1:
			l.setPays(new Pays(elementsLieu[0].trim(), null));
			break;

		case 2:
			l.setVille(elementsLieu[0].trim());
			l.setPays(new Pays(elementsLieu[1].trim(), null));
			break;

		case 3:
			l.setVille(elementsLieu[0].trim());
			l.setEtat(elementsLieu[1].trim());
			l.setPays(new Pays(elementsLieu[2].trim(), null));
			break;
		case 4:
			l.setQuartier(elementsLieu[0].trim());
			l.setVille(elementsLieu[1].trim());
			l.setEtat(elementsLieu[2].trim());
			l.setPays(new Pays(elementsLieu[3].trim(), null));
			break;
		default:
			break;
		}
		return l;
	}

}
