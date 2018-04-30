package hello;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	private long id;
	private String name;
	private String email;
	private String birthdate;
	private String address;
	private String phone;

	public Employee(@JsonProperty("id") long id,
			@JsonProperty("name") String name,
			@JsonProperty("email") String email,
			@JsonProperty("birthdate") String birthdate,
			@JsonProperty("address") String address,
			@JsonProperty("phone") String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "id:" + id + ", " + "name:" + name + ", " + "email:" + email
				+ ", " + "birthdate:" + birthdate + ", " + "address:" + address
				+ ", " + "phone:" + phone + " ";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
