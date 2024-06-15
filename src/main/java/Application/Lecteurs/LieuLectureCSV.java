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

	public static Set<Lieu> lireFichier() {

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


				switch (elementsLieu.length) {

				case 1:
					l.setPays(elementsLieu[0]);
					break;

				case 2:
					l.setVille(elementsLieu[0]);
					l.setPays(elementsLieu[1]);
					break;

				case 3:
					l.setVille(elementsLieu[0]);
					l.setEtat(elementsLieu[1]);
					l.setPays(elementsLieu[2]);
					break;
				case 4:
					l.setQuartier(elementsLieu[0]);
					l.setVille(elementsLieu[1]);
					l.setEtat(elementsLieu[2]);
					l.setPays(elementsLieu[3]);
					break;
				default:
					break;
				}

				listeLieuActeurs.add(l);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeLieuActeurs;

	}

}
