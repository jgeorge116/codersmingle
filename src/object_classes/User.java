package object_classes;
import userType.UserType;

public class User {
	String SSN;
	UserType type; // priority
	int rating;
	String dateOfLastAct;

	public User(String sSN, UserType pPP, int rating, String dateOfLastAct) {
		SSN = sSN;
		type = pPP;
		this.rating = rating;
		this.dateOfLastAct = dateOfLastAct;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public UserType getPPP() {
		return type;
	}

	public void setPPP(UserType temp) {
		type = temp;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDateOfLastAct() {
		return dateOfLastAct;
	}

	public void setDateOfLastAct(String dateOfLastAct) {
		this.dateOfLastAct = dateOfLastAct;
	}

}
