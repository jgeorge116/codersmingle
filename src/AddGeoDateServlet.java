

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.Dates;

/**
 * Servlet implementation class AddGeoDateServlet
 */
@WebServlet("/addGeoDate")
public class AddGeoDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGeoDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String profile1 = (String)request.getSession().getAttribute("userID");
		String profile2 = request.getParameter("profileID");
		String custRep = request.getParameter("custRep");
		String date_time = request.getParameter("Date_Time");
		double bookingFee = Double.parseDouble(request.getParameter("bookingFee"));

		String comments = request.getParameter("Comments");
		int rating1 = Integer.parseInt(request.getParameter("User1Rating"));
		String geoLocation = DBTransactions.getProfile(profile2).getGeoLocation();


		
		Dates theDate = new Dates(profile1, profile2, custRep ,date_time,"" ,bookingFee,comments,rating1, 0 );
		theDate.setGeoLocation(geoLocation);
		
		DBTransactions.makeAGeoDate(theDate);
		
		
		response.sendRedirect("./customer-dashboard.jsp");
		
		
		
	}

}
