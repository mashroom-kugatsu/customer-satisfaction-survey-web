package dto;

import java.sql.Timestamp;
import java.util.Date;

public class PostgresDataDto {

	private int id;
	private String input_date;
	private String serial;
	private String old_discount;

	public PostgresDataDto() {
	}

	public PostgresDataDto(int id, String input_date, String serial, String old_discount) {
		this.id = id;
		this.input_date = input_date;
		this.serial = serial;
		this.old_discount = old_discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInput_date() {
		return input_date;
	}

	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getOld_discount() {
		return old_discount;
	}

	public void setOld_discount(String old_discount) {
		this.old_discount = old_discount;
	}

}
