package Application.Utils;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DateUtils {

	private static final List<Locale> LOCALES = Arrays.asList(Locale.US, Locale.FRANCE);
	public static LocalDate parseDate(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null; // Gestion des cas où la date est vide
        }

        for (Locale locale : LOCALES) {
            try {
                String[] elementsDate = dateString.trim().split(" ");
                DateTimeFormatter formatter;

                switch (elementsDate.length) {
                    case 1:
                        // Parsing pour une année seule "yyyy"
                        formatter = DateTimeFormatter.ofPattern("yyyy");
                        return YearMonth.parse(dateString, formatter).atDay(1); // 1er janvier de l'année

                    case 2:
                        // Vérifier si le deuxième élément est une année ou un jour
                        if (isYear(elementsDate[1])) {
                            // Si c'est une année, interpréter comme "MMMM yyyy"
                            formatter = DateTimeFormatter.ofPattern("MMMM yyyy", locale);
                            return YearMonth.parse(dateString, formatter).atDay(1); // 1er jour du mois
                        } else {
                            // Sinon, interpréter comme "MMMM d"
                            formatter = DateTimeFormatter.ofPattern("MMMM d", locale);
                            return MonthDay.parse(dateString, formatter).atYear(LocalDate.now().getYear()); // Utilisation de l'année actuelle
                        }

                    case 3:
                        // Parsing pour le format complet "MMMM d yyyy"
                        formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMMM d yyyy")
                                .toFormatter(locale);
                        return LocalDate.parse(dateString, formatter);

                    default:
                        throw new DateTimeParseException("Unsupported date format", dateString, 0);
                }
            } catch (DateTimeParseException e) {
                // Continuer avec le prochain locale si le parsing échoue
                System.err.println("Error parsing date: " + dateString + ". Error: " + e.getMessage());
            }
        }

        // Si aucun locale n'a pu parser la date, lever une exception
        throw new DateTimeParseException("Unsupported date format", dateString, 0);
    }

    public static boolean isYear(String yearString) {
        try {
            int currentYear = LocalDate.now().getYear();
            int year = Integer.parseInt(yearString);
            return year >= 1 && year <= currentYear;
        } catch (NumberFormatException e) {
            return false; // Si la conversion en entier échoue, ce n'est pas une année valide
        }
    }
	
}
