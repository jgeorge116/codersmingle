package object_classes;

public class Likes {
	String liker;
	String likee;
	String date;

	public Likes(String liker, String likee, String date) {
		this.liker = liker;
		this.likee = likee;
		this.date = date;
	}

	public String getLiker() {
		return liker;
	}

	public void setLiker(String liker) {
		this.liker = liker;
	}

	public String getLikee() {
		return likee;
	}

	public void setLikee(String likee) {
		this.likee = likee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
