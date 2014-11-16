package br.com.carro.dateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

	public static Calendar parseCalendar(String data) throws ParseException {
		// Cria uma instancia de calendar
		Calendar calendar = Calendar.getInstance();
		// String -> Date ou Date -> String
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// Transforma a String em Date e coloca no Calendar
		calendar.setTime(sdf.parse(data));
		return calendar;
	}

}