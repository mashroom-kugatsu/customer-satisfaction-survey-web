package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dto.InsertDataDto;
import model.GetInsertDataLogic;

public class InsertDataDao {

	private final String JDBC_URL = "jdbc:postgresql://localhost/javasample";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "postgres";

	public boolean insertExcute(String uploadFilePath) throws IOException {

		// データベース接続
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			GetInsertDataLogic getInsertDataLogic = new GetInsertDataLogic();
			List<InsertDataDto> insertDataList = getInsertDataLogic.getInsertDataList(uploadFilePath);
			InsertDataDto insertDataDto = insertDataList.get(0);

			String sql_discount_information = "insert into discount_information_test values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ;";
			PreparedStatement pStmt_d = conn.prepareStatement(sql_discount_information);

			pStmt_d.setInt(1, insertDataDto.getId() + 1);
			pStmt_d.setString(2, insertDataDto.getDistrict());
			pStmt_d.setString(3, insertDataDto.getModel());
			pStmt_d.setTimestamp(4, insertDataDto.getInput_date());
			pStmt_d.setInt(5, insertDataDto.getSerial());
			pStmt_d.setString(6, insertDataDto.getNo_discount());
			pStmt_d.setTimestamp(7, insertDataDto.getPrint_date());
			pStmt_d.setTimestamp(8, insertDataDto.getUse_date());
			pStmt_d.setString(9, insertDataDto.getPostal());
			pStmt_d.setString(10, insertDataDto.getAddress());
			pStmt_d.setString(11, insertDataDto.getTel());
			pStmt_d.setString(12, insertDataDto.getOld_discount());
			pStmt_d.setInt(13, insertDataDto.getDel_flg());
			pStmt_d.setInt(14, insertDataDto.getEdited());

			int result_d = pStmt_d.executeUpdate();

			String sql_questionnaite_data = "insert into questionnaire_data_test values "
					+ "(?, ?, ?, ?, ?, ?, 	?, 	?, 	?, 	?, 	"
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement pStmt_q = conn.prepareStatement(sql_questionnaite_data);

			pStmt_q.setInt(1, insertDataDto.getId() + 1);
			pStmt_q.setTimestamp(2, insertDataDto.getQuestionnaire_date());
			pStmt_q.setString(3, insertDataDto.getCompany());
			pStmt_q.setString(4, insertDataDto.getDivision());
			pStmt_q.setString(5, insertDataDto.getPost());
			pStmt_q.setString(6, insertDataDto.getResponsible());
			pStmt_q.setString(7, insertDataDto.getBusiness_team());
			pStmt_q.setString(8, insertDataDto.getBusiness_traveler());
			pStmt_q.setString(9, insertDataDto.getKiban());
			pStmt_q.setString(10, insertDataDto.get_1C1());
			pStmt_q.setString(11, insertDataDto.get_1E1());
			pStmt_q.setString(12, insertDataDto.get_1G1());
			pStmt_q.setString(13, insertDataDto.get_1I1());
			pStmt_q.setString(14, insertDataDto.get_1K1());
			pStmt_q.setString(15, insertDataDto.get_1B2());
			pStmt_q.setString(16, insertDataDto.get_2C1());
			pStmt_q.setString(17, insertDataDto.get_2E1());
			pStmt_q.setString(18, insertDataDto.get_2G1());
			pStmt_q.setString(19, insertDataDto.get_2B2());
			pStmt_q.setString(20, insertDataDto.get_3B1());
			pStmt_q.setString(21, insertDataDto.get_3E1());
			pStmt_q.setString(22, insertDataDto.get_3D2());
			pStmt_q.setString(23, insertDataDto.get_4B1());
			pStmt_q.setString(24, insertDataDto.get_4E1());
			pStmt_q.setString(25, insertDataDto.get_4G1());
			pStmt_q.setString(26, insertDataDto.get_4D2());
			pStmt_q.setString(27, insertDataDto.get_4D3());
			pStmt_q.setString(28, insertDataDto.get_4D4());
			pStmt_q.setString(29, insertDataDto.get_5B1());
			pStmt_q.setString(30, insertDataDto.get_5E1());
			pStmt_q.setString(31, insertDataDto.get_5C2());
			pStmt_q.setString(32, insertDataDto.get_5E2());
			pStmt_q.setString(33, insertDataDto.get_5G2());
			pStmt_q.setString(34, insertDataDto.get_5I2());
			pStmt_q.setString(35, insertDataDto.get_5K2());
			pStmt_q.setString(36, insertDataDto.get_5B4());
			pStmt_q.setString(37, insertDataDto.get_5C3());
			pStmt_q.setString(38, insertDataDto.get_5E3());
			pStmt_q.setString(39, insertDataDto.get_5G3());
			pStmt_q.setString(40, insertDataDto.get_5I3());
			pStmt_q.setString(41, insertDataDto.get_5K3());
			pStmt_q.setString(42, insertDataDto.get_5B5());
			pStmt_q.setString(43, insertDataDto.get_6A1());
			pStmt_q.setString(44, insertDataDto.get_7A1());
			pStmt_q.setInt(45, insertDataDto.getDel_flg());
			pStmt_q.setInt(46, insertDataDto.getEdited());
			pStmt_q.setString(47, insertDataDto.getCustomer_code());

			int result_q = pStmt_q.executeUpdate();
			
			if(!(result_d ==1 && result_q == 1)) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
