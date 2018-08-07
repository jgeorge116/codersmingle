package DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.sql.StatementEvent;

import object_classes.Account;
import object_classes.BlindDate;
import object_classes.Dates;
import object_classes.Employee;
import object_classes.Likes;
import object_classes.Person;
import object_classes.Profile;
import object_classes.User;
import userType.UserType;

public class DBTransactions {

	public static boolean validateUserCredentials(String username, String password) {
		DBConnection.initConnection();

		boolean isValid = false;
		String result = "";
		try {
			String queryString = "SELECT pe.SSN, pe.Password " + "FROM Profile pr, Person pe, Employee em "
					+ "WHERE (pr.OwnerSSN = pe.SSN AND pr.ProfileID = ?) " + "OR (em.SSN = ? AND em.SSN = pe.SSN);";
			PreparedStatement pstm = DBConnection.getConnection().prepareStatement(queryString);
			pstm.setString(1, username);
			pstm.setString(2, username);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				if (rs.getString("Password").equals(password)) {
					result += "Password Correct! " + username + " is now logged in!";
					isValid = true;
				} else {
					result += "Username/Password Incorrect!";
				}
			}
			
			rs.close();
			pstm.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (NullPointerException npe) {
			result += "Username doesn't exist!";

		}

		System.out.println(result);
		DBConnection.closeMainConnection();
		return isValid;
	}

	public static String getUserType(String username) {
		boolean isEmployee = false;
		String type = "";
		try {
			DBConnection.initConnection();
			String queryString = "SELECT u.SSN, u.PPP " + "FROM User u, Profile p " + "WHERE u.SSN = p.OwnerSSN AND "
					+ "p.ProfileID = ?;";
			PreparedStatement pstm = DBConnection.getConnection().prepareStatement(queryString);
			pstm.setString(1, username);
			ResultSet rs = pstm.executeQuery();
			

			if (!rs.next()) {
				isEmployee = true;
			} else {
				type = rs.getString("PPP");
			}
			
			pstm.close();
			rs.close();
			DBConnection.closeMainConnection();

		} catch (SQLException sqle) {

			
		}
		
		if(isEmployee) {
			try {
				DBConnection.initConnection();
				PreparedStatement pstm2;
				String secondQuery = "SELECT e.SSN, e.Role FROM Employee e WHERE e.SSN = ?;";
				pstm2 = DBConnection.getConnection().prepareStatement(secondQuery);
				pstm2.setString(1, username);
				ResultSet rs2 = pstm2.executeQuery();
				
				System.out.println("Code Reaches Here");
				if(rs2.next()) {
					type = rs2.getString("Role");
					System.out.println("Type: "+type);
				}
				
				pstm2.close();
				rs2.close();
				DBConnection.closeMainConnection();
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
		
		System.out.println("User Type: " + type);
		DBConnection.closeMainConnection();
		return type;
	}

	public static void addPerson(Person person) {
		try {
			DBConnection.initConnection();
			String sql = "Insert into Person(SSN, Password, FirstName, LastName, Street, City, State, Zipcode, Email, Telephone) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);

			statement.setString(1, person.getSSN());
			statement.setString(2, person.getPassword());
			statement.setString(3, person.getFirstName());
			statement.setString(4, person.getLastName());
			statement.setString(5, person.getStreet());
			statement.setString(6, person.getCity());
			statement.setString(7, person.getState());
			statement.setString(8, person.getZipcode());
			statement.setString(9, person.getEmail());
			statement.setString(10, person.getTelephone());
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addEmployee(Employee employee) {
		try {
			DBConnection.initConnection();
			String sql = "Insert into Employee(SSN, Role, StartDate, HourlyRate) values (?, ?, ?, ?);";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, employee.getSSN());
			statement.setString(2, employee.getRole());
			statement.setString(3, employee.getStartDate());
			statement.setInt(4, employee.getHourlyRate());
			statement.executeUpdate();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addUser(User user) {

		try {
			DBConnection.initConnection();
			String sql = "Insert into User(SSN, PPP, Rating, DateOfLastAct) values (?, ?, ?, ?);";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, user.getSSN());
			statement.setString(2, UserType.toString(user.getPPP()));
			statement.setInt(3, user.getRating());
			statement.setString(4, user.getDateOfLastAct());

			statement.executeUpdate();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addProfile(Profile pro) {
		try {
			DBConnection.initConnection();

			String sql = "Insert into Profile(ProfileID, OwnerSSN, DatingAgeRangeStart, DatingAgeRangeEnd, DatinGeoRange, M_F, Hobbies, Height, Weight, HairColor, CreationDate, LastModDate, Age) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, pro.getProfileID());
			statement.setString(2, pro.getOwnerSSN());
			statement.setInt(3, pro.getDatingAgeRangeStart());
			statement.setInt(4, pro.getDatingAgeRangeEnd());
			statement.setInt(5, pro.getDatingGeoRange());
			statement.setString(6, pro.getM_F());
			statement.setString(7, pro.getHobbies());
			statement.setDouble(8, pro.getHeight());
			statement.setInt(9, pro.getWeight());
			statement.setString(10, pro.getHairColor());
			statement.setString(11, pro.getCreationDate());
			statement.setString(12, pro.getLastModDate());
			statement.setInt(13, pro.getAge());
			statement.executeUpdate();
			
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addAccount(Account acc) {
		try {
			DBConnection.initConnection();

			String sql = "Insert into Account(OwnerSSN, CardNumber, AcctNum) values (?, ?, ?) ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, acc.getOwnerSSN());
			statement.setString(2, acc.getCardNumber());
			statement.setString(3, acc.getAcctNum());
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void editPerson(Person person) {

		try {
			DBConnection.initConnection();
			String sql = "Update Person set Password= ?, FirstName = ?, LastName =?, Street = ?, "
					+ "City = ?, State = ?, Zipcode = ?, Email=?, Telephone = ? where SSN = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);

			statement.setString(1, person.getPassword());
			statement.setString(2, person.getFirstName());
			statement.setString(3, person.getLastName());
			statement.setString(4, person.getStreet());
			statement.setString(5, person.getCity());
			statement.setString(6, person.getState());
			statement.setString(7, person.getZipcode());
			statement.setString(8, person.getEmail());
			statement.setString(9, person.getTelephone());
			statement.setString(10, person.getSSN());
			statement.executeUpdate();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void editDate(Dates date) {

		try {
			DBConnection.initConnection();
			String sql = "Update Date set CustRep = ?, Location = ?, BookingFee = ?, Comments = ?, User1Rating = ?, User2Rating = ?, GeoLocation = ? where Profile1 = ? AND Profile2 = ? AND Date_Time = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);

			statement.setString(1, date.getCustRep());
			statement.setString(2, date.getLocation());
			statement.setDouble(3, date.getBookingFee());
			statement.setString(4, date.getComments());
			statement.setInt(5, date.getUser1rating());
			statement.setInt(6, date.getUser2Rating());
			statement.setString(7, date.getGeoLocation());
			statement.setString(8, date.getProfile1());
			statement.setString(9, date.getProfile2());
			statement.setString(10, date.getDate());
			statement.executeUpdate();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void editAccount(Account acc) {
		try {
			DBConnection.initConnection();
			String sql = "Update Account set CardNumber=?, AcctNum = ? where OwnerSSN = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);

			statement.setString(1, acc.getCardNumber());
			statement.setString(2, acc.getAcctNum());
			statement.setString(3, acc.getOwnerSSN());
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void editProfile(Profile pro) {
		try {
			DBConnection.initConnection();
			String sql = "Update Profile set OwnerSSN = ?, DatingAgeRangeStart=?, DatingAgeRangeEnd = ?, DatinGeoRange= ?, M_F=?, Hobbies=?, Height=?, Weight= ?, HairColor=?, LastModDate=?, Age=?  where ProfileID = ? ;";
			// CreationDate shouldn't be modified
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);

			statement.setString(1, pro.getOwnerSSN());
			statement.setInt(2, pro.getDatingAgeRangeStart());
			statement.setInt(3, pro.getDatingAgeRangeEnd());
			statement.setInt(4, pro.getDatingGeoRange());
			statement.setString(5, pro.getM_F());
			statement.setString(6, pro.getHobbies());
			statement.setDouble(7, pro.getHeight());
			statement.setInt(8, pro.getWeight());
			statement.setString(9, pro.getHairColor());
			statement.setString(10, pro.getLastModDate());
			statement.setInt(11, pro.getAge());
			statement.setString(12, pro.getProfileID());
			statement.executeUpdate();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void editUser(User user) {
		try {
			DBConnection.initConnection();
			String sql = "Update User set PPP=?, Rating = ?, DateOfLastAct= ? where SSN = ? ;";
			//CreationDate shouldn't be modified
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			
			statement.setString(1, UserType.toString(user.getPPP()));
			statement.setInt(2, user.getRating());
			statement.setString(3, user.getDateOfLastAct());
			statement.setString(4, user.getSSN());
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void editEmployee(Employee emp) {
		try {
			DBConnection.initConnection();
			String sql = "Update Employee set Role=?, StartDate = ?, HourlyRate= ? where SSN = ? ;"; 
																									
			//CreationDate shouldn't be modified
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);

			statement.setString(1, emp.getRole());
			statement.setString(2, emp.getStartDate());
			statement.setInt(3, emp.getHourlyRate());
			statement.setString(4, emp.getSSN());
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deletePerson(Connection connect, String ssn) {

		try {
			DBConnection.initConnection();
			String sql = "Delete from Person where SSN = ?";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, ssn);
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteAccount(String ssn, String cardNum, String accNum) {
		try {
			DBConnection.initConnection();
			String sql = "Delete from Account where OwnerSSN = ? and CardNumber= ? and AcctNum=? ;"; /// all 3 are keys

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, ssn);
			statement.setString(2, cardNum);
			statement.setString(3, accNum);
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteProfile(String proID) {
		try {
			DBConnection.initConnection();
			String sql = "Delete from Profile where ProfileID = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, proID);
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setGeoLocation(String userID, String geoLocation) {
		try {
			DBConnection.initConnection();
			String sql = "UPDATE Profile SET GeoLocation = ? WHERE ProfileID = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, geoLocation);
			statement.setString(2, userID);
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void removeGeoLocation(String userID) {
		try {
			DBConnection.initConnection();
			String sql = "UPDATE Profile SET GeoLocation = NULL WHERE ProfileID = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, userID);
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteUser(String ssn) {
		try {
			DBConnection.initConnection();
			String sql = "Delete from User where SSN = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, ssn);
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteEmployee(String ssn) {

		try {
			DBConnection.initConnection();
			String sql = "Delete from Employee where SSN = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, ssn);
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Person getPerson(String ssn)  {
		Person returnThis = null;
		try {
			DBConnection.initConnection();

			String sql = "Select * FROM Person P WHERE P.SSN = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, ssn);
			ResultSet set = statement.executeQuery();

			if (set.next()) {
				String ssn_ = set.getString("SSN");
				String pw = set.getString("Password");
				String fn = set.getString("FirstName");
				String ln = set.getString("LastName");
				String st = set.getString("Street");
				String city = set.getString("City");
				String state = set.getString("State");
				String zip = set.getString("Zipcode");
				String email = set.getString("Email");
				String num = set.getString("Telephone");

				returnThis = new Person(ssn_, pw, fn, ln, st, city, state, zip, email, num);
			}
			
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnThis;
	}

	public static Account getAccount(String ssn, String cardNum, String accNum) {
		Account returnThis = null;
		try {
			DBConnection.initConnection();
			String sql = "Select A.OwnerSSN, A.CardNumber, A.AcctNum from Account A where A.OwnerSSN = ? and A.CardNumber=? and A.AcctNum=? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, ssn);
			statement.setString(2, cardNum);
			statement.setString(3, accNum);
			ResultSet set = statement.executeQuery();

			if (set.next()) {
				String ssn_ = set.getString("OwnerSSN");
				String cardnum = set.getString("CardNumber");
				String an = set.getString("AcctNum");

				returnThis = new Account(ssn_, cardnum, an);

			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnThis;
	}

	public static Profile getProfile(String proId) {
		Profile returnThis = null;
		try {
			DBConnection.initConnection();
			String sql = "Select * from Profile P where P.ProfileID = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, proId);
			ResultSet set = statement.executeQuery();

			if (set.next()) {
				String id = set.getString("ProfileID");
				String ssn = set.getString("OwnerSSN");
				int start = set.getInt("DatingAgeRangeStart");
				int end = set.getInt("DatingAgeRangeEnd");
				int geo = set.getInt("DatinGeoRange");
				String gender = set.getString("M_F");
				String hobbies = set.getString("Hobbies");
				double height = set.getDouble("Height");
				int weight = set.getInt("Weight");
				String hair = set.getString("HairColor");
				String create = set.getString("CreationDate");
				String mod = set.getString("LastModDate");
				int age = set.getInt("Age");
				String geoLocation = set.getString("GeoLocation");

				returnThis = new Profile(id, ssn, start, end, geo, gender, hobbies, height, weight, hair, create, mod,
						age);
				returnThis.setGeoLocation(geoLocation);

			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnThis;
	}

	public static User getUser(String ssn)  {
		User returnThis = null;
		try {
			DBConnection.initConnection();

			String sql = "Select U.SSN, U.PPP, U.Rating, U.DateOfLastAct from User U where U.SSN = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, ssn);
			ResultSet set = statement.executeQuery();

			if (set.next()) {
				String ssn_ = set.getString("SSN");
				String priority = set.getString("PPP");
				int rate = set.getInt("Rating");
				String lastact = set.getString("DateOfLastAct");
				
				returnThis = new User(ssn_, UserType.getType(priority), rate, lastact);

			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnThis;
	}

	public static Employee getEmployee(String ssn) {
		Employee returnThis = null;
		try {
			DBConnection.initConnection();
			String sql = "Select E.SSN, E.Role, E.StartDate, E.HourlyRate from Employee E where E.SSN = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, ssn);
			ResultSet set = statement.executeQuery();

			if (set.next()) {
				String ssn_ = set.getString("SSN");
				String role = set.getString("Role");
				String start = set.getString("StartDate");
				int rate = set.getInt("HourlyRate");

				returnThis = new Employee(ssn_, role, start, rate);

			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnThis;
	}

	public static boolean isValidUsername(String userID) {
		boolean isValid = false;

		try {
			DBConnection.initConnection();

			String sql = "SELECT * FROM Profile WHERE ProfileID = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, userID);
			ResultSet set = statement.executeQuery();
			if (!set.next()) {// if there is no results then the userID is unique.
				isValid = true;
			} else {
				isValid = false;
			}
			set.close();
			statement.close();


			DBConnection.closeMainConnection();
		} catch (Exception e) {

		}
		return isValid;
	}
	
	public static double getSalesReportBySpecifiedDates(String date1, String date2) {
		try {
			DBConnection.initConnection();
			String sql = "SELECT TRUNCATE(SUM(BookingFee), 2) AS Sales_Report FROM Date WHERE Date_Time >= ? and Date_Time<= ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, date1);
			statement.setString(2, date2);
			ResultSet set = statement.executeQuery();

			if (set.next()) {
				double total = set.getDouble("Sales_Report");
				return total;
			}
			set.close();
			statement.close();

			
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0.0;
	}
	
	public static double getSalesReportByCustomer(String customer) {
		try {
			DBConnection.initConnection();
			String sql = "SELECT TRUNCATE(SUM(BookingFee), 2) AS Sales_Report FROM Date WHERE Profile1 = ? OR Profile2= ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, customer);
			statement.setString(2, customer);
			ResultSet set = statement.executeQuery();

			if (set.next()) {
				double total = set.getDouble("Sales_Report");
				return total;
			}
			set.close();
			statement.close();

			
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0.0;
		
	}
	
	

	public static ArrayList<String> getAllUsers() {
		try {
			DBConnection.initConnection();
			ArrayList<String> allUsers = new ArrayList<>();
			String sql = "SELECT * FROM User ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String ssn_ = set.getString("SSN");
				String priority = set.getString("PPP");
				int rate = set.getInt("Rating");
				String lastact = set.getString("DateOfLastAct");
				String s = "";
				s = "SSN: " + ssn_ + " | priority: " + priority + " | Rating: " + rate + " | Last Active: " + lastact;
				allUsers.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return allUsers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Checks if the SSN isnt in the DB
	 */
	public static boolean uniqueSSN(String SSN) {
		boolean returnThis = false;
		
		try {
			DBConnection.initConnection();
			
			String sql = "SELECT * FROM Person WHERE SSN = ? ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, SSN);
			ResultSet set = statement.executeQuery();
			if(!set.next()) {//if it null this hasnt been added to the DB
				returnThis = true;
			}
			else {
				returnThis = false;
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
		}
		catch(SQLException e) {
			
		}
		
		return returnThis;
	}
	
	public static String removeDashes(String ssn) {
		for(int i = 0; i < ssn.length(); i++) {
			if(ssn.charAt(i) == '-') {
				ssn = ssn.substring(0,i) + ssn.substring(i+1);
			}
		}
		return ssn;
	}
	
	public static ArrayList<String> getCustRepsWithMostRevenue() {
		try {
			DBConnection.initConnection();
			ArrayList<String> custreps = new ArrayList<>();
			String sql = "SELECT CustRep, TRUNCATE(SUM(BookingFee), 2) AS Revenue FROM Date GROUP BY CustRep ORDER BY Revenue DESC LIMIT 5 ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String custRep = set.getString("CustRep");
				int cost = set.getInt("Revenue");
				String s = "";
				s = "Customer Rep: " + custRep + "Revenue: " + cost;
				custreps.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return custreps;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getUsersWithMostRevenue() {
		try {
			DBConnection.initConnection();
			ArrayList<String> users = new ArrayList<>();
			String sql = "SELECT OwnerSSN, TRUNCATE(SUM(BookingFee), 2) AS TotalProfit FROM Date, Profile WHERE Profile1= ProfileID OR Profile2 = ProfileID GROUP BY OwnerSSN ORDER BY TotalProfit DESC LIMIT 10 ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String owner = set.getString("OwnerSSN");
				int cost = set.getInt("TotalProfit");
				String s = "";
				s = "Owner: " + owner + "Profit: " + cost;
				users.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getMostActiveUsers() {
		try {
			DBConnection.initConnection();
			ArrayList<String> users = new ArrayList<>();
			String sql = "SELECT OwnerSSN, COUNT(*) AS Frequency FROM Date, Profile WHERE Profile1= ProfileID OR Profile2 = ProfileID GROUP BY OwnerSSN ORDER BY Frequency DESC LIMIT 10 ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String owner = set.getString("OwnerSSN");
				int freq = set.getInt("Frequency");
				String s = "";
				s = "Owner: " + owner + "Frequency: " + freq;
				users.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getHighestRatedCustomersForManagers() {
		try {
			DBConnection.initConnection();
			ArrayList<String> custs = new ArrayList<>();
			String sql = "SELECT * FROM User ORDER BY Rating DESC LIMIT 10 ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String ssn = set.getString("SSN");
				String priority = set.getString("PPP");
				int rate = set.getInt("Rating");
				String lastAct = set.getString("DateOfLastAct");
				String s = "";
				s = "Customer: " + ssn + "Priority: " + priority + "Rating: " + rate + " Last Active: " + lastAct;
				custs.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return custs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getCustomerMailingList() {
		try {
			DBConnection.initConnection();
			ArrayList<String> emails = new ArrayList<>();
			String sql = "SELECT Email FROM Person, User WHERE Person.SSN = User.SSN ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String email = set.getString("Email");
				String s = "";
				s= email;
				emails.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return emails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void likeProfile(Likes like) {
		try {
			DBConnection.initConnection();
			String sql = "INSERT INTO Likes(Liker, Likee, Date_Time) VALUES (?, ?, ?) ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, like.getLiker());
			statement.setString(2, like.getLikee());
			statement.setString(3, like.getDate());
			statement.executeUpdate();
			DBConnection.closeMainConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Dates getDate(String prof1, String dt) {
		Dates returnThis = null;
		try {
			DBConnection.initConnection();
			String sql = "SELECT * FROM Date WHERE Profile1 = ? OR Profile2 = ? AND Date_Time = ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, prof1);
			statement.setString(2, prof1);
			statement.setString(3, dt);
			ResultSet set = statement.executeQuery();

			if (set.next()) {
				String prof1_ = set.getString("Profile1");
				String prof2_ = set.getString("Profile2");
				String cr= set.getString("CustRep");
				String dt_ = set.getString("Date_Time");
				String loc = set.getString("Location");
				Double bf = set.getDouble("BookingFee");
				String cm = set.getString("Comments");
				int rate1 = set.getInt("User1Rating");
				int rate2 = set.getInt("User2Rating");
				String geoLocation = set.getString("GeoLocation");
				returnThis = new Dates(prof1_, prof2_,cr, dt,loc,bf,cm,rate1,rate2);
				returnThis.setGeoLocation(geoLocation);

			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnThis;
	}
	
	public static ArrayList<String> getMostActiveProfiles(){
		try {
			DBConnection.initConnection();
			ArrayList<String> profiles = new ArrayList<>();
			
			String sql = "SELECT P.ProfileID FROM Profile P, Date D WHERE P.ProfileID = D.Profile1 OR P.ProfileID = D.Profile2 GROUP BY ProfileID ORDER BY COUNT(ProfileID) DESC LIMIT 10 ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				profiles.add(set.getString("ProfileID"));	
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return profiles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getFavoritesList(String liker) {
		try {
			DBConnection.initConnection();
			ArrayList<String> likees = new ArrayList<>();
			String sql = "SELECT L.Likee FROM Likes L, User WHERE L.Liker= ? ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, liker);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String likee = set.getString("Likee");
				String s = "";
				s= likee;
				likees.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return likees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> searchProfilesOnLocation(int georange) {
		try {
			DBConnection.initConnection();
			ArrayList<String> profiles = new ArrayList<>();
			String sql = "SELECT P.ProfileID FROM Profile P, User WHERE P.DatingGeoRng <= ? ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setInt(1, georange);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String prof = set.getString("ProfileID");
				String s = "";
				s= prof;
				profiles.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return profiles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getViableGeoLocations(String gender){
		
		try {
			DBConnection.initConnection();
			ArrayList<String> profiles = new ArrayList<>();
			
			String sql = "SELECT ProfileID, GeoLocation FROM Profile WHERE GeoLocation IS NOT NULL AND M_F <> ? ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, gender);
			
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				profiles.add("ProfileID: " + set.getString("ProfileID") + " | GeoLocation: " + set.getString("GeoLocation"));	
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return profiles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static ArrayList<String> searchProfilesOnCharacteristics(int minWeight, int maxWeight, double minHeight, double maxHeight, String gender) {
		try {
			DBConnection.initConnection();
			ArrayList<String> profiles = new ArrayList<>();
			String sql = "SELECT * FROM Profile P WHERE (? <= P.Height AND P.Height <= ?) AND (? <= P.Weight AND P.Weight <= ? ) AND P.M_F <> ? ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setDouble(1, minHeight);
			statement.setDouble(2, maxHeight);
			statement.setDouble(3, minWeight);
			statement.setDouble(4, maxWeight);
			statement.setString(5, gender);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String prof = set.getString("ProfileID");
				int age = set.getInt("Age");
				String geo = set.getString("DatinGeoRange");
				String gen = set.getString("M_F");
				String hob = set.getString("hobbies");
				double height = set.getDouble("Height");
				int weight = set.getInt("Weight");
				String hair = set.getString("HairColor");
				String geoLocation = set.getString("GeoLocation");
				String s = "";
				s="Profile Name: "+ prof + " | Age: "+age+ " | Dating Geo-Range: "+ geo + " | Gender: " + gen + " | Hobbies: " + hob + " | Height: " + height + " | Weight: "+ weight + " | Hair Color: " + hair+ " | GeoLocation: " + geoLocation;
				profiles.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return profiles;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static ArrayList<String> getHighestRatedCustomersForUsers() {
		try {
			DBConnection.initConnection();
			ArrayList<String> ppl = new ArrayList<>();
			String sql = "SELECT P.ProfileID, U.Rating FROM Profile P, User U WHERE P.OwnerSSN = U.SSN ORDER BY Rating DESC LIMIT 10 ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String id = set.getString("ProfileID");
				int rate = set.getInt("Rating");
				String s = "";
				s = "Profile: " + id + "Rating: " + rate;
				ppl.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return ppl;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getPopularGeoDateLocations() {
		try {
			DBConnection.initConnection();
			ArrayList<String> places = new ArrayList<>();
			String sql = "SELECT GeoLocation FROM Date GROUP BY GeoLocation ORDER BY COUNT(GeoLocation) DESC LIMIT 10 ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String loc = set.getString("GeoLocation");
				String s = "";
				s = loc;
				places.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return places;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getPersonalizedDateSuggestionsList(String mf, int agestart, int ageend, int georange) {
		try {
			DBConnection.initConnection();
			ArrayList<String> profiles = new ArrayList<>();
			String sql = "SELECT * FROM Profile P WHERE P.M_F <> ? AND (P.DatingAgeRangeStart >= ? AND P.DatingAgeRangeEnd <= ?) AND DatingGeoRange<=? ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, mf);
			statement.setInt(2, agestart);
			statement.setInt(3, ageend);
			statement.setInt(4, georange);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String prof = set.getString("ProfileID");
				int age = set.getInt("Age");
				int geo = set.getInt("DatingGeoRange");
				String gender = set.getString("M_F");
				String hob = set.getString("Hobbies");
				double height = set.getDouble("Height");
				int weight = set.getInt("Weight");
				String hair = set.getString("HairColor");
				String geoLocation = set.getString("GeoLocation");
				String s = "";
				s="Profile Name: "+ prof + " | Age: "+age+ " | Dating Geo-Range: "+ geo + " | Gender: " + gender + " | Hobbies: " + hob + " | Height: " + height + " | Weight: "+ weight + " | Hair Color: " + hair+ " | GeoLocation: " + geoLocation;
				profiles.add(s);
			}
			
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return profiles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



	public static ArrayList<String> getProfiles(){
		try{
			DBConnection.initConnection();
			ArrayList<String> theProfiles = new ArrayList<>();
			String sql = "SELECT * FROM Profile ;";
			PreparedStatement pstm = DBConnection.mainConnection.prepareStatement(sql);

			ResultSet set = pstm.executeQuery();

			while(set.next()){
				String prof1 = set.getString("ProfileID");
				String ownerSSN = set.getString("OwnerSSN");
				int ageStart = set.getInt("DatingAgeRangeStart");
				int ageEnd = set.getInt("DatingAgeRangeEnd");
				int geoRange = set.getInt("DatinGeoRange");
				String m_f = set.getString("M_F");
				String hobbies = set.getString("Hobbies");
				double height = set.getDouble("Height");
				int weight = set.getInt("Weight");
				String creationDate = set.getString("CreationDate");
				String lastModDate = set.getString("LastModDate");
				int age = set.getInt("Age");
				String geoLocation = set.getString("GeoLocation");
				String s = "";
				s="ProfileID: "+ prof1 +  "| Age: "+ age +  "| GeoLocation: "+ geoLocation + " | OwnerSSN: "+ownerSSN+ " | Date Range: "+ ageStart + " to " + ageEnd + " | Geo Range: " + geoRange + " | Gender: " + m_f + " | Hobbies: "+ hobbies + " | Height: " + height + "| Weight: " + weight + "| CreationDate: " + creationDate  + "| last mod date : " + lastModDate;
				theProfiles.add(s);
			}
			return theProfiles;
		}
		catch(SQLException se){

		}
		return null;
	}
	
	public static ArrayList<String> getPastDates(String date, String p1, String p2) {
		try {
			DBConnection.initConnection();
			ArrayList<String> theDates = new ArrayList<>();
			String sql = "SELECT * FROM Date P WHERE Date_Time < ? AND (Profile1 = ? OR Profile2= ?) ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, date);
			statement.setString(2, p1);
			statement.setString(3, p2);
	
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String prof1 = set.getString("Profile1");
				String prof2 = set.getString("Profile2");
				String custRep = set.getString("CustRep");
				String date_time = set.getString("Date_Time");
				String loc = set.getString("Location");
				double fee = set.getDouble("BookingFee");
				String com = set.getString("Comments");
				int rate1 = set.getInt("User1Rating");
				int rate2 = set.getInt("User2Rating");
				String geoLocation = set.getString("GeoLocation");
				String s = "";
				s = "Profile1: "+ prof1 + " | Profile2: "+ prof2 + " | Customer Rep: "+ custRep + " | When?: " +date_time + " | Location: "+ loc + " | GeoLocation: "+ geoLocation + " | Booking Fee: " + fee + " | Comments: "+ com + " | User1 Rating: "+ rate1 + " | User2 Rating: " + rate2;
				theDates.add(s);
			}
			set.close();
			statement.close();

			DBConnection.closeMainConnection();
			return theDates;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void setUpBlindDate(BlindDate date) {
		try {
			DBConnection.initConnection();

			String sql = "Insert into BlindDate(ProfileA, ProfileB, ProfileC, Date_Time) values (?, ?, ?, ?) ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, date.getProfileA());
			statement.setString(2, date.getProfileB());
			statement.setString(3, date.getProfileC());
			statement.setString(4, date.getTheDate());
			statement.executeUpdate();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commentOnDate(Dates date) {
		try {
			DBConnection.initConnection();
			String sql = "Update Date SET Comments= ? WHERE Profile1 = ? AND Profile2 = ? ;";
			//CreationDate shouldn't be modified
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			
			statement.setString(1, date.getComments());
			statement.setString(2, date.getProfile1());
			statement.setString(3, date.getProfile2());
			statement.executeUpdate();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void makeAGeoDate(Dates date) {
		try {
			DBConnection.initConnection();

			String sql = "Insert into Date(Profile1, Profile2, CustRep, Date_Time, GeoLocation, BookingFee, Comments, User1Rating) values (?, ?, ?, ?, ?, ?, ?, ?) ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, date.getProfile1());
			statement.setString(2, date.getProfile2());
			statement.setString(3, date.getCustRep());
			statement.setString(4, date.getDate());
			statement.setString(5, date.getGeoLocation());
			statement.setDouble(6, date.getBookingFee());
			statement.setString(7, date.getComments());
			statement.setInt(8, date.getUser1rating());
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void makeADate(Dates date) {
		try {
			DBConnection.initConnection();

			String sql = "Insert into Date(Profile1, Profile2, CustRep, Date_Time, Location, BookingFee) values (?, ?, ?, ?, ?, ?) ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, date.getProfile1());
			statement.setString(2, date.getProfile2());
			statement.setString(3, date.getCustRep());
			statement.setString(4, date.getDate());
			statement.setString(5, date.getLocation());
			statement.setDouble(6, date.getBookingFee());
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteDate(String prof2, String dateTime) {
		try {
			DBConnection.initConnection();
			String sql = "Delete from Date where ( Profile1 = ? OR Profile2 = ? ) AND Date_Time= ? ;";

			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, prof2);
			statement.setString(2, prof2);
			statement.setString(3, dateTime);
			statement.executeUpdate();
			statement.close();

			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void recordADateByCustReps(Dates date) {
		try {
			DBConnection.initConnection();

			String sql = "Insert into Date(Profile1, Profile2, CustRep, Date_Time, Location, BookingFee, Comments, User1Rating, User2Rating) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, date.getProfile1());
			statement.setString(2, date.getProfile2());
			statement.setString(3, date.getCustRep());
			statement.setString(4, date.getDate());
			statement.setString(5, date.getLocation());
			statement.setDouble(6, date.getBookingFee());
			statement.setString(7, date.getComments());
			statement.setInt(8, date.getUser1rating());
			statement.setInt(9, date.getUser2Rating());
			statement.executeUpdate();
			statement.close();
			DBConnection.closeMainConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getHighestRatedCalendarDateToHaveADate() {
		try {
			DBConnection.initConnection();
			ArrayList<String> theDates = new ArrayList<>();
			String sql = "SELECT DATE(Date_Time) AS The_Date, (AVG(User1Rating+User2Rating)/2) AS Rating FROM Date GROUP BY The_Date ORDER BY Rating DESC LIMIT 5 ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String date = set.getString("The_Date");
				int rating = set.getInt("Rating");
				String s = "";
				s = "Date: " + date + "Average Rating: "+ rating;
				theDates.add(s);
			}
			statement.close();
			set.close();
			DBConnection.closeMainConnection();
			return theDates;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getCustomersWhoHaveDatedAParticularPerson(String p1, String p2) {
		try {
			DBConnection.initConnection();
			ArrayList<String> theDates = new ArrayList<>();
			String sql = "(SELECT Profile1 FROM Date WHERE Profile2 = ?) UNION (SELECT Profile2 FROM Date WHERE Profile1 = ?) ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, p2);
			statement.setString(2, p1);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String prof = set.getString("Profile1");
				String s = "";
				s = prof;
				theDates.add(s);
			}
			statement.close();
			set.close();
			DBConnection.closeMainConnection();
			return theDates;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getPendingDates(String dateTime, String prof1, String prof2) {
		try {
			DBConnection.initConnection();
			ArrayList<String> theDates = new ArrayList<>();
			String sql = "SELECT * FROM Date WHERE Date_Time > ? AND (Profile1 = ? OR Profile2 = ?) ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, dateTime);
			statement.setString(2, prof1);
			statement.setString(3, prof2);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String prof_1 = set.getString("Profile1");
				String prof_2= set.getString("Profile2");
				String custrep= set.getString("CustRep");
				String time= set.getString("Date_Time");
				String loc= set.getString("Location");
				String fee= set.getString("BookingFee");
				String com= set.getString("Comments");
				int rate1= set.getInt("User1Rating");
				int rate2= set.getInt("User2Rating");
				String geoLocation = set.getString("GeoLocation");
				String s = "";
				s = "Profile1: "+ prof_1 + " | Profile2: "+ prof_2 + " | Customer Rep: "+ custrep + " | When?: " +time + " | Location: "+ loc + " | GeoLocation: "+ geoLocation + " | Booking Fee: " + fee + " | Comments: "+ com + " | User1 Rating: "+ rate1 + " | User2 Rating: " + rate2;
				theDates.add(s);
			}
			statement.close();
			set.close();
			DBConnection.closeMainConnection();
			return theDates;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getListOfDatesByCalendarDate(String dateTime1, String dateTime2) {
		try {
			DBConnection.initConnection();
			ArrayList<String> theDates = new ArrayList<>();
			String sql = "SELECT Profile1, Profile2, CustRep, Date_Time, Location FROM Date WHERE Date_Time >= ? AND Date_Time <= ? ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, dateTime1);
			statement.setString(2, dateTime2);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String prof_1 = set.getString("Profile1");
				String prof_2= set.getString("Profile2");
				String custrep= set.getString("CustRep");
				String time= set.getString("Date_Time");
				String loc= set.getString("Location");
				String s = "";
				s = "Profile1: "+ prof_1 + "Profile2: "+ prof_2 + " Customer Rep: "+ custrep + "When?: " +time + "Location: "+ loc;
				theDates.add(s);
			}
			statement.close();
			set.close();
			DBConnection.closeMainConnection();
			return theDates;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<String> getListOfDatesByCustomer(String p1, String p2) {
		try {
			DBConnection.initConnection();
			ArrayList<String> theDates = new ArrayList<>();
			String sql = "SELECT Profile1, Profile2, CustRep, Date_Time, Location FROM Date WHERE Profile1 = ? OR Profile2 = ? ;";
			PreparedStatement statement = DBConnection.mainConnection.prepareStatement(sql);
			statement.setString(1, p1);
			statement.setString(2, p2);
			ResultSet set = statement.executeQuery();

			while (set.next()) {
				String prof_1 = set.getString("Profile1");
				String prof_2= set.getString("Profile2");
				String custrep= set.getString("CustRep");
				String time= set.getString("Date_Time");
				String loc= set.getString("Location");
				String s = "";
				s = "Profile1: "+ prof_1 + "Profile2: "+ prof_2 + " Customer Rep: "+ custrep + "When?: " +time + "Location: "+ loc;
				theDates.add(s);
			}
			statement.close();
			set.close();
			DBConnection.closeMainConnection();
			return theDates;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
