package Application.Lecteurs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Application.DAO.ActeurDAO;
import Application.DAO.DaoLien;
import Application.DAO.LieuDAO;
import Application.DAO.PaysDAO;
import Application.Entites.Acteur;
import Application.Entites.Lieu;
import Application.Utils.DateUtils;

public class ActeurLectureCSV {

    public static final PaysDAO paysDAO = DaoLien.paysDao();
    public static final LieuDAO lieuDAO = DaoLien.lieuDao();
    public static final ActeurDAO acteurDAO = DaoLien.acteurDao();

    public static Set<Acteur> lireFichier() {

        Set<Acteur> setActeurs = new HashSet<>();

        Path path = Paths.get("src/main/resources/acteurs.csv");

        try {
            List<String> lignes = Files.readAllLines(path);
            lignes.remove(0);

            for (String ligne : lignes) {

                String[] elementsActeurs = ligne.split(";");
                Acteur a = new Acteur();

                // id acteur
                String id = elementsActeurs[0];
                
                // identite acteur
                String identite = elementsActeurs[1];
               
                // date de Naissance de l'acteur
                LocalDate date = null;
                try {
                    if (elementsActeurs[2].split(" ").length != 0) {
                        date = DateUtils.parseDate(elementsActeurs[2]);
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    date = null;
                }
                
                // lieu de naissance de l'acteur
                String elementsLieux = elementsActeurs[3];
                Lieu l = LieuLectureCSV.splitLieux(elementsLieux);

                // taille de l'acteur
                String tailleString = elementsActeurs[4].replace(",", ".").split(" ")[0];
                
                // url de l'acteur
                String url = elementsActeurs[5];
                

                // Mise à jour du Set d'Acteur s'il n'existe pas en base
                if (!acteurDAO.ifActeurExists(a)) {
                    setActeurs.add(a);
                }
                
                a.setId(id);
                a.setIdentite(identite);
                a.setDateNaissance(date);
                a.setLieuNaissance(l);
//              a.setTaille(tailleString); //TODO corriger bug dans le parsing
                a.setUrl(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return setActeurs;
    }
}
