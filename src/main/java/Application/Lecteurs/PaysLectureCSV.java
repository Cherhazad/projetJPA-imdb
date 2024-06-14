package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.Entites.Pays;


public class PaysLectureCSV {

	public static Set<Pays> lireFichier() {
		
		Set<Pays> listePays = new HashSet<>();

		Path path = Paths.get("src/main/resources/pays.csv");
		
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
