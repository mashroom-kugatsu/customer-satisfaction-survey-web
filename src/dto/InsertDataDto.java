package dto;

import java.sql.Timestamp;

public class InsertDataDto {

	private int id;
	private String district;
	private String model;
	private Timestamp input_date;
	private int serial;
	private String no_discount;
	private Timestamp print_date;
	private Timestamp use_date;
	private String postal;
	private String address;
	private String tel;
	private String old_discount;
	private int del_flg;
	private int edited;

	private Timestamp questionnaire_date;
	private String company;
	private String division;
	private String post;
	private String responsible;
	private String business_team;
	private String business_traveler;
	private String kiban;
	private String _1C1;
	private String _1E1;
	private String _1G1;
	private String _1I1;
	private String _1K1;
	private String _1B2;
	private String _2C1;
	private String _2E1;
	private String _2G1;
	private String _2B2;
	private String _3B1;
	private String _3E1;
	private String _3D2;
	private String _4B1;
	private String _4E1;
	private String _4G1;
	private String _4D2;
	private String _4D3;
	private String _4D4;
	private String _5B1;
	private String _5E1;
	private String _5C2;
	private String _5E2;
	private String _5G2;
	private String _5I2;
	private String _5K2;
	private String _5B4;
	private String _5C3;
	private String _5E3;
	private String _5G3;
	private String _5I3;
	private String _5K3;
	private String _5B5;
	private String _6A1;
	private String _7A1;
	private String customer_code;

	public InsertDataDto() {}
	
	public InsertDataDto(int id, String district, String model, Timestamp input_date, int serial, String no_discount,
			Timestamp print_date, Timestamp use_date, String postal, String address, String tel, String old_discount,
			int del_flg, int edited, Timestamp questionnaire_date, String company, String division, String post,
			String responsible, String business_team, String business_traveler, String kiban, String _1C1, String _1E1,
			String _1G1, String _1I1, String _1K1, String _1B2, String _2C1, String _2E1, String _2G1, String _2B2,
			String _3B1, String _3E1, String _3D2, String _4B1, String _4E1, String _4G1, String _4D2, String _4D3,
			String _4D4, String _5B1, String _5E1, String _5C2, String _5E2, String _5G2, String _5I2, String _5K2,
			String _5B4, String _5C3, String _5E3, String _5G3, String _5I3, String _5K3, String _5B5, String _6A1,
			String _7A1, String customer_code) {

		this.id = id;
		this.district = district;
		this.model = model;
		this.input_date = input_date;
		this.serial = serial;
		this.no_discount = no_discount;
		this.print_date = print_date;
		this.use_date = use_date;
		this.postal = postal;
		this.address = address;
		this.tel = tel;
		this.old_discount = old_discount;
		this.del_flg = del_flg;
		this.edited = edited;
		this.questionnaire_date = questionnaire_date;
		this.company = company;
		this.division = division;
		this.post = post;
		this.responsible = responsible;
		this.business_team = business_team;
		this.business_traveler = business_traveler;
		this.kiban = kiban;
		this._1C1 = _1C1;
		this._1E1 = _1E1;
		this._1G1 = _1G1;
		this._1I1 = _1I1;
		this._1K1 = _1K1;
		this._1B2 = _1B2;
		this._2C1 = _2C1;
		this._2E1 = _2E1;
		this._2G1 = _2G1;
		this._2B2 = _2B2;
		this._3B1 = _3B1;
		this._3E1 = _3E1;
		this._3D2 = _3D2;
		this._4B1 = _4B1;
		this._4E1 = _4E1;
		this._4G1 = _4G1;
		this._4D2 = _4D2;
		this._4D3 = _4D3;
		this._4D4 = _4D4;
		this._5B1 = _5B1;
		this._5E1 = _5E1;
		this._5C2 = _5C2;
		this._5E2 = _5E2;
		this._5G2 = _5G2;
		this._5I2 = _5I2;
		this._5K2 = _5K2;
		this._5B4 = _5B4;
		this._5C3 = _5C3;
		this._5E3 = _5E3;
		this._5G3 = _5G3;
		this._5I3 = _5I3;
		this._5K3 = _5K3;
		this._5B5 = _5B5;
		this._6A1 = _6A1;
		this._7A1 = _7A1;
		this.customer_code = customer_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Timestamp getInput_date() {
		return input_date;
	}

	public void setInput_date(Timestamp input_date) {
		this.input_date = input_date;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getNo_discount() {
		return no_discount;
	}

	public void setNo_discount(String no_discount) {
		this.no_discount = no_discount;
	}

	public Timestamp getPrint_date() {
		return print_date;
	}

	public void setPrint_date(Timestamp print_date) {
		this.print_date = print_date;
	}

	public Timestamp getUse_date() {
		return use_date;
	}

	public void setUse_date(Timestamp use_date) {
		this.use_date = use_date;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOld_discount() {
		return old_discount;
	}

	public void setOld_discount(String old_discount) {
		this.old_discount = old_discount;
	}

	public int getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(int del_flg) {
		this.del_flg = del_flg;
	}

	public int getEdited() {
		return edited;
	}

	public void setEdited(int edited) {
		this.edited = edited;
	}

	public Timestamp getQuestionnaire_date() {
		return questionnaire_date;
	}

	public void setQuestionnaire_date(Timestamp questionnaire_date) {
		this.questionnaire_date = questionnaire_date;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getBusiness_team() {
		return business_team;
	}

	public void setBusiness_team(String business_team) {
		this.business_team = business_team;
	}

	public String getBusiness_traveler() {
		return business_traveler;
	}

	public void setBusiness_traveler(String business_traveler) {
		this.business_traveler = business_traveler;
	}

	public String getKiban() {
		return kiban;
	}

	public void setKiban(String kiban) {
		this.kiban = kiban;
	}

	public String get_1C1() {
		return _1C1;
	}

	public void set_1C1(String _1C1) {
		this._1C1 = _1C1;
	}

	public String get_1E1() {
		return _1E1;
	}

	public void set_1E1(String _1E1) {
		this._1E1 = _1E1;
	}

	public String get_1G1() {
		return _1G1;
	}

	public void set_1G1(String _1G1) {
		this._1G1 = _1G1;
	}

	public String get_1I1() {
		return _1I1;
	}

	public void set_1I1(String _1I1) {
		this._1I1 = _1I1;
	}

	public String get_1K1() {
		return _1K1;
	}

	public void set_1K1(String _1k1) {
		_1K1 = _1k1;
	}

	public String get_1B2() {
		return _1B2;
	}

	public void set_1B2(String _1B2) {
		this._1B2 = _1B2;
	}

	public String get_2C1() {
		return _2C1;
	}

	public void set_2C1(String _2C1) {
		this._2C1 = _2C1;
	}

	public String get_2E1() {
		return _2E1;
	}

	public void set_2E1(String _2E1) {
		this._2E1 = _2E1;
	}

	public String get_2G1() {
		return _2G1;
	}

	public void set_2G1(String _2G1) {
		this._2G1 = _2G1;
	}

	public String get_2B2() {
		return _2B2;
	}

	public void set_2B2(String _2B2) {
		this._2B2 = _2B2;
	}

	public String get_3B1() {
		return _3B1;
	}

	public void set_3B1(String _3B1) {
		this._3B1 = _3B1;
	}

	public String get_3E1() {
		return _3E1;
	}

	public void set_3E1(String _3E1) {
		this._3E1 = _3E1;
	}

	public String get_3D2() {
		return _3D2;
	}

	public void set_3D2(String _3D2) {
		this._3D2 = _3D2;
	}

	public String get_4B1() {
		return _4B1;
	}

	public void set_4B1(String _4B1) {
		this._4B1 = _4B1;
	}

	public String get_4E1() {
		return _4E1;
	}

	public void set_4E1(String _4E1) {
		this._4E1 = _4E1;
	}

	public String get_4G1() {
		return _4G1;
	}

	public void set_4G1(String _4G1) {
		this._4G1 = _4G1;
	}

	public String get_4D2() {
		return _4D2;
	}

	public void set_4D2(String _4D2) {
		this._4D2 = _4D2;
	}

	public String get_4D3() {
		return _4D3;
	}

	public void set_4D3(String _4D3) {
		this._4D3 = _4D3;
	}

	public String get_4D4() {
		return _4D4;
	}

	public void set_4D4(String _4D4) {
		this._4D4 = _4D4;
	}

	public String get_5B1() {
		return _5B1;
	}

	public void set_5B1(String _5B1) {
		this._5B1 = _5B1;
	}

	public String get_5E1() {
		return _5E1;
	}

	public void set_5E1(String _5E1) {
		this._5E1 = _5E1;
	}

	public String get_5C2() {
		return _5C2;
	}

	public void set_5C2(String _5C2) {
		this._5C2 = _5C2;
	}

	public String get_5E2() {
		return _5E2;
	}

	public void set_5E2(String _5E2) {
		this._5E2 = _5E2;
	}

	public String get_5G2() {
		return _5G2;
	}

	public void set_5G2(String _5G2) {
		this._5G2 = _5G2;
	}

	public String get_5I2() {
		return _5I2;
	}

	public void set_5I2(String _5I2) {
		this._5I2 = _5I2;
	}

	public String get_5K2() {
		return _5K2;
	}

	public void set_5K2(String _5K2) {
		this._5K2 = _5K2;
	}

	public String get_5B4() {
		return _5B4;
	}

	public void set_5B4(String _5B4) {
		this._5B4 = _5B4;
	}

	public String get_5C3() {
		return _5C3;
	}

	public void set_5C3(String _5C3) {
		this._5C3 = _5C3;
	}

	public String get_5E3() {
		return _5E3;
	}

	public void set_5E3(String _5E3) {
		this._5E3 = _5E3;
	}

	public String get_5G3() {
		return _5G3;
	}

	public void set_5G3(String _5G3) {
		this._5G3 = _5G3;
	}

	public String get_5I3() {
		return _5I3;
	}

	public void set_5I3(String _5I3) {
		this._5I3 = _5I3;
	}

	public String get_5K3() {
		return _5K3;
	}

	public void set_5K3(String _5K3) {
		this._5K3 = _5K3;
	}

	public String get_5B5() {
		return _5B5;
	}

	public void set_5B5(String _5B5) {
		this._5B5 = _5B5;
	}

	public String get_6A1() {
		return _6A1;
	}

	public void set_6A1(String _6A1) {
		this._6A1 = _6A1;
	}

	public String get_7A1() {
		return _7A1;
	}

	public void set_7A1(String _7A1) {
		this._7A1 = _7A1;
	}

	public String getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}

}
