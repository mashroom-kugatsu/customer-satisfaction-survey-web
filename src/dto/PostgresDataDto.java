package dto;

import java.sql.Timestamp;
import java.util.Date;

public class PostgresDataDto {

	private int id;
	private int serial;
	private String old_discount;

	public PostgresDataDto() {
	}

	public PostgresDataDto(int id, int serial, String old_discount) {
		this.id = id;
		this.serial = serial;
		this.old_discount = old_discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getOld_discount() {
		return old_discount;
	}

	public void setOld_discount(String old_discount) {
		this.old_discount = old_discount;
	}

}
