<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.ArrayList, DBUtils.DBTransactions, object_classes.User, userType.UserType" %>

<%@ page session="true" %>

<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[

function Submit_onclick() {



	javascript:registerForm.submit();
}
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
			
				<label class = "instructions">Profiles:</label>

				<br>
				<hr>

				<%
				ArrayList<String> users = DBTransactions.getProfiles();
				for(int i = 0; i < users.size(); i++){
					out.print(users.get(i));
				%>
					<br>
				<%	
				}
				%>

				<br>
				<hr>



				<form name="registerForm" action="addDate" method="post">
				<div class="form-group">
					<label for="profileID">ProfileID</label> <input type="text"
						class="form-control" name="profileID" id="profileID" placeholder="Brenna_Berlin">
						<span class="focus-border"></span>
				</div>



				<div class="form-group">
					<label for="Date_Time">Date_Time (YYYY-MM-DD HH:MM:SS): </label> <input
						type="text" class="form-control" name="Date_Time" id="Date_Time"
						placeholder="YYYY-MM-DD HH:MM:SS">
						<span class="focus-border"></span>
				</div>


				<div class="form-group">
					<label for="custRep">CustRep ID that helped you: </label> <input
						type="text" class="form-control" name="custRep" id="custRep"
						placeholder="123456789">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="location">Location: </label> <input
						type="text" class="form-control" name="location" id="location"
						placeholder="The Mall">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="bookingFee">Booking Fee: </label> <input type="text"
						class="form-control" name="bookingFee" id="bookingFee"
						placeholder="34.50">
						<span class="focus-border"></span>
				</div>

<<<<<<< HEAD
=======
				<div class="form-group">
					<label for="comment">Comment: </label> <input type="text"
						class="form-control" name="comment" id="comment"
						placeholder="IT WAS SO BAD">
						<span class="focus-border"></span>
>>>>>>> 5e17e03048e32880e96fc2ef2ba3dc99883f2d71
				</div>
				<div class="form-group">
					<label for="geoLocation">Geo Location: </label> <input type="text"
						class="form-control" name="geoLocation" id="geoLocation"
						placeholder="Starbucks/NULL">
						<span class="focus-border"></span>
				</div>
<<<<<<< HEAD
=======

				<div class="form-group">
					<label for="rating">Rating: </label> <input type="text"
						class="form-control" name="rating" id="rating"
						placeholder="0/4/5">
						<span class="focus-border"></span>
				</div>

				
>>>>>>> 5e17e03048e32880e96fc2ef2ba3dc99883f2d71
				
				<div class="form-group">
					<div class="form-group">
						<input type="submit" class="btn"
							onclick="return Submit_onclick()">
					</div>
				</div>

			</form>

			</div>
		</div>

		</div>

			
		</div>


	</body>

	
</html>





