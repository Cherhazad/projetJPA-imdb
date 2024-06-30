package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import Application.Entites.Lieu;
import Application.Entites.Realisateur;
import Application.Utils.DateUtils;

public class RealisateurLectureCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Path path = Paths.get("src/main/resources/acteurs.csv");

		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);

			for (String ligne : lignes) {
				String[] elementsRealisateurs = ligne.split(";");
				
				Realisateur r = new Realisateur();
				
				String id = elementsRealisateurs[0];
				String identite = elementsRealisateurs[1];
			
				// attribution date de naissance au format date
				LocalDate date = null;
                try {
                    if (elementsRealisateurs[2].split(" ").length != 0) {
                        date = DateUtils.parseDate(elementsRealisateurs[2]);
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    date = null;
                }
				
                String elementsLieux = elementsRealisateurs[3];
                Lieu l = LieuLectureCSV.splitLieux(elementsLieux);
                
                String url = elementsRealisateurs[4];
				System.out.println(ligne);
				
				r.setId(id);
				r.setIdentite(identite);
//				r.setDateNaissance(date); // TODO
//				r.setLieuNaissance(l); //TODO
				r.setUrl(url);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
