

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.Person;
import userType.UserType;

/**
 * Servlet implementation class EditPersonServlet
 */
@WebServlet("/editPerson")
public class EditPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ssn = request.getParameter("SSN");
		String pass = request.getParameter("pass");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		
		
		Person person = DBTransactions.getPerson(ssn);
		person.setPassword(pass);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setStreet(street);
		person.setCity(city);
		person.setState(state);
		person.setZipcode(zipcode);
		person.setEmail(email);
		person.setTelephone(telephone);
		
		DBTransactions.editPerson(person);
		response.sendRedirect("./manager-dashboard.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
