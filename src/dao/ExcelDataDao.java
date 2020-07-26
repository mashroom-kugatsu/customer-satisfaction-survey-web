package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

import dto.ExcelDataDto;

public class ExcelDataDao {

	public List<ExcelDataDto> getExcelDataList(String uploadFilePath) throws IOException {

		/*
		 * String filePath = "C:\\Users\\S.Matsukawa\\Desktop\\cs_web_entry\\"; String
		 * fileName = "cs_web_entry_test.xlsx";
		 */

		Workbook workbook = null;
		FileInputStream in = null;

		List<ExcelDataDto> excelDataList = new ArrayList<>();

		try {
			in = new FileInputStream(uploadFilePath);

			workbook = WorkbookFactory.create(in);

			Sheet sheet = workbook.getSheetAt(0);

			int i = 1;
			Row row = sheet.getRow(i);

			if (row != null) {

				String input_date = readSurveyData(sheet, 1,2);
				String district = readSurveyData(sheet, 2, 2);
				String model = readSurveyData(sheet, 3, 2);
				String business_team = readSurveyData(sheet, 4, 2);
				String business_traveler = readSurveyData(sheet, 5, 2);
				String company = readSurveyData(sheet, 6, 2);
				String division = readSurveyData(sheet, 7, 2);
				String responsible = readSurveyData(sheet, 8, 2);
				String postal = readSurveyData(sheet, 9, 2);
				String address = readSurveyData(sheet, 10, 2);
				String tel = readSurveyData(sheet, 11, 2);
				String kiban = readSurveyData(sheet, 12, 2);
				String questionnaire_date = readSurveyData(sheet, 13, 2);

				String _1C1 = readSurveyData(sheet, 14, 2);
				String _1E1 = readSurveyData(sheet, 15, 2);
				String _1G1 = readSurveyData(sheet, 16, 2);
				String _1I1 = readSurveyData(sheet, 17, 2);
				String _1K1 = readSurveyData(sheet, 18, 2);
				String _1B2 = readSurveyData(sheet, 19, 2);
				String _2C1 = readSurveyData(sheet, 20, 2);
				String _2E1 = readSurveyData(sheet, 21, 2);
				String _2G1 = readSurveyData(sheet, 22, 2);
				String _2B2 = readSurveyData(sheet, 23, 2);
				String _3B1 = readSurveyData(sheet, 24, 2);
				String _3E1 = readSurveyData(sheet, 25, 2);
				String _3D2 = readSurveyData(sheet, 26, 2);
				String _4B1 = readSurveyData(sheet, 27, 2);
				String _4E1 = readSurveyData(sheet, 28, 2);
				String _4G1 = readSurveyData(sheet, 29, 2);
				String _4D2 = readSurveyData(sheet, 30, 2);
				String _4D3 = readSurveyData(sheet, 31, 2);
				String _4D4 = readSurveyData(sheet, 32, 2);
				String _5B1 = readSurveyData(sheet, 33, 2);
				String _5E1 = readSurveyData(sheet, 34, 2);
				String _5C2 = readSurveyData(sheet, 35, 2);
				String _5E2 = readSurveyData(sheet, 36, 2);
				String _5G2 = readSurveyData(sheet, 37, 2);
				String _5I2 = readSurveyData(sheet, 38, 2);
				String _5K2 = readSurveyData(sheet, 39, 2);
				String _5B4 = readSurveyData(sheet, 40, 2);
				String _5C3 = readSurveyData(sheet, 41, 2);
				String _5E3 = readSurveyData(sheet, 42, 2);
				String _5G3 = readSurveyData(sheet, 43, 2);
				String _5I3 = readSurveyData(sheet, 44, 2);
				String _5K3 = readSurveyData(sheet, 45, 2);
				String _5B5 = readSurveyData(sheet, 46, 2);
				String _6A1 = readSurveyData(sheet, 47, 2);
				String _7A1 = readSurveyData(sheet, 48, 2);

				ExcelDataDto excelDto = new ExcelDataDto(input_date, district, model, business_team, business_traveler,
						company, division, responsible, postal, address, tel, kiban, questionnaire_date, _1C1, _1E1,
						_1G1, _1I1, _1K1, _1B2, _2C1, _2E1, _2G1, _2B2, _3B1, _3E1, _3D2, _4B1, _4E1, _4G1, _4D2, _4D3,
						_4D4, _5B1, _5E1, _5C2, _5E2, _5G2, _5I2, _5K2, _5B4, _5C3, _5E3, _5G3, _5I3, _5K3, _5B5, _6A1,
						_7A1);

				excelDataList.add(excelDto);

			}

		} finally {
			if (in != null) {
				in.close();
			}
			if (workbook != null) {
				workbook.close();
			}
		}
		return excelDataList;
	}

	private  String readSurveyData(Sheet sheet, int row, int col) {
		return readCell(sheet.getRow(row).getCell(col));
	}
	
	private static String readCell(Cell cell) {

		switch (cell.getCellType()) {
		// 文字列(標準)
		case STRING:
			return cell.getStringCellValue();
		// 数値(自前)
		case NUMERIC:
			return getStringNmericValue(cell);
		// 真理値(標準)
		case BOOLEAN:
			return Boolean.toString(cell.getBooleanCellValue());
		// 関数値(自前)
		case FORMULA:
			return getStringFormulaValue(cell);
		// 空白(自前)
		case BLANK:
			return getStringRangeValue(cell);
		default:
			System.out.println("Unexpected Type: " + cell.getCellType());
			return null;
		}

	}

	private static String getStringNmericValue(Cell cell) {
		// 標準の日付の場合
		if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			// java.time.DateTimeFormatterで文字列化
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
			LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
			return dateTimeFormatter.format(localDateTime);
		}
		// ユーザー定義型で日付を設定している場合
		if (BuiltinFormats.FIRST_USER_DEFINED_FORMAT_INDEX <= cell.getCellStyle().getDataFormat()) {
			CellFormat cellFormat = CellFormat.getInstance(cell.getCellStyle().getDataFormatString());
			return cellFormat.apply(cell).text;
		}
		// 日付じゃない場合は数値を返す。
		return Double.toString(cell.getNumericCellValue());
	}

	public static String getStringRangeValue(Cell cell) {

		// 読み取り対象のセルのindexを取得
		int rowIndex = cell.getRowIndex();
		int columnIndex = cell.getColumnIndex();

		// 結合された領域に含まれるかをしらみつぶしに探す。
		Sheet sheet = cell.getSheet();
		int size = sheet.getNumMergedRegions();
		for (int i = 0; i < size; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			// 含まれる領域があった場合
			if (range.isInRange(rowIndex, columnIndex)) {
				// 左上のcellの取得
				Cell firstCell = sheet.getRow(range.getFirstRow()).getCell(range.getFirstColumn());
				// Cell->Stringのメソッドに投げる。
				return readCell(firstCell);
			}
		}
		return "null";
	}

	public static String getStringFormulaValue(Cell cell) {
		Workbook book = cell.getSheet().getWorkbook();
		CreationHelper helper = book.getCreationHelper();
		FormulaEvaluator evaluator = helper.createFormulaEvaluator();
		CellValue value = evaluator.evaluate(cell);

		// 計算結果の中身に合わせてメソッドの呼び出し先を変える。
		switch (value.getCellType()) {
		case STRING:
			return value.getStringValue();
		case NUMERIC:
			return Double.toString(value.getNumberValue());
		case BOOLEAN:
			return Boolean.toString(value.getBooleanValue());
		default:
			System.out.println("Unexpected Type: " + value.getCellType());
			return null;
		}

	}

}
