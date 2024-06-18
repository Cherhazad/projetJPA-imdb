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
import Application.Entites.Pays;
import Application.Utils.DaoLien;

public class PaysLectureCSV {

	public static final PaysDAO paysDAO = DaoLien.paysDao();
	public static final LangueDAO langueDAO = DaoLien.langueDao();
	public static final LieuDAO lieuDAO = DaoLien.lieuDao();

	public static Set<Pays> lireFichier() {

		Set<Pays> setPays = new HashSet<>();

		Path path = Paths.get("src/main/resources/pays.csv");

		try {
			List<String> lignes = Files.readAllLines(path);
			lignes.remove(0);

			for (String ligne : lignes) {
				String[] elements = ligne.split(";");
				String nomPays = elements[0].trim();

				if (!nomPays.isEmpty() && !langueDAO.ifLangueExists(nomPays)) {
					Pays p = new Pays();
					p.setNom(nomPays);
					p.setUrl(elements[1].trim());
					setPays.add(p);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return setPays;

	}

}
