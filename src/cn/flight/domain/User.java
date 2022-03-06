package cn.flight.domain;

public class User {
	private String destine_name;
	private String destine_id;
	private String destine_sex;
	private String destine_age;
	private int destine_phone;
	private String destine_address;
	private String flight_id;
	private int destine_count;
	private String destine_date;
	private String destine_status;
	public String getDestine_name() {
		return destine_name;
	}
	public void setDestine_name(String destine_name) {
		this.destine_name = destine_name;
	}
	public String getDestine_id() {
		return destine_id;
	}
	public void setDestine_id(String destine_id) {
		this.destine_id = destine_id;
	}
	public String getDestine_sex() {
		return destine_sex;
	}
	public void setDestine_sex(String destine_sex) {
		this.destine_sex = destine_sex;
	}
	public String getDestine_age() {
		return destine_age;
	}
	public void setDestine_age(String destine_age) {
		this.destine_age = destine_age;
	}
	public int getDestine_phone() {
		return destine_phone;
	}
	public void setDestine_phone(int destine_phone) {
		this.destine_phone = destine_phone;
	}
	public String getDestine_address() {
		return destine_address;
	}
	public void setDestine_address(String destine_address) {
		this.destine_address = destine_address;
	}
	public String getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}
	public int getDestine_count() {
		return destine_count;
	}
	public void setDestine_count(int destine_count) {
		this.destine_count = destine_count;
	}
	public String getDestine_date() {
		return destine_date;
	}
	public void setDestine_date(String destine_date) {
		this.destine_date = destine_date;
	}
	public String getDestine_status() {
		return destine_status;
	}
	public void setDestine_status(String destine_status) {
		this.destine_status = destine_status;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String destine_name, String destine_id, String destine_sex,
			String destine_age, int destine_phone, String destine_address,
			String flight_id, int destine_count, String destine_date,
			String destine_status) {
		super();
		this.destine_name = destine_name;
		this.destine_id = destine_id;
		this.destine_sex = destine_sex;
		this.destine_age = destine_age;
		this.destine_phone = destine_phone;
		this.destine_address = destine_address;
		this.flight_id = flight_id;
		this.destine_count = destine_count;
		this.destine_date = destine_date;
		this.destine_status = destine_status;
	}
	@Override
	public String toString() {
		return "User [destine_name=" + destine_name + ", destine_id="
				+ destine_id + ", destine_sex=" + destine_sex
				+ ", destine_age=" + destine_age + ", destine_phone="
				+ destine_phone + ", destine_address=" + destine_address
				+ ", flight_id=" + flight_id + ", destine_count="
				+ destine_count + ", destine_date=" + destine_date
				+ ", destine_status=" + destine_status + "]";
	}
	
	
	

}
