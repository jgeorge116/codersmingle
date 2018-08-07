

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.Dates;

/**
 * Servlet implementation class AddDateServlet
 */
@WebServlet("/addDate")
public class AddDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDateServlet() {
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
		String prof1 = (String)request.getSession().getAttribute("userID");
		String prof2 = request.getParameter("profileID");
		String dt = request.getParameter("Date_Time");//yyyy-MM-dd HH:mm:ss
		String cr = request.getParameter("custRep");
		String loc = request.getParameter("location");
		Double bf = Double.parseDouble(request.getParameter("bookingFee"));
		
		Dates theDate = new Dates(prof1, prof2, cr,dt,loc,bf,"",0, 0 );
		DBTransactions.makeADate(theDate);
		response.sendRedirect("./customer-dashboard.jsp");
	}

}
