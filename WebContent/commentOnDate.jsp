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
				<label class = "instructions"> Dates: </label>

				<br>
				<hr>

				<%
				String profileID = session.getAttribute("userID").toString();
				ArrayList<String> users = DBTransactions.getListOfDatesByCustomer(profileID, profileID);


				for(int i = 0; i < users.size(); i++){
					out.print(users.get(i));
				%>
					<br>
				<%	
				}
				%>

				<br>
				<hr>



				<form name="registerForm" action="commentOnDate" method="post">
				<div class="form-group">
					<label for="profileID">ProfileID of person you dated: </label> <input type="text"
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
					<label for="comment">Comment: </label> <input
						type="text" class="form-control" name="comment" id="comment"
						placeholder="IT WAS HORRIBLE">
						<span class="focus-border"></span>
				</div>
				
				
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





