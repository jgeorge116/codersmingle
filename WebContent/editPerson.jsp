<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[

function Submit_onclick() {
	if(document.editPersonForm.SSN.value == "" || 
		document.editPersonForm.pass.value == "" || 
		document.editPersonForm.firstName.value == "" || 
		document.editPersonForm.lastName.value == "" || 
		document.editPersonForm.street.value == "" || 
		document.editPersonForm.city.value == "" || 
		document.editPersonForm.state.value == "" || 
		document.editPersonForm.zipcode.value == "" || 
		document.editPersonForm.email.value == "" || 
		document.editPersonForm.telephone.value == ""){
	    alert("Fields cannot be empty");
	    return false;
	}

	
	if (isNaN(document.editPersonForm.zipcode - '0') || document.editPersonForm.zipcode.length != 5) {
		return false;
	}

	javascript:editPersonForm.submit();
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
		<label class = "instructions">
			Enter the SSN of the Person and all the information with the changes.</label>

		<div class="row main" style="margin-right: 0px !important;">
			<div class="col-md-1"></div>
			<div class="col-md-5">
			<form name="editPersonForm" action="editPerson" method="post">
			
				<div class="form-group">
					<label for="SSN">SSN / ID Number</label> <input type="text"
						class="form-control" name="SSN" id="SSN" placeholder="111-11-1111">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="pass">Password</label> <input
						type="password" class="form-control" name="pass" placeholder="password">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="firstName">First Name</label> <input type="text"
						class="form-control" name="firstName" id="firstName" placeholder="first name">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="lastName">Last Name</label> <input type="text"
						class="form-control" name="lastName" id="lastName" placeholder="last name">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="street">Street</label> <input type="text"
						class="form-control" name="street" id="street" placeholder="100 Nicolls Rd">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="city">City</label> <input type="text"
						class="form-control" name="city" id="city" placeholder="Stony Brook">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="state">State</label> <input type="text"
						class="form-control" name="state" id="state" placeholder="New York">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="zipcode">Zipcode</label> <input type="text"
						class="form-control" name="zipcode" id="zipcode" placeholder="11790">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="email">Email</label> <input type="text"
						class="form-control" name="email" id="email" placeholder="scott.smolka@stonybrook.edu">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="telephone">Telephone</label> <input type="text"
						class="form-control" name="telephone" id="telephone" placeholder="(631) 632-6000">
						<span class="focus-border"></span>
				</div>

				<br>
				<div class="form-group">
					<input type="submit" class="btn"
						onclick="return Submit_onclick()">
				</div>

			</form>

			</div>
		</div>

		</div>

			
		</div>


	</body>

	
</html>