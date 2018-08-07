package userType;

public enum UserType {

	UNDEF, CUSTREP, MANAGER, USERUSER, GOODUSER, SUPERUSER;
	
	public static boolean isEmployee(UserType type) {
		return type == CUSTREP || type == MANAGER;
	}

	public static UserType getType(String type) {
		if(type.equals("Super-User")) {
			return SUPERUSER;
		}
		
		if(type.equals("Good-User")) {
			return GOODUSER;
		}
		
		if(type.equals("User-User")) {
			return USERUSER;
		}
		
		if(type.equals("CustRep")) {
			return CUSTREP;
		}
		
		if(type.equals("Manager")) {
			return MANAGER;
		}
		
		return UNDEF;
		

	}
	
	
	

	public static String toString(UserType type) {
		String returnThis = "";
		switch(type) {
			case MANAGER:  returnThis = "Manager";
		        break;
			case CUSTREP:  returnThis = "CustRep";
		        break;
			case USERUSER:  returnThis = "User-User";
		        break;
			case GOODUSER:  returnThis = "Good-User";
		        break;
			case SUPERUSER:  returnThis = "Super-User";
		        break;
		}
		return returnThis;
	}
}
