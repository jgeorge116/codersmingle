package object_classes;

public class Profile {

	String profileID;
	String ownerSSN;
	int datingAgeRangeStart;
	int datingAgeRangeEnd;
	int datingGeoRange;
	String M_F;
	String hobbies;
	Double height;
	int weight;
	String hairColor;
	String creationDate;
	String LastModDate;
	String geoLocation;
	int age;

	public Profile(String profileID, String ownerSSN, int datingAgeRangeStart, int datingAgeRangeEnd,
			int datingGeoRange, String m_F, String hobbies, Double height, int weight, String hairColor,
			String creationDate, String lastModDate, int age) {
		this.profileID = profileID;
		this.ownerSSN = ownerSSN;
		this.datingAgeRangeStart = datingAgeRangeStart;
		this.datingAgeRangeEnd = datingAgeRangeEnd;
		this.datingGeoRange = datingGeoRange;
		M_F = m_F;
		this.hobbies = hobbies;
		this.height = height;
		this.weight = weight;
		this.hairColor = hairColor;
		this.creationDate = creationDate;
		LastModDate = lastModDate;
		this.age = age;
	}

	
	
	public String getGeoLocation() {
		return geoLocation;
	}



	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}



	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public String getOwnerSSN() {
		return ownerSSN;
	}

	public void setOwnerSSN(String ownerSSN) {
		this.ownerSSN = ownerSSN;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDatingAgeRangeStart() {
		return datingAgeRangeStart;
	}

	public void setDatingAgeRangeStart(int datingAgeRangeStart) {
		this.datingAgeRangeStart = datingAgeRangeStart;
	}

	public int getDatingAgeRangeEnd() {
		return datingAgeRangeEnd;
	}

	public void setDatingAgeRangeEnd(int datingAgeRangeEnd) {
		this.datingAgeRangeEnd = datingAgeRangeEnd;
	}

	public int getDatingGeoRange() {
		return datingGeoRange;
	}

	public void setDatingGeoRange(int datingGeoRange) {
		this.datingGeoRange = datingGeoRange;
	}

	public String getM_F() {
		return M_F;
	}

	public void setM_F(String m_F) {
		M_F = m_F;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModDate() {
		return LastModDate;
	}

	public void setLastModDate(String lastModDate) {
		LastModDate = lastModDate;
	}

}
