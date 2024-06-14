package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.Entites.Acteur;
import Application.Entites.Lieu;
import Application.Entites.Pays;


public class ActeurLectureCSV {

	public static Set<Acteur> lireFichier() {
		
		Set<Acteur> listeActeurs = new HashSet<>();

		Path path = Paths.get("src/main/resources/acteurs.csv");
		
		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);
			
			for (String ligne : lignes) {
				
				Acteur a = new Acteur();
				String[] elements = ligne.split(";");
				
				a.setId(elements[0]);
				a.setIdentite(elements[1]);
				LocalDate date = LocalDate.parse(elements[2]);
				
				String[] elementsLieu = elements[3].split(",");
				Lieu lieu = new Lieu(elementsLieu[0], elementsLieu[1], elementsLieu[2], elementsLieu[3]);
				a.setLieux(lieu);
				
				Double taille = Double.parseDouble(elements[4].replace(" m", ""));
				a.setTaille(taille);
				
				a.setUrl(elements[5]);
			//TODO créer des nouveaux lieux avec méthodes plit et transférer en base de données avant d'insérer les acteurs, idem pour les genres et les langues 
			
				listeActeurs.add(a);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeActeurs;
		
		
	}

}
