package Application.Utils;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DateUtils {

	private static final List<Locale> LOCALES = Arrays.asList(Locale.US, Locale.FRENCH);

	public static LocalDate parseDate(String dateString) {
		if (dateString == null || dateString.trim().isEmpty()) {
			return null; // Gestion des cas où la date est vide
		}

		for (Locale locale : LOCALES) {
			try {
				String[] elementsDate = dateString.trim().split(" ");
				DateTimeFormatter formatter;

				if (dateString.startsWith("c. ")) {
		            dateString = dateString.substring(3); // Supprime "c. "
		        }

				switch (elementsDate.length) {

				case 1:
					// Parsing pour une année seule "yyyy"
					DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy", locale);
					Year year = Year.parse(dateString, yearFormatter);
					MonthDay monthDayStandard = MonthDay.of(1, 1);
					LocalDate date = year.atMonthDay(monthDayStandard);
					return date;

				case 2:
					// Vérifier si le deuxième élément est une année ou un jour
					if (elementsDate[1].length() == 4) {
						// Si c'est une année, interpréter comme "MMMM yyyy"
						DateTimeFormatter yearMonthFormatter = DateTimeFormatter.ofPattern("MMMM yyyy", locale);
						YearMonth yearMonth = YearMonth.parse(dateString, yearMonthFormatter);
						LocalDate date2 = yearMonth.atDay(1);
						return date2;
					}

					else {
						// Sinon, interpréter comme "MMMM d"
						DateTimeFormatter monthDayFormatter = DateTimeFormatter.ofPattern("MMMM d", locale);
						MonthDay monthDay = MonthDay.parse(dateString, monthDayFormatter);
						LocalDate date2 = monthDay.atYear(LocalDate.now().getYear());
						return date2;
					}

				case 3:
					// Parsing pour le format complet "MMMM d yyyy"
					if (elementsDate[0].length() <= 2) {
						formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRENCH);
						LocalDate date3 = LocalDate.parse(dateString, formatter);
						return date3;
					}

					formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", locale);
					LocalDate date3 = LocalDate.parse(dateString, formatter);
					return date3;

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
}
