package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.Entites.Lieu;

public class LieuLectureCSV {

	public static Set<Lieu> lireFichierActeur() {

		Set<Lieu> listeLieuActeurs = new HashSet<>();

		Path path = Paths.get("src/main/resources/acteurs.csv");

		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);

			for (String ligne : lignes) {
				Lieu l = new Lieu();
				String[] elements = ligne.split(";");

				l.setId(elements[0]);

				String[] elementsLieu = elements[3].split(",");

				l.setRue(elementsLieu[0]);
				l.setVille(elementsLieu[1]);
				l.setEtat(elementsLieu[2]);
				l.setPays(elementsLieu[3]);
				
				//TODO gérer les lieux à 2, 3 ou 4 élements avec des conditions

				listeLieuActeurs.add(l);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeLieuActeurs;

	}

	public static Set<Lieu> lireFichierFilm() {

		Set<Lieu> listeLieuFilms = new HashSet<>();

		Path path = Paths.get("src/main/resources/films.csv");

		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);

			for (String ligne : lignes) {
				Lieu l = new Lieu();
				String[] elements = ligne.split(";");

				l.setId(elements[0]);

				String[] elementsLieu = elements[5].split(",");

				l.setRue(elementsLieu[0]);
				l.setVille(elementsLieu[1]);
				l.setEtat(elementsLieu[2]);
				l.setPays(elementsLieu[3]);

				listeLieuFilms.add(l);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeLieuFilms;

	}
	
	
	public static Set<Lieu> lireFichierRealisateur() {

		Set<Lieu> listeLieuRealisateurs = new HashSet<>();

		Path path = Paths.get("src/main/resources/realisateurs.csv");

		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);

			for (String ligne : lignes) {
				Lieu l = new Lieu();
				String[] elements = ligne.split(";");

				l.setId(elements[0]);

				String[] elementsLieu = elements[3].split(",");

				l.setRue(elementsLieu[0]);
				l.setVille(elementsLieu[1]);
				l.setEtat(elementsLieu[2]);
				l.setPays(elementsLieu[3]);

				listeLieuRealisateurs.add(l);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeLieuRealisateurs;

	}

}
