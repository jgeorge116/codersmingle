

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Statement;

import DBUtils.DBConnection;
import DBUtils.DBTransactions;

/**
 * Servlet implementation class DumpServlet
 */
@WebServlet("/dump")
public class DumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DumpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			DBConnection.initConnection();
			
			
			String[] tables = {"Account", "BlindDate", "Date", "Employee", "Likes", "Person", "Profile", "SuggestedBy", "User"};
			
			
			Statement stmt = DBConnection.getConnection().createStatement();
			
			for(int i = 0; i < tables.length; i++) {
				stmt.execute("SELECT * FROM "+tables[i]+ " INTO OUTFILE './"+tables[i]+"_export.txt");
			}
			
			stmt.close();
			
			DBConnection.closeMainConnection();
			
		}
		catch(SQLException se) {
			
		}
		

		
		
		response.sendRedirect("./manager-dashboard.jsp");
	}

}
