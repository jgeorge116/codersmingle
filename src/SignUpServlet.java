
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtils.DBTransactions;
import object_classes.Account;
import object_classes.Person;
import object_classes.Profile;
import object_classes.User;
import userType.UserType;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get all the values
		String ssn_ = DBTransactions.removeDashes(request.getParameter("SSN"));

		String username = request.getParameter("username");
		String id = request.getParameter("profileid");
		String mf = request.getParameter("mf");
		String password = request.getParameter("password");
		String telephone = request.getParameter("telephone");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		int drs = Integer.parseInt(request.getParameter("datingagerangestart"));
		int dre = Integer.parseInt(request.getParameter("datingagerangeend"));
		int dgr = Integer.parseInt(request.getParameter("datinggeorange"));
		String hob = request.getParameter("hobbies");
		Double height = Double.parseDouble(request.getParameter("height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		String hair = request.getParameter("haircolor");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String creditCard = request.getParameter("creditCard");
		// need more fields
		String userTypeSTR = request.getParameter("userType");
		UserType userType = null;
		if (userTypeSTR.equals("U")) {
			userType = UserType.USERUSER;
		}
		if (userTypeSTR.equals("S")) {
			userType = UserType.SUPERUSER;
		}
		if (userTypeSTR.equals("G")) {
			userType = UserType.GOODUSER;
		}

		// add person to DB
		if (DBTransactions.isValidUsername(username)) {
			Person person = new Person(ssn_, password, firstName, lastName, address, city, state, zip, email,
					telephone);
			// User(String sSN, UserType pPP, int rating, String dateOfLastAct)
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // yyyy-mm-dd HH:mm:ss
			String dateOfLastAct = sdf.format(cal.getTime());
			String createDate = sdf.format(cal.getTime());

			User user = new User(ssn_, userType, 0, dateOfLastAct);

			// Account(String cardNumber, String acctNum, String ownerSSN)
			Account account = new Account(creditCard, "", ssn_);
			Profile prof = new Profile(id, ssn_, drs, dre, dgr, mf, hob, height, weight, hair, createDate,
					dateOfLastAct, age);

			if (DBTransactions.uniqueSSN(ssn_)) {
				DBTransactions.addPerson(person);
				DBTransactions.addUser(user);
				DBTransactions.addProfile(prof);
				DBTransactions.addAccount(account);
				
			}
			else {
				DBTransactions.addAccount(account);
				DBTransactions.addProfile(prof);
			}

			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("ssn_", ssn_);
			session.setAttribute("type", userType);

			// add these if and only if the user continues with entering all the user info
			session.setAttribute("user", user);
			session.setAttribute("account", account);

			response.sendRedirect("./customer-dashboard.jsp");

		} else {
			// userID already Taken
			response.sendRedirect("./signup.jsp");
		}

	}

}
