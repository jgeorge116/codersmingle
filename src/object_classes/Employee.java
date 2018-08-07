package object_classes;

import java.math.BigDecimal;

public class Employee {
	String SSN;
	String role;
	String startDate;
	int hourlyRate;

	public Employee(String sSN, String role, String startDate, int hourlyRate) {
		SSN = sSN;
		this.role = role;
		this.startDate = startDate;
		this.hourlyRate = hourlyRate;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
