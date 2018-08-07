<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList, DBUtils.DBTransactions, object_classes.User, userType.UserType" %>


<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[
		//check for valid input or nah


function Submit_onclick() {
	if(document.registerForm.SSN.value == "" || document.registerForm.year.value == "" || document.registerForm.month.value == "" || document.registerForm.day.value == "" || document.registerForm.pay.value == ""){
	    alert("Fields cannot be empty");
	    return false;
	}

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
			Profiles:
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



			<div class="col-md-1"></div>
			<div class="col-md-5">
			<form name="registerForm" action="custRepRecordDate" method="post">
				<div class="form-group">
					<label for="profile1">Profile1</label> <input type="text"
						class="form-control" name="profile1" id="profile1" placeholder="Brenna_Berlin">
				</div>

				<div class="form-group">
					<label for="profile2">Profile2</label> <input type="text"
						class="form-control" name="profile2" id="profile2" placeholder="Brenna_Berlin">
				</div>


				<div class="form-group">
					<label for="date">Start Date (YYYY-MM-DD): </label> <input
						type="text" class="form-control" name="date" id="date"
						placeholder="2017-10-04">
				</div>
				<div class="form-group">
					<label for="time">Time (HH:MM:SS): </label> <input
						type="text" class="form-control" name="time" id="time"
						placeholder="12:40:00">
				</div>


				<div class="form-group">
					<label for="location">Location: </label> <input
						type="text" class="form-control" name="location" id="location"
						placeholder= "The Mall">
				</div>

				<div class="form-group">
					<label for="bookingFee">Booking Fee: </label> <input
						type="text" class="form-control" name="bookingFee" id="bookingFee"
						placeholder= "34.50">
				</div>


				<div class="form-group">
					<label for="comments">Comments: </label> <input
						type="text" class="form-control" name="comments" id="comments"
						placeholder= "Comments Here">
				</div>

				
				<div class="form-group">
					<label for="user1Rating">User 1 Rating: </label> <input
						type="text" class="form-control" name="user1Rating" id="user1Rating"
						placeholder= "3">
				</div>

				
				<div class="form-group">
					<label for="user2Rating">User 2 Rating: </label> <input
						type="text" class="form-control" name="user2Rating" id="user2Rating"
						placeholder= "0">
				</div>
				
				<div class="form-group">
					<label for="geoLocation">Geo Location: </label> <input
						type="text" class="form-control" name="geoLocation" id="geoLocation"
						placeholder= "Starbucks">
				</div>


				<br>
				<hr>

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

		</div>

			
		</div>


	</body>

	
</html>





