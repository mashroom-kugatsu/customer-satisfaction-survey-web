package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dto.InsertDataDto;
import model.GetInsertDataLogic;

public class InsertDao {

	private final String JDBC_URL = "jdbc:postgresql://localhost/javasample";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "postgres";

	public boolean insertExcute() throws IOException {

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
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, insertDataDto.getId());
			pStmt.setString(2, insertDataDto.getDistrict());
			pStmt.setString(3, insertDataDto.getModel());
			pStmt.setString(4, insertDataDto.getInput_date());
			pStmt.setString(5, insertDataDto.getSerial());
			pStmt.setString(6, insertDataDto.getNo_discount());
			pStmt.setString(7, insertDataDto.getPrint_date());
			pStmt.setString(8, insertDataDto.getUse_date());
			pStmt.setString(9, insertDataDto.getPostal());
			pStmt.setString(10, insertDataDto.getAddress());
			pStmt.setString(11, insertDataDto.getTel());
			pStmt.setString(12, insertDataDto.getOld_discount());
			pStmt.setString(13, insertDataDto.getDel_flg());
			pStmt.setString(14, insertDataDto.getEdited());

			int result = pStmt.executeUpdate();
			if (result != 0) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
