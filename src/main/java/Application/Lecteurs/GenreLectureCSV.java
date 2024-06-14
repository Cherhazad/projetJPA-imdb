package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.Entites.Genre;
import Application.Entites.Pays;


public class GenreLectureCSV {

	public static Set<Genre> lireFichier() {
		
		Set<Genre> listePays = new HashSet<>();

		// il faudra sûrement extraire les langues du fichier film ou de la table en base de données directement
		Path path = Paths.get("src/main/resources/genre.csv");
		
		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);
			
			for (String ligne : lignes) {
				Pays p = new Pays();
				String[] elements = ligne.split(";");
				
				p.setNom(elements[0]);
				p.setUrl(elements[1]);
			
				listePays.add(p);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listePays;
		
		
	}

}
