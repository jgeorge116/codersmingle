
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, DBUtils.DBTransactions, object_classes.User, userType.UserType, java.text.SimpleDateFormat, java.util.Calendar" %>

<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[
	//check for valid input or nah

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
			<div class="col-md-10">


			<%

	        out.print("Top 10 Active Profiles: ");

	        %>

	        <br>
	        <br>
	        <hr>

	        <%

			ArrayList<String> users = DBTransactions.getMostActiveProfiles();
			for(int i = 0; i < users.size(); i++){
				out.print(users.get(i));
			%>
				<br>
			<%	
			}
			%>


			</div>
		</div>

		<a href = "./customer-dashboard.jsp">
			<button>
				OK
			</button>
		</a>

		</div>

			
		</div>


	</body>

	
</html>





