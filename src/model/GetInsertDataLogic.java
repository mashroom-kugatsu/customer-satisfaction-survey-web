package model;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ExcelDataDao;
import dao.PostgresDataDao;
import dto.ExcelDataDto;
import dto.InsertDataDto;
import dto.PostgresDataDto;

public class GetInsertDataLogic {

	public List<InsertDataDto> getInsertDataList(String uploadFilePath) throws IOException {

		PostgresDataDao psgrDao = new PostgresDataDao();
		List<PostgresDataDto> postgresDataList = psgrDao.getPostgresDataList();

		ExcelDataDao excelDao = new ExcelDataDao();
		List<ExcelDataDto> excelDataList = excelDao.getExcelDataList(uploadFilePath);

		int i = 0;

		// discount_informationテーブル

		int id = postgresDataList.get(i).getId();
		String district = excelDataList.get(i).getDistrict();
		String model = excelDataList.get(i).getModel();

		String input_date_ex = excelDataList.get(i).getInput_date();
		Timestamp input_date = Timestamp.valueOf(input_date_ex);

		int serial = postgresDataList.get(i).getSerial();
		String no_discount = "0";
		Timestamp print_date = input_date;
		Timestamp use_date = input_date; // 修正する 1970-01-01 00:00:00
		String postal = excelDataList.get(i).getPostal();
		String address = excelDataList.get(i).getAddress();
		String tel = excelDataList.get(i).getTel();
		String old_discount = postgresDataList.get(i).getOld_discount();

		// 以下からテーブル変更

		String questionnaire_date_ex = excelDataList.get(i).getQuestionnaire_date();
		Timestamp questionnaire_date = Timestamp.valueOf(questionnaire_date_ex);

		String company = excelDataList.get(i).getCompany();
		String division = excelDataList.get(i).getDivision();
		String post = "";
		String responsible = excelDataList.get(i).getResponsible();
		String business_team = excelDataList.get(i).getBusiness_team();
		String business_traveler = excelDataList.get(i).getBusiness_traveler();
		String kiban = excelDataList.get(i).getKiban();

		String _1C1 = excelDataList.get(i).get_1C1();
		String _1E1 = excelDataList.get(i).get_1E1();
		String _1G1 = excelDataList.get(i).get_1G1();
		String _1I1 = excelDataList.get(i).get_1I1();
		String _1K1 = excelDataList.get(i).get_1K1();
		String _1B2 = excelDataList.get(i).get_1B2();
		if(_1B2.equals("記入無し")) {
			_1B2 = "";
		}
		String _2C1 = excelDataList.get(i).get_2C1();
		String _2E1 = excelDataList.get(i).get_2E1();
		String _2G1 = excelDataList.get(i).get_2G1();
		String _2B2 = excelDataList.get(i).get_2B2();
		if(_2B2.equals("記入無し")) {
			_2B2 = "";
		}
		String _3B1 = excelDataList.get(i).get_3B1();
		_3B1 = replaceText(_3B1);

		String _3E1 = excelDataList.get(i).get_3E1();
		String _3D2 = excelDataList.get(i).get_3D2();
		if(_3D2.equals("記入無し")) {
			_3D2 = "";
		}	
		String _4B1 = excelDataList.get(i).get_4B1();
		_4B1 = replaceText(_4B1);
		String _4E1 = excelDataList.get(i).get_4E1();
		_4E1 = replaceText(_4E1);
		String _4G1 = excelDataList.get(i).get_4G1();
		_4G1 = replaceText(_4G1);
		
		String _4D2 = excelDataList.get(i).get_4D2();
		String _4D3 = excelDataList.get(i).get_4D3();
		String _4D4 = excelDataList.get(i).get_4D4();
		String _5B1 = excelDataList.get(i).get_5B1();
		String _5E1 = excelDataList.get(i).get_5E1();
		String _5C2 = excelDataList.get(i).get_5C2();
		_5C2 = replaceText(_5C2);
		String _5E2 = excelDataList.get(i).get_5E2();
		_5E2 = replaceText(_5E2);
		String _5G2 = excelDataList.get(i).get_5G2();
		_5G2 = replaceText(_5G2);
		String _5I2 = excelDataList.get(i).get_5I2();
		_5I2 = replaceText(_5I2);
		String _5K2 = excelDataList.get(i).get_5K2();
		_5K2 = replaceText(_5K2);
		String _5B4 = excelDataList.get(i).get_5B4();
		String _5C3 = excelDataList.get(i).get_5C3();
		_5C3 = replaceText(_5C3);
		String _5E3 = excelDataList.get(i).get_5E3();
		_5E3 = replaceText(_5E3);
		String _5G3 = excelDataList.get(i).get_5G3();
		_5G3 = replaceText(_5G3);
		String _5I3 = excelDataList.get(i).get_5I3();
		_5I3 = replaceText(_5I3);
		String _5K3 = excelDataList.get(i).get_5K3();
		_5K3 = replaceText(_5K3);
		String _5B5 = excelDataList.get(i).get_5B5();
		
		String _6A1 = excelDataList.get(i).get_6A1();
		if(_6A1.equals("記入無し")) {
			_6A1 = "";
		}	
		
		String _7A1 = excelDataList.get(i).get_7A1();
		if(_7A1.equals("記入無し")) {
			_7A1 = "";
		}	
		
		int del_flg = 0;
		int edited = 0;
		String customer_code = "";

		// 割引券Noの重複チェック
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String old_discount_check = "S" + dateFormat.format(date) + "-" + serial;
		if (old_discount.equals(old_discount_check)) {
			serial +=1;
			old_discount = "S" + dateFormat.format(date) + "-" + serial;
		} else {
			old_discount = "S" + dateFormat.format(date) + "-" + serial;
		}

		InsertDataDto insertDataDto = new InsertDataDto(id, district, model, input_date, serial, no_discount,
				print_date, use_date, postal, address, tel, old_discount, del_flg, edited, questionnaire_date, company,
				division, post, responsible, business_team, business_traveler, kiban, _1C1, _1E1, _1G1, _1I1, _1K1,
				_1B2, _2C1, _2E1, _2G1, _2B2, _3B1, _3E1, _3D2, _4B1, _4E1, _4G1, _4D2, _4D3, _4D4, _5B1, _5E1, _5C2,
				_5E2, _5G2, _5I2, _5K2, _5B4, _5C3, _5E3, _5G3, _5I3, _5K3, _5B5, _6A1, _7A1, customer_code);

		List<InsertDataDto> insertDataList = new ArrayList<>();
		insertDataList.add(insertDataDto);
		
		return insertDataList;
	}
	
	public String replaceText(String insertText) {
		if(insertText.equals("ある")|| insertText.equals("〇")) {
			insertText = "1";
		}else {
			insertText = "0";
		}return insertText;
	}
	
} 
