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
				<a href = "./addCustomer.jsp" >
					<button type="submit"  class = "option_button" name="action" value="addCustomer" >
						Add Customer
					</button>
				</a>
				<br>
				<a href = "./editCustomer.jsp">
					<button type="submit"  class = "option_button" name="action" value="editCustomer">
						Edit Customer
					</button>
				</a>
				<br>


				<a href = "./deleteCustomer.jsp">
					<button type="submit" class = "option_button" name="action" value="deleteCustomer">
						Delete Customer
					</button>
				</a>
				<br>


				<a href = "./custRepRecordDate.jsp">
					<button type="submit"  class = "option_button" name="action" value="RecordDateCustRep">
						Record a Date
					</button>
				</a>
				<br>

				<a href = "./showCustomerMailingLists.jsp">
					<button type="submit"  class = "option_button" name="action" value="CustomerMailingList">
						Get Customer Mailing List
					</button>
				</a>
				<br>


				<a href = "google.com">
					<button type="submit" class = "option_button" name="action" value="GetDateSuggestions">
						Give Date Suggestions For a Customer
					</button>
				</a>
				<br>

			</div>
		</div>

		</div>

			
		</div>


	</body>

	
</html>



