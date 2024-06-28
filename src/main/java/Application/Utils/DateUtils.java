package Application.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateUtils {

	private static final List<Locale> LOCALES = Arrays.asList(Locale.US, Locale.FRANCE);

	public static Date parseDate(String dateString) {
		if (dateString == null || dateString.trim().isEmpty()) {
			return null; // Gestion des cas où la date est vide
		}

		for (Locale locale : LOCALES) {

			String[] elementsDate = dateString.trim().split(" ");
			SimpleDateFormat formatter;
			switch (elementsDate.length) {
			case 1:
				formatter = new SimpleDateFormat("yyyy", locale);
				try {
					return formatter.parse(dateString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			case 2:
				if (isYear(elementsDate[1])) {
					formatter = new SimpleDateFormat("MMMM yyyy", locale);
					try {
						return formatter.parse(dateString);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					formatter = new SimpleDateFormat("MMMM dd", locale);
					try {
						return formatter.parse(dateString);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			case 3:

				formatter = new SimpleDateFormat("MMMM dd yyyy", locale);
				try {
					return formatter.parse(dateString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			default:
				return null;
			}
		}
		return null;
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
