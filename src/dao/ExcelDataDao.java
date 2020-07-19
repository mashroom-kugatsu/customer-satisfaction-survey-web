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

	public List<ExcelDataDto> getExcelDataList() throws IOException {

		String filePath = "C:\\Users\\S.Matsukawa\\Desktop\\cs_web_entry\\";
		String fileName = "cs_web_entry_test.xlsx";

		Workbook workbook = null;
		FileInputStream in = null;

		List<ExcelDataDto> excelDataList = new ArrayList<>();

		try {
			in = new FileInputStream(filePath + fileName);

			workbook = WorkbookFactory.create(in);

			Sheet sheet = workbook.getSheetAt(1);

			/*
			 * ExcelDataDto excelDataDto = new ExcelDataDto(district, model, input_date,
			 * postal, address, tel, questionnaire_date, company, division, responsible,
			 * business_traveler, kiban, _1C1, _1E1, _1G1, _1I1, _1K1, _1B2, _2C1, _2E1,
			 * _2G1, _2B2, _3B1, _3E1, _3D2);
			 */

			int i = 1;
			Row row = sheet.getRow(i);

			if (row != null) {
				// Cell cell = row.getCell(2);
				// System.out.println(readCell(cell));

				String district = readCell(sheet.getRow(1).getCell(2));
				String model = readCell(sheet.getRow(2).getCell(2));
				String input_date = readCell(sheet.getRow(3).getCell(2));
				String postal = readCell(sheet.getRow(4).getCell(2));
				String address = readCell(sheet.getRow(5).getCell(2));
				String tel = readCell(sheet.getRow(6).getCell(2));
				String questionnaire_date = readCell(sheet.getRow(7).getCell(2));
				String company = readCell(sheet.getRow(8).getCell(2));
				String division = readCell(sheet.getRow(9).getCell(2));
				String responsible = readCell(sheet.getRow(10).getCell(2));
				String business_traveler = readCell(sheet.getRow(11).getCell(2));
				String kiban = readCell(sheet.getRow(12).getCell(2));
				String _1C1 = readCell(sheet.getRow(13).getCell(2));
				String _1E1 = readCell(sheet.getRow(14).getCell(2));
				String _1G1 = readCell(sheet.getRow(15).getCell(2));
				String _1I1 = readCell(sheet.getRow(16).getCell(2));
				String _1K1 = readCell(sheet.getRow(17).getCell(2));
				String _1B2 = readCell(sheet.getRow(18).getCell(2));
				String _2C1 = readCell(sheet.getRow(19).getCell(2));
				String _2E1 = readCell(sheet.getRow(20).getCell(2));
				String _2G1 = readCell(sheet.getRow(21).getCell(2));
				String _2B2 = readCell(sheet.getRow(22).getCell(2));
				String _3B1 = readCell(sheet.getRow(23).getCell(2));
				String _3E1 = readCell(sheet.getRow(24).getCell(2));
				String _3D2 = readCell(sheet.getRow(25).getCell(2));

				ExcelDataDto excelDto = new ExcelDataDto(district, model, input_date, postal, address, tel,
						questionnaire_date, company, division, responsible, business_traveler, kiban, _1C1, _1E1, _1G1,
						_1I1, _1K1, _1B2, _2C1, _2E1, _2G1, _2B2, _3B1, _3E1, _3D2);

				excelDataList.add(excelDto);

				/*
				 * switch (cell.getCellType()) { case NUMERIC:
				 * System.out.println(cell.getNumericCellValue()); break; case STRING:
				 * System.out.println(cell.getStringCellValue()); break; case FORMULA:
				 * System.out.println(getStringFormulaValue(cell)); break; case BLANK:
				 * System.out.println(getStringRangeValue(cell)); break; default:
				 * System.out.println("cellType=" + cell.getCellType()); break; }
				 */
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
