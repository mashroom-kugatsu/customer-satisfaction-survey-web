package model;

import java.util.List;

import dao.PostgresDataDao;
import dto.PostgresDataDto;

public class GetDataLogic {
	
	public void getPostgresExcelData(){
		PostgresDataDao psgrDao = new PostgresDataDao();
		List<PostgresDataDto> postgresDataList = psgrDao.getPostgresDataList();
		
		for (int i = 0; i < postgresDataList.size(); i++) {
		      System.out.println(postgresDataList.get(i));
		    }
		
	}

}
