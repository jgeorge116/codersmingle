

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.User;
import userType.UserType;

/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/editCustomer")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
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
		String ssn_ = request.getParameter("SSN");
		
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
		
		
		User user = new User(ssn_, userType, rating, dateTime);
		
		DBTransactions.editUser(user);
		
		
		response.sendRedirect("./custRep-dashboard.jsp");
	}

}
