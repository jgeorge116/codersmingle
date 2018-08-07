

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.Person;
import object_classes.User;
import userType.UserType;

/**
 * Servlet implementation class AddNewCustomer
 */
@WebServlet("/addNewCustomer")
public class AddNewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ssn_ = request.getParameter("SSN");
		String password = request.getParameter("password");
		String telephone = request.getParameter("telephone");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		String dateTime = year + "-" + month + "-" + day + " " + time ; //This is formatted
		String ppp = request.getParameter("ppp");
		UserType userType = null;
		if(ppp.equals("U")) {
			userType = UserType.USERUSER;
		}
		if(ppp.equals("G")) {
			userType = UserType.GOODUSER;
		}
		if(ppp.equals("S")) {
			userType = UserType.SUPERUSER;
		}
		
		ppp = UserType.toString(userType);
		
		
		Person person = new Person(ssn_, password, firstName, lastName, address, city, state, zip, email, telephone);
		User user = new User(ssn_, userType, rating, dateTime);
		
		DBTransactions.addPerson(person);
		DBTransactions.addUser(user);
		
		
		response.sendRedirect("./custRep-dashboard.jsp");
		
		
	}

}
