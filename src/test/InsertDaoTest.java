package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dto.InsertDataDto;
import model.GetInsertDataLogic;

public class InsertDaoTest {

	public static void main(String[] args) throws IOException {
		final String JDBC_URL = "jdbc:postgresql://localhost/javasample";
		final String DB_USER = "postgres";
		final String DB_PASS = "postgres";

		// データベース接続
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			GetInsertDataLogic getInsertDataLogic = new GetInsertDataLogic();
			List<InsertDataDto> insertDataList = getInsertDataLogic.getInsertDataList();
			InsertDataDto insertDataDto = insertDataList.get(0);

			String sql = "insert into discount_information_s values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ;";
			PreparedStatement pStmt_d = conn.prepareStatement(sql);

			pStmt_d.setInt(1, insertDataDto.getId()+1);
			pStmt_d.setString(2, insertDataDto.getDistrict());
			pStmt_d.setString(3, insertDataDto.getModel());
			pStmt_d.setTimestamp(4, insertDataDto.getInput_date());
			pStmt_d.setString(5, insertDataDto.getSerial());
			pStmt_d.setString(6, insertDataDto.getNo_discount());
			pStmt_d.setTimestamp(7, insertDataDto.getPrint_date());
			pStmt_d.setTimestamp(8, insertDataDto.getUse_date());
			pStmt_d.setString(9, insertDataDto.getPostal());
			pStmt_d.setString(10, insertDataDto.getAddress());
			pStmt_d.setString(11, insertDataDto.getTel());
			pStmt_d.setString(12, insertDataDto.getOld_discount());
			pStmt_d.setString(13, insertDataDto.getDel_flg());
			pStmt_d.setString(14, insertDataDto.getEdited());
			
			pStmt_d.executeUpdate();

			sql = "insert into questionnaire_data_s values (?, ?, ?, ?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?, 	?) ;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			
			pStmt.setInt(1, insertDataDto.getId()+1);
			pStmt.setTimestamp(2, insertDataDto.getQuestionnaire_date());
			pStmt.setString(3, insertDataDto.getCompany());
			pStmt.setString(4, insertDataDto.getDivision());
			pStmt.setString(5, insertDataDto.getPost());
			pStmt.setString(6, insertDataDto.getResponsible());
			pStmt.setString(7, insertDataDto.getBusiness_traveler());
			pStmt.setString(8, insertDataDto.getKiban());
			pStmt.setString(9, insertDataDto.get_1C1());
			pStmt.setString(10, insertDataDto.get_1E1());
			pStmt.setString(11, insertDataDto.get_1G1());
			pStmt.setString(12, insertDataDto.get_1I1());
			pStmt.setString(13, insertDataDto.get_1K1());
			pStmt.setString(14, insertDataDto.get_1B2());
			pStmt.setString(15, insertDataDto.get_2C1());
			pStmt.setString(16, insertDataDto.get_2E1());
			pStmt.setString(17, insertDataDto.get_2G1());
			pStmt.setString(18, insertDataDto.get_2B2());
			pStmt.setString(19, insertDataDto.get_3B1());
			pStmt.setString(20, insertDataDto.get_3E1());
			pStmt.setString(21, insertDataDto.get_3D2());
			pStmt.setString(22, insertDataDto.getDel_flg());
			pStmt.setString(23, insertDataDto.getEdited());
			
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("正常に動作しました");

	}

}
