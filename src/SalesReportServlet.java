

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBUtils.DBTransactions;

/**
 * Servlet implementation class salesReportServlet
 */
@WebServlet("/salesReport")
public class SalesReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesReportServlet() {
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
		
		String month1 = request.getParameter("initMonth");
		String month2 =  request.getParameter("month");
		String year1 = request.getParameter("initYear");
		String year2 = request.getParameter("year");
		
		int lastDate = 31;
		
		
		if(month2.equals("02")) { lastDate = 28; };
		if(month2.equals("04") || month2.equals("06") || month2.equals("09") || month2.equals("11")) {lastDate = 30; };
		
		
		
		
		String date1 = year1+"-"+month1+"-01";;
		String date2 = year2+"-"+month2+"-"+lastDate;
		
		double sales = DBTransactions.getSalesReportBySpecifiedDates(date1, date2);
		
		HttpSession session = request.getSession();
		session.setAttribute("sales", "$"+sales+"");
		
		response.sendRedirect("./showSalesReport.jsp");
	}

}
