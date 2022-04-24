package Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData 
{
	@JsonProperty("firstname") private String firstname;
	@JsonProperty("lastname") private String lastname;
	@JsonProperty("salary") private String salary;
	@JsonProperty("gender") private String gender;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "UserData [firstname=" + firstname + ", lastname=" + lastname + ", salary=" + salary + ", gender="
				+ gender + "]";
	}
	public UserData(String firstname, String lastname, String salary, String gender) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
		this.gender = gender;
	}
	
	
	
}

