import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtils.DBConnection;
import DBUtils.DBTransactions;
import userType.UserType;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID = request.getParameter("userID");
		String password = request.getParameter("pass");
		
		boolean isMatch = DBTransactions.validateUserCredentials(userID, password);
		
		/*
		HttpSession session = request.getSession();
		session.setAttribute("userID", SSN);
		*/
		
		if(isMatch) {
			
			String typeString = DBTransactions.getUserType(userID);
			
			String gender = "";
			
			UserType type = UserType.getType(typeString);
			
			
			if(!UserType.isEmployee(type)) {
				gender = DBTransactions.getProfile(userID).getM_F();
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);
			session.setAttribute("UserType", type);
			session.setAttribute("gender", gender);
			
			if(type == UserType.MANAGER) {
				response.sendRedirect("./manager-dashboard.jsp");
			}
			else if(type == UserType.CUSTREP) {
				response.sendRedirect("./custRep-dashboard.jsp");
			}
			else if(type == UserType.USERUSER) {
				response.sendRedirect("./customer-dashboard.jsp");
			}
			else if(type == UserType.SUPERUSER) {
				response.sendRedirect("./customer-dashboard.jsp");
			}
			else if(type == UserType.GOODUSER) {
				response.sendRedirect("./customer-dashboard.jsp");
			}
			else {
				
			}
			
			
		}
		else {
			System.out.println("User was not validated try again!.");
			response.sendRedirect("./login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
