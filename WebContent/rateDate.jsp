
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



	        Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"); //yyyy-mm-dd HH:mm:ss
	        String dateOfLastAct = sdf.format(cal.getTime());

	        out.print("Current Time: "+dateOfLastAct);
	        out.print("Dates you've been on: ");


	        %>

	        <br>
	        <br>
	        <hr>

	        <%
	        String userID = (String) session.getAttribute("userID");
	        
	        

			ArrayList<String> users = DBTransactions.getPastDates(dateOfLastAct, userID, userID);
			for(int i = 0; i < users.size(); i++){
				out.print(users.get(i));
			%>
				<br>
			<%	
			}
			%>


			</div>
		</div>

			<form name="registerForm" action="rateDate" method="post">
				<div class="form-group">
					<label for="profileID">ProfileID of the Person you dated: </label> <input type="text"
						class="form-control" name="profileID" id="profileID" placeholder="Brenna_Berlin">
				</div>
				<div class="form-group">
					<label for="datetime">Time Stamp (YYYY-MM-DD HH:MM:SS): </label> <input type="text"
						class="form-control" name="datetime" id="datetime" placeholder="2014-10-05 15:00:00">
				</div>

				<div class="form-group">
					<label for="rating">Rating: </label> <input type="text"
						class="form-control" name="rating" id="rating" placeholder="5">
				</div>
				

				<div class="form-group">
					


					<br>
					<div class="form-group">
						<input type="submit" class="form-control"
							onclick="return Submit_onclick()">
					</div>
				</div>

			</form>

		</div>

			
		</div>


	</body>

	
</html>





