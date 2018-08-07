

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.Dates;

/**
 * Servlet implementation class CustRepRecordDateServlet
 */
@WebServlet("/custRepRecordDate")
public class CustRepRecordDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustRepRecordDateServlet() {
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

		String profile1 = request.getParameter("profile1");
		String profile2 = request.getParameter("profile2");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String date_time = date+" "+time;
		String location = request.getParameter("location");
		double bookingFee = Double.parseDouble(request.getParameter("bookingFee"));
		String comments = request.getParameter("comments");
		int user1Rating = Integer.parseInt(request.getParameter("user1Rating"));
		int user2Rating = Integer.parseInt(request.getParameter("user2Rating"));
		String geoLocation = request.getParameter("geoLocation");
		
		Dates theDate = new Dates(profile1, profile2, request.getSession().getAttribute("userID").toString(), date_time, location, bookingFee, comments, user1Rating, user2Rating);
		/*
		 * Dates(String profile1, String profile2, String custRep, String date, String location, Double bookingFee,
			String comments, int user1rating, int user2Rating)
		 * 
		 */
		DBTransactions.recordADateByCustReps(theDate);
		
		response.sendRedirect("./custRep-dashboard.jsp");
		
	}

}
