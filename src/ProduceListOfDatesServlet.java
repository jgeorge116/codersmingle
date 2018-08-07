

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;

/**
 * Servlet implementation class produceListOfDatesServlet
 */
@WebServlet("/produceListOfDates")
public class ProduceListOfDatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduceListOfDatesServlet() {
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
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year2 = request.getParameter("year2");
		String month2 = request.getParameter("month2");
		String day2 = request.getParameter("day2");
		ArrayList<String> dates = null;
		if(!ssn_.equals("")) {
			
			dates = DBTransactions.getListOfDatesByCustomer(ssn_, ssn_);
		}
		else {
			String date1 = ""+year+"-"+month+"-"+day+" 00:00:00";
			String date2 = ""+year2+"-"+month2+"-"+day2+" 23:59:59";
			
			dates = DBTransactions.getListOfDatesByCalendarDate(date1, date2);
			
		}
		
		request.getSession().setAttribute("dates", dates);
		response.sendRedirect("./manager-dates-query.jsp");
	}

}
