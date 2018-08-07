package object_classes;

public class BlindDate {
	String profileA;
	String profileB;
	String profileC;
	String theDate;

	public BlindDate(String profileA, String profileB, String profileC, String theDate) {
		this.profileA = profileA;
		this.profileB = profileB;
		this.profileC = profileC;
		this.theDate = theDate;
	}

	public String getProfileA() {
		return profileA;
	}

	public void setProfileA(String profileA) {
		this.profileA = profileA;
	}

	public String getProfileB() {
		return profileB;
	}

	public void setProfileB(String profileB) {
		this.profileB = profileB;
	}

	public String getProfileC() {
		return profileC;
	}

	public void setProfileC(String profileC) {
		this.profileC = profileC;
	}

	public String getTheDate() {
		return theDate;
	}

	public void setTheDate(String theDate) {
		this.theDate = theDate;
	}

}
