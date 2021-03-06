

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBUtils.DBTransactions;
import object_classes.Dates;

/**
 * Servlet implementation class CommentOnDateServlet
 */
@WebServlet("/commentOnDate")
public class CommentOnDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentOnDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prof1 = request.getParameter("profileID");
		String dt = request.getParameter("Date_Time");
		String cm = request.getParameter("Comments");
		Dates theDate =DBTransactions.getDate(prof1, dt);
		theDate.setComments(cm);
		DBTransactions.commentOnDate(theDate);
		
		response.sendRedirect("./customer-dashboard.jsp");
		
	}

}
