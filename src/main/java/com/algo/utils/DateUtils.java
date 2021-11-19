package com.algo.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DateUtils {
	
	public static Map<String, String> kiteToOpstra = new HashMap<>();
	
	static {
		kiteToOpstra.put("21N03", "03NOV2021");
		kiteToOpstra.put("21N11", "11NOV2021");
		kiteToOpstra.put("21N18", "18NOV2021");
		kiteToOpstra.put("21NOV", "25NOV2021");
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
	
	public static LocalDate textToLocalDateddMMYYYY(String ddMMyyyy) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(ddMMyyyy, formatter);
	}
	
	public static String getAngelFormatExpiry(String ddMMyyyy) {
		return DateUtils.getExpiryFormat(DateUtils.textToLocalDateddMMYYYY(ddMMyyyy), Constants.AGL_EXPIRY_FORMAT);
	}
}
