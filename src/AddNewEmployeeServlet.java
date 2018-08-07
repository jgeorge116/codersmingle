

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.Employee;
import object_classes.Person;
import userType.UserType;

/**
 * Servlet implementation class AddNewEmployee
 */
@WebServlet("/addNewEmployee")
public class AddNewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get all the parameters
		
		
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
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String date = year + "-" + month + "-" + day; //This is formatted
		
		int pay = Integer.parseInt(request.getParameter("pay"));
		
		String role = request.getParameter("role");
		UserType userType = null;
		if(role.equals("C")) {
			userType = UserType.CUSTREP;
		}
		if(role.equals("M")) {
			userType = UserType.MANAGER;
		}
		
		role = UserType.toString(userType);
		
		Person person = new Person(ssn_ , password, firstName, lastName, address, city, state, zip, email, telephone);
		//Person(sSN, password, firstName, lastName, street, city,
		// state,  zipcode,  email,  telephone)
		
		Employee employee = new Employee(ssn_, role, date, pay);
		//(String sSN, String role, String startDate, int hourlyRate) 
		
		DBTransactions.addPerson(person);
		DBTransactions.addEmployee(employee);
		
		response.sendRedirect("./manager-dashboard.jsp");
		
		
	}

}
