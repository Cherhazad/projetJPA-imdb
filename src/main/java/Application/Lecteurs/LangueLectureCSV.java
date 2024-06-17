package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.DAO.LangueDAO;
import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Langue;
import Application.Utils.DaoLien;

public class LangueLectureCSV {
	
	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LangueDAO langueDAO = DaoLien.langueDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();
	

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

				if (!nomLangue.isEmpty() && !langueDAO.ifLangueExists(nomLangue)) {
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
