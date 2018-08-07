

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.BlindDate;

/**
 * Servlet implementation class BlindDateServlet
 */
@WebServlet("/blindDate")
public class BlindDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlindDateServlet() {
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
		String profileA = (String) request.getSession().getAttribute("userID");
		String profileB = request.getParameter("profileB");
		String profileC = request.getParameter("profileC");
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"); //yyyy-mm-dd HH:mm:ss
	    String dateOfLastAct = sdf.format(cal.getTime());
	    
	    BlindDate blindDate = new BlindDate(profileA, profileB, profileC, dateOfLastAct);
	    
	    DBTransactions.setUpBlindDate(blindDate);
	    
	    response.sendRedirect("./customer-dashboard.jsp");
		
	}

}
