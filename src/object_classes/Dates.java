package object_classes;

public class Dates {
	String profile1;
	String profile2;
	String custRep;
	String date;
	String location;
	Double bookingFee;
	String comments;
	int user1rating;
	int user2Rating;
	String geoLocation;
	
	public Dates(String profile1, String profile2, String custRep, String date, String location, Double bookingFee,
			String comments, int user1rating, int user2Rating) {
		this.profile1 = profile1;
		this.profile2 = profile2;
		this.custRep = custRep;
		this.date = date;
		this.location = location;
		this.bookingFee = bookingFee;
		this.comments = comments;
		this.user1rating = user1rating;
		this.user2Rating = user2Rating;
		geoLocation = "";
	}

	
	
	public String getGeoLocation() {
		return geoLocation;
	}



	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}



	public String getProfile1() {
		return profile1;
	}

	public void setProfile1(String profile1) {
		this.profile1 = profile1;
	}

	public String getProfile2() {
		return profile2;
	}

	public void setProfile2(String profile2) {
		this.profile2 = profile2;
	}

	public String getCustRep() {
		return custRep;
	}

	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getBookingFee() {
		return bookingFee;
	}

	public void setBookingFee(Double bookingFee) {
		this.bookingFee = bookingFee;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getUser1rating() {
		return user1rating;
	}

	public void setUser1rating(int user1rating) {
		this.user1rating = user1rating;
	}

	public int getUser2Rating() {
		return user2Rating;
	}

	public void setUser2Rating(int user2Rating) {
		this.user2Rating = user2Rating;
	}

}
