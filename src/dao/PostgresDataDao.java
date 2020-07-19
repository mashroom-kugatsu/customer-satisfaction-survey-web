package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dto.PostgresDataDto;

public class PostgresDataDao {

	private final String JDBC_URL = "jdbc:postgresql://localhost/javasample";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "postgres";

	List<PostgresDataDto> postgresDataList = null;

	// レコードを取得してリストに格納するメソッド
	public List<PostgresDataDto> getPostgresDataList() {
		postgresDataList = new ArrayList<>();

		// データベース接続
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文の準備

			String sql = "select id, input_date, serial, old_discount from discount_information_s \r\n"
					+ "where to_char(input_date, 'yyyy-mm-dd') = to_char(current_date, 'yyyy-mm-dd')\r\n"
					+ "order by id desc limit 1";

			// SQL文確認
			System.out.println("---SQL文---");
			System.out.println(sql);
			System.out.println("---SQL文---");

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECTの実行
			ResultSet rs = pStmt.executeQuery();

			// SELECTの結果をArrayListに格納
			while (rs.next()) {

				int id = rs.getInt("id");
				String input_date = rs.getString("input_date");
				String serial = rs.getString("serial");
				String old_discount = rs.getString("old_discount");

				PostgresDataDto dto = new PostgresDataDto(id, input_date, serial, old_discount);

				postgresDataList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		if (postgresDataList.size() == 0) {
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

				// SELECT文の準備

				String sql = "select id, input_date, serial, old_discount from discount_information_s \r\n"
						+ "order by id desc limit 1";

				// SQL文確認
				System.out.println("---SQL文---");
				System.out.println(sql);
				System.out.println("---SQL文---");

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SELECTの実行
				ResultSet rs = pStmt.executeQuery();

				// SELECTの結果をArrayListに格納
				while (rs.next()) {

					int id = rs.getInt("id");
					String input_date = rs.getString("input_date");
					String serial = rs.getString("serial");
					String old_discount = rs.getString("old_discount");

					PostgresDataDto dto = new PostgresDataDto(id, input_date, serial, old_discount);

					postgresDataList.add(dto);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
		return postgresDataList;
	}

}
