package model;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
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

	public List<InsertDataDto> getInsertDataList() throws IOException {

		PostgresDataDao psgrDao = new PostgresDataDao();
		List<PostgresDataDto> postgresDataList = psgrDao.getPostgresDataList();
		
		ExcelDataDao excelDao = new ExcelDataDao();
		List<ExcelDataDto> excelDataList = excelDao.getExcelDataList();
		
		int i =0;
		int id = postgresDataList.get(i).getId() ;
		//String input_date = postgresDataList.get(i).getInput_date(); //必要か見なし
		String serial = postgresDataList.get(i).getSerial();
		
		String old_discount = postgresDataList.get(i).getOld_discount();
		
		String district = excelDataList.get(i).getDistrict();
		String model = excelDataList.get(i).getModel();
		String input_date_ex = excelDataList.get(i).getInput_date();
					
		Timestamp input_date = Timestamp.valueOf(input_date_ex);
				
		String postal = excelDataList.get(i).getPostal();
		String address = excelDataList.get(i).getAddress();
		String tel =  excelDataList.get(i).getTel();
		
		String questionnaire_date_ex = (excelDataList.get(i).getQuestionnaire_date() + " " + "00:00:00").replace("/", "-");
		System.out.println(questionnaire_date_ex);
		 
		Timestamp questionnaire_date = Timestamp.valueOf(questionnaire_date_ex);
		
		String company = excelDataList.get(i).getCompany();
		String division = excelDataList.get(i).getDivision();
		String responsible = excelDataList.get(i).getResponsible();
		String business_traveler = excelDataList.get(i).getBusiness_traveler();
		String kiban = excelDataList.get(i).getKiban();
		String _1C1 = excelDataList.get(i).get_1C1();
		String _1E1 = excelDataList.get(i).get_1E1();
		String _1G1 = excelDataList.get(i).get_1G1();
		String _1I1 = excelDataList.get(i).get_1I1();
		String _1K1 = excelDataList.get(i).get_1K1();
		String _1B2 = excelDataList.get(i).get_1B2();
		String _2C1 = excelDataList.get(i).get_2C1();
		String _2E1 = excelDataList.get(i).get_2E1();
		String _2G1 = excelDataList.get(i).get_2G1();
		String _2B2 = excelDataList.get(i).get_2B2();
		String _3B1 = excelDataList.get(i).get_3B1();
		String _3E1 = excelDataList.get(i).get_3E1();
		String _3D2 = excelDataList.get(i).get_3D2();
		
		String post = "";
		String no_discount = "0";
		Timestamp print_date = input_date;
		Timestamp use_date = input_date;
			
		String del_flg = "0";
		String edited = "0";
		
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		String old_discount_check = "S" + dateFormat.format(date) + "-" + serial;

		if(old_discount.equals(old_discount_check)){
			serial = Integer.toString(Integer.parseInt(serial) + 1);
			old_discount =  "S" + dateFormat.format(date) + "-" + serial;
		}else {
			old_discount =  "S" + dateFormat.format(date) + "-" + serial;
		}; 
		System.out.println("代入2" + old_discount);
		System.out.println("代入2" + serial);

		InsertDataDto insertDataDto = new InsertDataDto(id, district, model, input_date, serial, no_discount,
				print_date, use_date, postal, address, tel, old_discount, del_flg, edited, questionnaire_date, company,
				division, post, responsible, business_traveler, kiban, _1C1, _1E1, _1G1, _1I1, _1K1, _1B2, _2C1, _2E1,
				_2G1, _2B2, _3B1, _3E1, _3D2);

		List<InsertDataDto> insertDataList = new ArrayList<>();
		insertDataList.add(insertDataDto);

		return insertDataList;
	}
}
