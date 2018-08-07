

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.Employee;
import userType.UserType;

/**
 * Servlet implementation class addExistingEmployeeServlet
 */
@WebServlet("/addExistingEmployee")
public class AddExistingEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExistingEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ssn_ = request.getParameter("SSN");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String date = year + "-" + month + "-" + day; //This is formatted
		int pay = Integer.parseInt(request.getParameter("pay"));
		
		String role = request.getParameter("userType");
		UserType userType = null;
		if(role.equals("C")) {
			userType = UserType.CUSTREP;
		}
		if(role.equals("M")) {
			userType = UserType.MANAGER;
		}
		
		role = UserType.toString(userType);
		
		Employee employee = DBTransactions.getEmployee(ssn_);
		employee.setStartDate(date);
		employee.setHourlyRate(pay);
		employee.setRole(role);
		
		DBTransactions.addEmployee(employee);
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
