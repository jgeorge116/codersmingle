package object_classes;

public class SuggestedBy {
	Employee custRep;
	Profile profile1;
	Profile profile2;
	String Date_Time;

	public SuggestedBy(Employee custRep, Profile profile1, Profile profile2, String date_Time) {
		this.custRep = custRep;
		this.profile1 = profile1;
		this.profile2 = profile2;
		Date_Time = date_Time;
	}

	public Employee getCustRep() {
		return custRep;
	}

	public void setCustRep(Employee custRep) {
		this.custRep = custRep;
	}

	public Profile getProfile1() {
		return profile1;
	}

	public void setProfile1(Profile profile1) {
		this.profile1 = profile1;
	}

	public Profile getProfile2() {
		return profile2;
	}

	public void setProfile2(Profile profile2) {
		this.profile2 = profile2;
	}

	public String getDate_Time() {
		return Date_Time;
	}

	public void setDate_Time(String date_Time) {
		Date_Time = date_Time;
	}

}
