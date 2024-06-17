package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Application.Entites.Lieu;

public class LieuLectureCSV {

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
				Lieu l = new Lieu();
				String[] elements = ligne.split(";");

				String[] elementsLieu = elements[3].split(",");

				switch (elementsLieu.length) {

				case 1:
					l.setPays(elementsLieu[0].trim());
					break;

				case 2:
					l.setVille(elementsLieu[0].trim());
					l.setPays(elementsLieu[1].trim());
					break;

				case 3:
					l.setVille(elementsLieu[0].trim());
					l.setEtat(elementsLieu[1].trim());
					l.setPays(elementsLieu[2].trim());
					break;
				case 4:
					l.setQuartier(elementsLieu[0].trim());
					l.setVille(elementsLieu[1].trim());
					l.setEtat(elementsLieu[2].trim());
					l.setPays(elementsLieu[3].trim());
					break;
				default:
					break;
				}
				
				if(!(elementsLieu == null)) {					
					listeLieux.add(l);
				}
			}

			// realisateurs

			List<String> lignesRealisateurs = Files.readAllLines(pathRealisateurs);
			lignesRealisateurs.remove(0);

			for (String ligne : lignesRealisateurs) {
				Lieu l = new Lieu();
				String[] elements = ligne.split(";");

				String[] elementsLieu = elements[3].split(",");

				switch (elementsLieu.length) {

				case 1:
					l.setPays(elementsLieu[0].trim());
					break;

				case 2:
					l.setVille(elementsLieu[0].trim());
					l.setPays(elementsLieu[1].trim());
					break;

				case 3:
					l.setVille(elementsLieu[0].trim());
					l.setEtat(elementsLieu[1].trim());
					l.setPays(elementsLieu[2].trim());
					break;
				case 4:
					l.setQuartier(elementsLieu[0].trim());
					l.setVille(elementsLieu[1].trim());
					l.setEtat(elementsLieu[2].trim());
					l.setPays(elementsLieu[3].trim());
					break;
				default:
					break;
				}
				
					listeLieux.add(l);
				
			}

			// Films

			List<String> lignesFilms = Files.readAllLines(pathFilms);
			lignesFilms.remove(0);

			for (String ligne : lignesFilms) {
				Lieu l = new Lieu();
				String[] elements = ligne.split(";");

				String[] elementsLieu = elements[5].split(",");

				switch (elementsLieu.length) {

				case 1:
					l.setPays(elementsLieu[0].trim());
					break;

				case 2:
					l.setVille(elementsLieu[1].trim());
					l.setPays(elementsLieu[0].trim());
					break;

				case 3:
					l.setVille(elementsLieu[2].trim());
					l.setEtat(elementsLieu[1].trim());
					l.setPays(elementsLieu[0].trim());
					break;
				case 4:
					l.setQuartier(elementsLieu[3].trim());
					l.setVille(elementsLieu[2].trim());
					l.setEtat(elementsLieu[1].trim());
					l.setPays(elementsLieu[0].trim());
					break;
				default:
					break;
				}

				listeLieux.add(l);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeLieux;

	}

}
