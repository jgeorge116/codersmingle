

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userType.UserType;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/UserFilter")
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String reqURL = req.getRequestURI();
		
		System.out.println("Request For: " + reqURL);
		
		if(reqURL.endsWith("login.jsp") || 
				reqURL.endsWith("login") || 
				reqURL.endsWith("signup") || 
				reqURL.endsWith("signup.jsp") || 
				reqURL.endsWith("accessDenied.jsp") || 
				reqURL.endsWith(".css")|| 
				reqURL.endsWith(".js")
				) {
			
			
			
			chain.doFilter(req, resp);
			return;
		}
		
		

		String rootURI = req.getContextPath() + "/";
		if(reqURL.equals(rootURI)){
			chain.doFilter(req, resp); //Continue
			return;
		} 
		
		
		HttpSession session = req.getSession();
		
		
		if(session.getAttribute("userID") != null) {
			
			UserType type = (UserType) session.getAttribute("userType");
			
			
			if(type == UserType.MANAGER) {
				//Pages Managers can't access
				
				if(reqURL.endsWith("addDate.jsp") ||
						reqURL.endsWith("addGeoDate.jsp") ||
						reqURL.endsWith("addCustomer.jsp") ||
						reqURL.endsWith("addNewCustomer.jsp") ||
						reqURL.endsWith("addExistingCustomer.jsp") ||
						reqURL.endsWith("blindDate.jsp") ||
						reqURL.endsWith("cancelDate.jsp") ||
						reqURL.endsWith("commentOnDate.jsp") ||
						reqURL.endsWith("customer-dashboard.jsp") ||
						reqURL.endsWith("custRep-dashboard.jsp") ||
						reqURL.endsWith("custRepRecordDate.jsp") ||
						reqURL.endsWith("deleteCustomer.jsp") ||
						reqURL.endsWith("editCustomer.jsp") ||
						reqURL.endsWith("editGeoLocation.jsp") ||
						reqURL.endsWith("editPerson.jsp") ||
						reqURL.endsWith("likeProfile.jsp") ||
						reqURL.endsWith("rateDate.jsp") ||
						reqURL.endsWith("showCustomerMailingList.jsp") ||
						reqURL.endsWith("showParticularDates.jsp") ||
						reqURL.endsWith("showPersonalizedSuggestionList.jsp") ||
						reqURL.endsWith("viewFavorites.jsp") ||
						reqURL.endsWith("viewHighestRatedProfiles.jsp") ||
						reqURL.endsWith("viewMostActiveProfiles.jsp") ||
						reqURL.endsWith("viewPastDates.jsp") ||
						reqURL.endsWith("viewPendingDates.jsp") ||
						reqURL.endsWith("viewPopularGeoLocations.jsp") ||
						reqURL.endsWith("viewProfilesBasedOnPhysicalAttributes.jsp") 
						) {
					resp.sendRedirect("./accessDenied.jsp");
					
				}
				
				
			}
			else if(type == UserType.CUSTREP) {
				
				if(reqURL.endsWith("addDate.jsp") ||
						reqURL.endsWith("addGeoDate.jsp") ||
						reqURL.endsWith("blindDate.jsp") ||
						reqURL.endsWith("cancelDate.jsp") ||
						reqURL.endsWith("commentOnDate.jsp") ||
						reqURL.endsWith("customer-dashboard.jsp") ||
						reqURL.endsWith("manager-dashboard.jsp") ||
						reqURL.endsWith("editGeoLocation.jsp") ||
						reqURL.endsWith("editPerson.jsp") ||
						reqURL.endsWith("likeProfile.jsp") ||
						reqURL.endsWith("rateDate.jsp") ||
						reqURL.endsWith("revForCustomer.jsp") ||
						reqURL.endsWith("showParticularDates.jsp") ||
						reqURL.endsWith("showPersonalizedSuggestionList.jsp") ||
						reqURL.endsWith("viewFavorites.jsp") ||
						reqURL.endsWith("viewHighestRatedProfiles.jsp") ||
						reqURL.endsWith("viewMostActiveProfiles.jsp") ||
						reqURL.endsWith("viewPastDates.jsp") ||
						reqURL.endsWith("viewPendingDates.jsp") ||
						reqURL.endsWith("viewPopularGeoLocations.jsp") ||
						reqURL.endsWith("viewProfilesBasedOnPhysicalAttributes.jsp") ||
						reqURL.endsWith("addEmployee.jsp") ||
						reqURL.endsWith("addExistingEmployee.jsp") ||
						reqURL.endsWith("addNewEmployee.jsp") ||
						reqURL.endsWith("editEmployee.jsp") ||
						reqURL.endsWith("deleteEmployee.jsp") ||
						reqURL.endsWith("editPerson.jsp") ||
						reqURL.endsWith("manager-dates-query.jsp") ||
						reqURL.endsWith("getMonthsForSalesReport.jsp") ||
						reqURL.endsWith("showEmployeePerformance.jsp") ||
						reqURL.endsWith("showCustomerPerformance.jsp") ||
						reqURL.endsWith("showHighestRatedCalendarDates.jsp") ||
						reqURL.endsWith("showHighestRatedCustomers.jsp") ||
						reqURL.endsWith("showMostActiveCustomers.jsp") ||
						reqURL.endsWith("showSalesReport.jsp") ||
						reqURL.endsWith("showUsers.jsp") ||
						reqURL.endsWith("viewDatesBy-Manager.jsp")) {
					resp.sendRedirect("./accessDenied.jsp");
				}
				
			}
			else if(!UserType.isEmployee(type)) {
				//Pages users can't access
				if(reqURL.endsWith("addCustomer.jsp") ||
						reqURL.endsWith("addNewCustomer.jsp") ||
						reqURL.endsWith("addExistingCustomer.jsp") ||
						reqURL.endsWith("custRep-dashboard.jsp") ||
						reqURL.endsWith("custRepRecordDate.jsp") ||
						reqURL.endsWith("manager-dashboard.jsp") ||
						reqURL.endsWith("getCustomerToSeeDates.jsp") ||
						reqURL.endsWith("editPerson.jsp") ||
						reqURL.endsWith("showCustomerMailingList.jsp") ||
						reqURL.endsWith("showHighestRatedCustomers.jsp") ||
						reqURL.endsWith("showMostActiveCustomers.jsp") ||
						reqURL.endsWith("showSalesReport.jsp") ||
						reqURL.endsWith("showUsers.jsp") ||
						reqURL.endsWith("viewDatesBy-Manager.jsp") ||
						reqURL.endsWith("addEmployee.jsp") ||
						reqURL.endsWith("addExistingEmployee.jsp") ||
						reqURL.endsWith("addNewEmployee.jsp") ||
						reqURL.endsWith("editEmployee.jsp") ||
						reqURL.endsWith("deleteEmployee.jsp") ||
						reqURL.endsWith("editPerson.jsp") ||
						reqURL.endsWith("manager-dates-query.jsp") ||
						reqURL.endsWith("getMonthsForSalesReport.jsp") ||
						reqURL.endsWith("showEmployeePerformance.jsp") ||
						reqURL.endsWith("showCustomerPerformance.jsp") ||
						reqURL.endsWith("revForCustomer.jsp") ) {
					resp.sendRedirect("./accessDenied.jsp");
					return;
				}
				
			}
			chain.doFilter(req, resp); //Continue
		}
		else {
			resp.sendRedirect("./login.jsp"); 
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
