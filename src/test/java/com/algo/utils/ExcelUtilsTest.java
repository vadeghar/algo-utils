package com.algo.utils;

import org.junit.jupiter.api.Test;

public class ExcelUtilsTest {
	
//	@Test
//	public void createExcelFileTest() {
//		ExcelUtils.createExcelFile("D:\\kite\\trades");
//	}
	
//	@Test
//	public void getLatestFileNameWithPathTest() {
//		String latetFile = ExcelUtils.getLatestFileNameWithPath("D:\\kite\\trades\\", "trades", "xlsx");
//		System.out.println(latetFile);
//	}
	
//	@Test
//	public void isSymbolExistInFileTest() {
//		boolean b = ExcelUtils.isSymbolExistInFile("D:\\kite\\trades\\trades_1.xlsx", "NIFTY21NOV17750PE");
//		System.out.println(b);
//	}
	
//	@Test
//	public void updateCellByCellZeroTextTest() {
//		ExcelUtils.updateCellByCellZeroText("D:\\kite\\trades\\trades_1.xlsx", "NIFTY21NOV17750PE", 3, "55");
//	}
	
//	@Test
//	public void addNewRowAtLastTest() {
//		Object[] bookData1 = ExcelUtils.prepareDataRow("NIFTY21NOV17550PE", "100", "", "", "", "", "");
//		ExcelUtils.addOrUpdateRow("D:\\kite\\trades\\trades_1.xlsx", bookData1);
//	}

	@Test
	public void getAllSymbolsTest() {
		ExcelUtils.setValueByCellReference("D:/Other/trades/kite/trades_3.xlsx", "B2", "TESTING");
	}
}
