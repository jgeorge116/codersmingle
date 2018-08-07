

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DBUtils.DBTransactions;
import object_classes.Dates;
import object_classes.Profile;
import object_classes.User;

/**
 * Servlet implementation class RateDateServlet
 */
@WebServlet("/rateDate")
public class RateDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateDateServlet() {
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
		String profile1 = (String) request.getSession().getAttribute("userID");
		String profile2 = request.getParameter("profileID");
		String timeStamp = request.getParameter("datetime");
		int user1Rating = Integer.parseInt(request.getParameter("rating"));
		
		Dates date = DBTransactions.getDate(profile2, timeStamp);
		if(date.getProfile1().equals(profile1)) {
			date.setUser1rating(user1Rating);
		}
		else {
			date.setUser2Rating(user1Rating);
		}
		DBTransactions.editDate(date);
		
		Profile prof2 = DBTransactions.getProfile(profile2);
		User user = DBTransactions.getUser(prof2.getOwnerSSN());
		int initRating = (user).getRating();
		
		if(user1Rating > initRating) {
			initRating++;
		}
		else if(user1Rating < initRating){
			initRating--;
		}
		if(0 > initRating) {
			initRating = 0;
		}
		
		if(initRating > 5) {
			initRating = 5;
		}
		
		user.setRating(initRating);
		DBTransactions.editUser(user);
		
		
		response.sendRedirect("./customer-dashboard.jsp");
		
		
		
		
	}

}
