package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ExcelDataDao;
import dao.PostgresDataDao;
import dto.ExcelDataDto;
import dto.InsertDataDto;
import dto.PostgresDataDto;

public class GetDataLogicTest {

	public static void main(String[] args) throws IOException {

		PostgresDataDao psgrDao = new PostgresDataDao();
		List<PostgresDataDto> postgresDataList = psgrDao.getPostgresDataList();

		PostgresDataDto psgrDto = postgresDataList.get(0);

		System.out.println(psgrDto.getId());
		System.out.println(psgrDto.getInput_date());
		System.out.println(psgrDto.getSerial());
		System.out.println(psgrDto.getOld_discount());

		ExcelDataDao excelDao = new ExcelDataDao();
		List<ExcelDataDto> excelDataList = excelDao.getExcelDataList();

		ExcelDataDto excelDto = excelDataList.get(0);

		System.out.println(excelDto.getDistrict());
		System.out.println(excelDto.getQuestionnaire_date());

		int id = psgrDto.getId();
		String district = excelDto.getDistrict();
		String model = excelDto.getModel();
		String input_date = excelDto.getInput_date();
		String serial = psgrDto.getSerial();
		String no_discount = "1";
		String print_date = input_date;
		String use_date = "1970/1/1 0:00";
		String postal = excelDto.getPostal();
		String address = excelDto.getPostal();
		String tel = excelDto.getTel();
		String old_discount = psgrDto.getOld_discount();
		String del_flg = "0";
		String edited = "0";

		String questionnaire_date = excelDto.getQuestionnaire_date();
		String company = excelDto.getCompany();
		String division = excelDto.getDivision();
		String post = "";
		String responsible = excelDto.getResponsible();
		String business_traveler = excelDto.getBusiness_traveler();
		String kiban = excelDto.getKiban();
		String _1C1 = excelDto.get_1C1();
		String _1E1 = excelDto.get_1E1();
		String _1G1 = excelDto.get_1G1();
		String _1I1 = excelDto.get_1I1();
		String _1K1 = excelDto.get_1K1();
		String _1B2 = excelDto.get_1B2();
		String _2C1 = excelDto.get_2C1();
		String _2E1 = excelDto.get_2E1();
		String _2G1 = excelDto.get_2G1();
		String _2B2 = excelDto.get_2B2();
		String _3B1 = excelDto.get_3B1();
		String _3E1 = excelDto.get_3E1();
		String _3D2 = excelDto.get_3D2();
		
		InsertDataDto insertDataDto = new InsertDataDto(id, district, model, input_date, serial, no_discount, print_date,
				use_date, postal, address, tel, old_discount, del_flg, edited, questionnaire_date, company, division,
				post, responsible, business_traveler, kiban, _1C1, _1E1, _1G1, _1I1, _1K1, _1B2, _2C1, _2E1, _2G1, _2B2,
				_3B1, _3E1, _3D2);
		
		List<InsertDataDto> insertDataList = new ArrayList<>();
		insertDataList.add(insertDataDto);

	}

}
