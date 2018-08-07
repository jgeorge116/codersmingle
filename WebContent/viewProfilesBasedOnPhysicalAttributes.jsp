
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

			<b> Entering valid values in the input will show profiles below: </b>

	        <form action="viewProfilesBasedOnPhysicalAttributes.jsp">
				<div class="form-group">
					<label for="minHeight">Min Height: </label> <input type="text"
						class="form-control" name="minHeight" id="minHeight" placeholder="6.0">
				</div>
				<div class="form-group">
					<label for="maxHeight">Max Height: </label> <input type="text"
						class="form-control" name="maxHeight" id="maxHeight" placeholder="6.0">
				</div>
				<div class="form-group">
					<label for="minWeight">Min Weight: </label> <input type="text"
						class="form-control" name="minWeight" id="minWeight" placeholder="170">
				</div>

				<div class="form-group">
					<label for="maxWeight">Max Weight: </label> <input type="text"
						class="form-control" name="maxWeight" id="maxWeight" placeholder="200">
				</div>
				

				<div class="form-group">
					<br>
					<div class="form-group">
						<input type="Submit" class="form-control" value = "Search!">
					</div>
				</div>

			</form>


	        <br>
	        <br>
	        <hr>

	        <b> Results: </b>

			<br>

	        <%
	        String minH = request.getParameter("minHeight");
	        String maxH = request.getParameter("maxHeight");
	        String minW = request.getParameter("minWeight");
	        String maxW = request.getParameter("maxWeight");
	        if(minH != null && maxH != null && minW != null && maxW != null){
	        	
	        	
				if(minH.length() != 0 && maxH.length() != 0 && maxW.length() != 0 && minW.length() != 0){
			        String userID = (String) session.getAttribute("userID");
			        String gender = (String) session.getAttribute("gender");
		
			        double minHeight = Double.parseDouble(minH);
			        double maxHeight = Double.parseDouble(maxH);
			        int minWeight = Integer.parseInt(minW);
			        int maxWeight = Integer.parseInt(maxW);
		
		
					ArrayList<String> users = DBTransactions.searchProfilesOnCharacteristics(minWeight, maxWeight, minHeight, maxHeight, gender);
					for(int i = 0; i < users.size(); i++){
						out.print(users.get(i));
					%>
						<br>
					<%	
					}
				}

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





