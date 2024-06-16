package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.Entites.Langue;

public class LangueLectureCSV {

	public static Set<Langue> lireFichier() {

		Set<Langue> listeLangues = new HashSet<>();

		Path path = Paths.get("src/main/resources/films.csv");

		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);

			for (String ligne : lignes) {
				Langue langue = new Langue();
				String[] elements = ligne.split(";");
				String nomLangue = elements[7].trim();

				if (!nomLangue.isEmpty()) {
					langue.setNom(nomLangue);
					listeLangues.add(langue);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeLangues;

	}

}
