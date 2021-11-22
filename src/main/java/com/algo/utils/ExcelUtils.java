package com.algo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelUtils {
	
	static Logger log = LoggerFactory.getLogger(ExcelUtils.class);
	private static final int SHEET_TRADES_ROW_START_NO = 3; // 2 is an index, actual row number is 3
	private static final int SHEET_HEADER_ROW_NO = 2; // 2 is an index, actual row number is 3
	
	public static final String SHEET_SL_VAL = "B2";
	public static final String SHEET_TARGET_VAL = "B1";
	public static final String SHEET_CE_SL_VAL = "F2";
	public static final String SHEET_PE_SL_VAL = "H2";
	public static final String SHEET_STRATEGY_NAME_VAL = "D1";
	
	static String fileNamePrefix = "trades_";
	static String ext = "xlsx";
	
	public static String createExcelFile(String dir) {
		String fileFullPath = StringUtils.EMPTY;
		try {
			File directoryPath = new File(dir);
			if(!directoryPath.exists()) {
				directoryPath.mkdirs();
			}
			Integer fileNo = getLastGenerateFileNo(dir);
			fileNo = fileNo+1;
			fileFullPath = dir+File.separator+fileNamePrefix+""+fileNo+"."+ext;
			addHeader(fileFullPath);
			System.out.println("Excel File has been created successfully.");
			return fileFullPath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileFullPath;
	}
	
	//Update a specific cell in the Excel file
	@Deprecated
	public static void updateCellByCellZeroText(String fileFullPath, String c0Text, Integer cNumToUpdate, String textToUpdate) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileFullPath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Integer rowNo = 0;
            for (Row r : sheet) {
                if(r.getCell(0).getStringCellValue().equals(c0Text)) {
                	rowNo = r.getRowNum();
                	break;
                }
            }
            Cell cell2Update = sheet.getRow(rowNo).getCell(cNumToUpdate);
            cell2Update.setCellValue(textToUpdate);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(fileFullPath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update specific cell in specific row in sheet
	 * @param fileFullPath
	 * @param rowNo
	 * @param cellNo
	 * @param textToUpdate
	 */
	public static void updateCellByRowAndCellNums(String fileFullPath, int rowNo, int cellNo, Object textToUpdate, boolean isHeader) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileFullPath)); 
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            CellStyle headerCellStyle = null;
            if(isHeader) {
            	headerCellStyle = getHeaderCellStyle(sheet, workbook);
            }
            Row row = sheet.getRow(rowNo);
            if(row == null)
            	row = sheet.createRow(rowNo);
            Cell cell2Update = row.createCell(cellNo);
            if(textToUpdate instanceof String)
            	cell2Update.setCellValue((String) textToUpdate);
			else if(textToUpdate instanceof Integer)
				cell2Update.setCellValue((Integer)textToUpdate);
			else if(textToUpdate instanceof Double) {
				cell2Update.setCellValue((Double)textToUpdate);
			}
            if(headerCellStyle != null)
            	cell2Update.setCellStyle(headerCellStyle);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(fileFullPath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update specific cell in specific row in sheet
	 * @param fileFullPath
	 * @param rowNo
	 * @param cellNo
	 * @param textToUpdate
	 */
	public static String getCellValByRowAndCellNums(String fileFullPath, int rowNo, int cellNo) {
		String cellVal = null;
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileFullPath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowNo);
            if(row != null) {
            	Cell cell = row.getCell(cellNo);
                cellVal = cell != null ? getCellValueAsString(workbook, cell) : null;;
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(fileFullPath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cellVal;
	}
	
	@Deprecated
	public static boolean isSymbolExistInFile(String fileFullPath, String c0Text) {
		boolean symbolExist = false;
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileFullPath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row r : sheet) {
                if(r.getCell(0).getStringCellValue().equals(c0Text)) {
                	symbolExist = true;
                	break;
                }
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(fileFullPath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return symbolExist;
	}
	
	/**
	 * @param fileFullPath
	 * @param bookData
	 */
	public static void addOrUpdateRow(String fileFullPath, Object[] bookRow) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileFullPath));
            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            int rowCount = getLastRow(sheet);
            Row row = getRowBySymbol(sheet, (String)bookRow[0]);
            if(row == null) {
            	row = sheet.createRow(rowCount);
            }
            Cell cell;
            for(int i=0; i< bookRow.length; i++) {
            	if(bookRow[i] != null && StringUtils.isNotBlank(bookRow[i].toString())) {
            		cell = row.createCell(i);
            		if(bookRow[i] instanceof String)
            			cell.setCellValue((String) bookRow[i]);
            		else if(bookRow[i] instanceof Integer)
                        cell.setCellValue((Integer)bookRow[i]);
            		else if(bookRow[i] instanceof Double) {
                        cell.setCellValue((Double)bookRow[i]);
            		}
            	}
            }
            updateNetPnl(wb, sheet);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(fileFullPath);
            wb.write(outputStream);
            wb.close();
            outputStream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param fileFullPath
	 */
	public static List<String> getAllSymbols(String fileFullPath) {
		List<String> symbols = new ArrayList<>();
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileFullPath));
            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            int i = 0;
            for(Row r : sheet) {
            	if(i < SHEET_TRADES_ROW_START_NO) {
            		i++;
            		continue;
            	}
            	if(r.getCell(0) != null && StringUtils.isNotBlank(r.getCell(0).toString()))
            		symbols.add(r.getCell(0).toString());
            }
            inputStream.close();
            wb.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return symbols;
	}
	
	/**
	 * @param fileFullPath
	 * @param bookData
	 */
	public static void addOrUpdateRows(String fileFullPath, List<Object[]> bookRows) {
		log.info("addOrUpdateRows>");
		try {
            for(Object[] bookRow: bookRows) {
            	addOrUpdateRow(fileFullPath, bookRow);
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		log.info("<addOrUpdateRows");
	}
	
	private static Row getRowBySymbol(Sheet sheet, String symbol) {
		for (Row r : sheet) {
            if(r.getCell(0) != null && StringUtils.isNotBlank(r.getCell(0).toString()) && r.getCell(0).toString().equals(symbol)) 
            	return r;
		}
		return null;
	}

	private static int getLastRow(Sheet sheet) {
		int i = 0;
		for (Row r : sheet) {
            if(r.getCell(0) == null || StringUtils.isBlank(r.getCell(0).toString())) 
            	break;
			i++;
		}
		return i;
	}

	private static void addHeader(String fileFullPath) throws FileNotFoundException, IOException {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Object[] bookRow = {"Position","Qty", "Sell Price", "Buy Price", "Current Price", "P&L", "Ex Time", "Close Time"};
				//prepareDataRow("Position","Qty", "Sell Price", "Buy Price", "Current Price", "P&L", "Trade Time");
		CellStyle headerCellStyle = getHeaderCellStyle(sheet, wb);
		Row row = sheet.createRow(SHEET_HEADER_ROW_NO);
		Cell cell;
		for(int i=0; i < bookRow.length; i++) {
			if(i == 0)
				sheet.setColumnWidth(i, 35 * 256);
			else
				sheet.setColumnWidth(i, 20 * 256);
			cell = row.createCell(i);
			cell.setCellStyle(headerCellStyle);
			cell.setCellValue((String) bookRow[i]);
		}
		FileOutputStream outputStream = new FileOutputStream(fileFullPath);
		wb.write(outputStream);
		wb.close();
		outputStream.close();
		updateCellByRowAndCellNums(fileFullPath, 0, 0, "TARGET", true);
		updateCellByRowAndCellNums(fileFullPath, 0, 2, "Strategy", true);
		updateCellByRowAndCellNums(fileFullPath, 1, 0, "S/L Credit If", true);
		updateCellByRowAndCellNums(fileFullPath, 1, 2, "Net P/L", true);
		updateCellByRowAndCellNums(fileFullPath, 1, 4, "CE S/L", true);
		updateCellByRowAndCellNums(fileFullPath, 1, 6, "PE S/L", true);
	}

	private static CellStyle getHeaderCellStyle(Sheet sheet, Workbook wb) {
		Font headerFont = wb.createFont();
		headerFont.setColor(IndexedColors.WHITE.index);
		headerFont.setBold(true);
		CellStyle headerCellStyle = sheet.getWorkbook().createCellStyle();
		headerCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		return headerCellStyle;
	}

	public static Object[] prepareDataRow2(Object c0, Object c1, Object c2, Object c3, Object c4, Object c5, Object c6) {
		Object[] headerData = {c0, c1, c2, c3, c4, c5, c6};
		return headerData;
	}
	
	public static Object[] prepareDataRow(Object... objArray) {
		Object[] headerData = new Object[objArray.length];
		for(int i=0;i<objArray.length;i++) {
			headerData[i] = objArray[i];
		}
		return headerData;
	}
	
	public static String getCurrentFileNameWithPath(String dir) {
		log.info("getCurrentFileNameWithPath>");
		String fileName = "trades_"+getLastGenerateFileNo(dir);
		fileName = dir+File.separator+fileName+"."+ext;
		File file = new File(fileName);
		if(!file.exists())
			ExcelUtils.createExcelFile(dir);
		log.info("<getCurrentFileNameWithPath");
		return fileName;
	}
	
	private static Integer getLastGenerateFileNo(String dir) {
		Integer maxNo = 0;
		try {
			File directoryPath = new File(dir);
			List<Integer> fileSeqns = new ArrayList<>();
			List<String> fileNames = null;
			if(directoryPath.exists() && directoryPath.isDirectory()) {
				fileNames = Arrays.asList(directoryPath.list());
			} else {
				directoryPath.mkdirs();
			}
			if(fileNames != null && fileNames.size() > 0) {
				for(int i=0; i < fileNames.size(); i++) {
					if(fileNames.get(i).startsWith(fileNamePrefix) &&  fileNames.get(i).endsWith("."+ext)) {
						String fName = fileNames.get(i).replace("."+ext, StringUtils.EMPTY);
						fileSeqns.add(Integer.valueOf(fName.split("_")[1]));
					}
				}
				if(CollectionUtils.isNotEmpty(fileSeqns))
					maxNo = fileSeqns.stream().max(Integer::compare).get();
			} 
		} catch(Exception e) {
			e.printStackTrace();
			return 9999;
		}
		return maxNo;
	}
	
	public static void updateNetPnl(Workbook wb, Sheet sheet) {
		Cell formulaCell = sheet.getRow(1).createCell(3);
		formulaCell.setCellFormula("SUM(F2:F1000)");
		FormulaEvaluator formulaEvaluator = 
				  wb.getCreationHelper().createFormulaEvaluator();
				formulaEvaluator.evaluate(formulaCell);
	}
	
	public static String[][] getFileData(String filePath) {
		log.info("getFileData>");
		log.info("READING FILE: "+filePath);
		String[][] dataTable = null;
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			Workbook wb = WorkbookFactory.create(inputStream);
			Sheet sheet = wb.getSheetAt(0);
			int noOfRows = getLastRow(sheet);
			log.info("TOTAL ROWS FOUND "+noOfRows);
			int noOfColumns = sheet.getRow(0).getLastCellNum();
			log.info("Cell count iin first row: "+noOfColumns);
			dataTable = new String[noOfRows][8];
			for (int i = SHEET_TRADES_ROW_START_NO; i < noOfRows; i++) {
			    Row row = sheet.getRow(i);
			    noOfColumns = row.getLastCellNum();
			    log.info("COLUMNS IN ROW: "+i+": "+noOfColumns);
			    for (int j = row.getFirstCellNum(); j < noOfColumns; j++) {
			        Cell cell = row.getCell(j);
			        String cellData = getCellValueAsString(wb, cell);
			        log.info("Row: "+i+", Column : "+j+" value is :"+cellData);
			        dataTable[i][j] = cellData;
			    }
			}
			wb.close();
			inputStream.close();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("<getFileData");
	    return dataTable;
	}
	
	public static String getValueByCellReference(String filePath, String cellRef) {
		String cellVal = StringUtils.EMPTY;
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			Workbook wb = WorkbookFactory.create(inputStream);
			Sheet sheet = wb.getSheetAt(0);
			CellReference cr = new CellReference(cellRef);
			Row row = sheet.getRow(cr.getRow());
			Cell cell = row.getCell(cr.getCol());
			cellVal = getCellValueAsString(wb, cell);
			wb.close();
			return cellVal;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cellVal;
	}
	
	public static void setValueByCellReference(String filePath, String cellRef, Object value) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			Workbook wb = WorkbookFactory.create(inputStream);
			Sheet sheet = wb.getSheetAt(0);
			CellAddress cellAddress = new CellAddress(cellRef);
			Cell updatedCell = sheet.getRow(cellAddress.getRow()).getCell(cellAddress.getColumn());
			// if cell is null than create the cell
			if(updatedCell == null){
				sheet.getRow(cellAddress.getRow()).createCell(cellAddress.getColumn());
				updatedCell = sheet.getRow(cellAddress.getRow()).createCell(cellAddress.getColumn());
			}
			if(value instanceof String)
				updatedCell.setCellValue((String) value);
			else if(value instanceof Integer)
				updatedCell.setCellValue((Integer)value);
			else if(value instanceof Double) {
				updatedCell.setCellValue((Double)value);
			}
			inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(filePath);
            wb.write(outputStream);
			wb.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setValueWithRedBgByCellReference(String filePath, String cellRef, String value) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			Workbook wb = WorkbookFactory.create(inputStream);
			Sheet sheet = wb.getSheetAt(0);
			CellStyle style = wb.createCellStyle(); 
            style.setFillForegroundColor(IndexedColors.RED.getIndex());  
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
			
			CellAddress cellAddress = new CellAddress(cellRef);
			Cell updatedCell = sheet.getRow(cellAddress.getRow()).getCell(cellAddress.getColumn());
			// if cell is null than create the cell
			if(updatedCell == null){
				sheet.getRow(cellAddress.getRow()).createCell(cellAddress.getColumn());
				updatedCell = sheet.getRow(cellAddress.getRow()).createCell(cellAddress.getColumn());
			}
			updatedCell.setCellStyle(style); 
			updatedCell.setCellValue(value);
			inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(filePath);
            wb.write(outputStream);
			wb.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getCellValueAsString(Workbook wb, Cell cell) {
		if(cell == null) return "";
		@SuppressWarnings("deprecation")
		CellType cellType = CellType.forInt(cell.getCellType());
		String val = "";

		switch (cellType) {
		case STRING:
			val = StringUtils.isNotBlank(cell.getStringCellValue()) ? cell.getStringCellValue() : StringUtils.EMPTY;
			break;
		case NUMERIC:
			val = cell.getNumericCellValue() != 0 ? String.valueOf(cell.getNumericCellValue()) : "0";
			break;
		case BOOLEAN:
			val = String.valueOf(cell.getBooleanCellValue());
			break;
		case BLANK:
			break;
		case FORMULA:
			val = evaluateFormulaAsText(wb, cell);
			break;
		case ERROR:
			break;
		case _NONE:
			break;
		default:
			break;
		}
		return val;
	}
	
	@SuppressWarnings("deprecation")
	private static String evaluateFormulaAsText(Workbook workbook, Cell cell) {
		String val = "";
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
		switch (evaluator.evaluateFormulaCellEnum(cell)) {
		case BOOLEAN:
			val = String.valueOf(cell.getBooleanCellValue());
			break;
		case NUMERIC:
			val = cell.getNumericCellValue() != 0 ? String.valueOf(cell.getNumericCellValue()) : "0";
			break;
		case STRING:
			val = StringUtils.isNotBlank(cell.getStringCellValue()) ? cell.getStringCellValue() : StringUtils.EMPTY;
			break;
		case BLANK:
			break;
		case ERROR:
			break;
		case FORMULA:
			break;	
		case _NONE:
			break;
		default:
			break;
		}
		return val;
	}
	
}
