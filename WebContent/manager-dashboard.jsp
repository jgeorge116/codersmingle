<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[
		// ]]>
	</script>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>codersmingle.com</title>
	</head>
	<body>


		<div class="parallax">
			


			<div class="container default">
				<div class="logo_container">

					<ul class = "heading_ul">
						<a class = "logo" href = "index.jsp">codersmingle.com </a>
						<li class = "heading_li"><a class = "heading_option" href="login.jsp">Log-out</a></li>
						<li class = "heading_li"><a class = "heading_option" href="signup.jsp">Sign-Up</a></li>
						<li class = "heading_li"><a class = "heading_option" href="">Contact</a></li>
						<li class = "heading_li"><a class = "heading_option" href="">About</a></li>
					</ul>
				</div>
			</div>


		<div class = "parallax">

		<div class="row main" style="margin-right: 0px !important;">
			<div class="col-md-1"></div>
			<div class="col-md-5">
				<a href = "addEmployee.jsp" >
					<button type="submit"  class = "option_button" name="action" value="addEmployee" >
						Add Employee
					</button>
				</a>
				<br>
				<a href = "editEmployee.jsp">
					<button type="submit"  class = "option_button" name="action" value="editEmployee">
						Edit Employee
					</button>
				</a>
				<br>


				<a href = "deleteEmployee.jsp">
					<button type="submit" class = "option_button" name="action" value="deleteEmployee">
						Delete Employee
					</button>
				</a>
				<br>


				<a href = "getMonthsForSalesReport.jsp">
					<button type="submit"  class = "option_button" name="action" value="generateSalesReport">
						Generate Sales Report for a Month
					</button>
				</a>
				<br>

				<a href = "viewDatesBy-Manager.jsp">
					<button type="submit"  class = "option_button" name="action" value="listOfDates">
						Produce List of Dates by Calendar Dates or Profile ID
					</button>
				</a>
				<br>


				<a href = "revForCustomer.jsp">
					<button type="submit" class = "option_button" name="action" value="revByDate">
						Revenue Summary for a Customer
					</button>
				</a>
				<br>

				<a href = "showUsers.jsp">
					<button type="submit" class = "option_button" name="action" value="employeeRanking">
						See All Users
					</button>
				</a>
				<br>

				<a href = "showEmployeePerformance.jsp">
					<button type="submit" class = "option_button" name="action" value="employeeRanking">
						Employee Performance
					</button>
				</a>
				<br>


				<a href = "showCustomerPerformance.jsp">
					<button type="submit" class = "option_button" name="action" value="employeeRanking">
						User Revenue Performance
					</button>
				</a>
				<br>

				<a href = "showMostActiveCustomers.jsp">
					<button type="submit" class = "option_button" name="action" value="employeeRanking">
						Most Active Customers
					</button>
				</a>
				<br>

				<a href = "getCustomerToSeeDates.jsp">
					<button type="submit" class = "option_button" name="action" value="employeeRanking">
						Find Cutomers Who Have Dated a Certain Customer
					</button>
				</a>
				<br>

				
				<a href = "showHighestRatedCustomers.jsp">
					<button type="submit" class = "option_button" name="action" value="employeeRanking">
						Highest Rated Customers
					</button>
				</a>
				<br>
				
				<a href = "showHighestRatedCalendarDates.jsp">
					<button type="submit" class = "option_button" name="action" value="employeeRanking">
						Highest Rated Calendar Dates
					</button>
				</a>
				<br>
				
				<form action="dump" method="post" >
					
						<button type="submit" class = "option_button" name="action" value="employeeRanking">
							Data Dump
						</button>
					
					<br>
				</form>

			</div>
		</div>

		</div>

			
		</div>


	</body>

	
</html>





