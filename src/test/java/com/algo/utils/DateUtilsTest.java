package com.algo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class DateUtilsTest {

	
	public void getExpiryFormatTest() {
		LocalDate expiry = LocalDate.now().plusDays(26);
		String opstExpiryFormat = Constants.AGL_APPEND_TO_SCRIPT_FORMAT;
		String fDate = DateUtils.getExpiryFormat(expiry, opstExpiryFormat);
		System.out.println("fDate: "+fDate);
	}
	
	//@Test
	public void test() {
		//NIFTY21NOV16800PE
		DateTimeFormatter monthlyFormatter = DateTimeFormatter.ofPattern("MMM");
		DateTimeFormatter weeklyFormatter = DateTimeFormatter.ofPattern("dd");
		String s = "NIFTY21";
		boolean isMonthly = false;
		LocalDate expiry = LocalDate.of(2021, 11, 25);
		String strike = "16800";
		String optType = Constants.PE;
		String tradingSymbol = "";
		if(isMonthly) {
			tradingSymbol = s+monthlyFormatter.format(expiry).toUpperCase()+strike+optType;
		} else {
			String l1 = monthlyFormatter.format(expiry).toUpperCase();
			tradingSymbol = s+l1.substring(0,1)+weeklyFormatter.format(expiry).toUpperCase()+strike+optType;
		}
		
		String ss = "NIFTY21NOV16800PE";
		System.out.println(ss.substring(7,7));
		System.out.println("SYMBOL: "+tradingSymbol);
	}
	
	//@Test
	public void test2() {
		String ts = "BANKNIFTY21NOV16800PE";
		String symbol = ts.substring(0, ts.length() - 12);
		String expiry = ts.substring(symbol.length(), ts.length() - 7);
		System.out.println("SYMBOL: "+symbol+ "\nEXIPRY: "+expiry );
	}
	@Test
	public void getCurrentExpiryTest() {
		System.out.println("NEXT EXPIRY: "+DateUtils.isMonthlyExpiry(DateUtils.getCurrentExpiry()));
	}
	
//	KiteUtils ts = new KiteUtils();
//	@Test
//	public void test3() {
//		String tradingSymbol = "NIFTY21NOV16800PE";
//		System.out.println("SYMBOL: "+ts.getSymbol(tradingSymbol)+ "\nEXIPRY: "+ts.getKiteExpiry(tradingSymbol) );
//		System.out.println("\nSTRIKE: "+ts.getStrikePrice(tradingSymbol)+ "\nOPTION TYPE: "+ts.getOptionType(tradingSymbol) );
//	}
}
