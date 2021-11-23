package com.algo.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DateUtils {
	
	private static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static Map<String, String> kiteToOpstra = new HashMap<>();
	public static List<LocalDate> expiryDateList = new ArrayList<>();
	static {
		kiteToOpstra.put("21N03", "03NOV2021");
		kiteToOpstra.put("21N11", "11NOV2021");
		kiteToOpstra.put("21N18", "18NOV2021");
		kiteToOpstra.put("21NOV", "25NOV2021");
		
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2021-11-25"));
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2021-12-02"));
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2021-12-09"));
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2021-12-16"));
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2021-12-23"));
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2021-12-30"));
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2022-01-06"));
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2022-01-13"));
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2022-01-20"));
		expiryDateList.add(formatDateAsLocalDate(YYYY_MM_DD, "2022-01-27"));
	}

	public static String getExpiryFormat(LocalDate expiry, String opstExpiryFormat) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(opstExpiryFormat);
	     return formatter.format(expiry).toUpperCase();
	}
	
	public static String getDateTime(LocalDateTime localDate) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT);
	     return formatter.format(localDate).toUpperCase();
	}
	
	public static String getKiteExpiry(String opstExpiry) {
	    for (Entry<String, String> entry : kiteToOpstra.entrySet()) {
	        if (entry.getValue().equals(opstExpiry)) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	public static String opstraFormattedExpiry(String ddMMyyyy) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(ddMMyyyy, formatter);
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(Constants.OPST_EXPIRY_FORMAT);
		return formatter2.format(date).toUpperCase();
	}
	
	public static String opstraFormattedExpiry(LocalDate localDate) {
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(Constants.OPST_EXPIRY_FORMAT);
		return formatter2.format(localDate).toUpperCase();
	}
	
	public static LocalDate formatDateAsLocalDate(String yyyyMMdd, String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(yyyyMMdd);
		return LocalDate.parse(date, formatter);
	}
	
	public static LocalDate textToLocalDateddMMYYYY(String ddMMyyyy) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(ddMMyyyy, formatter);
	}
	
	public static String getAngelFormatExpiry(String ddMMyyyy) {
		return DateUtils.getExpiryFormat(DateUtils.textToLocalDateddMMYYYY(ddMMyyyy), Constants.AGL_EXPIRY_FORMAT);
	}
	
	public static LocalDate getCurrentExpiry() {
		return expiryDateList.stream().filter(exDate -> exDate.isAfter(LocalDate.now())).findFirst().get();
	}
	
	public static boolean isMonthlyExpiry(LocalDate curExpiryDay) {
		//LocalDate end = localDate.withDayOfMonth(localDate.lengthOfMonth());
//		LocalDate lastDayOfMonth  = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
		LocalDate lastThursdayInMonth = LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
		//LocalDate nextExpDay = curExpiryDay.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
		return (curExpiryDay.isEqual(lastThursdayInMonth));
	}
}
