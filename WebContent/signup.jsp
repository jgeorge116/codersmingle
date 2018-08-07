<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[


function Submit_onclick() {
if(document.registerForm.SSN.value == ""
	|| document.registerForm.telephone.value == ""
	|| document.registerForm.password.value == ""
	|| document.registerForm.lastName.value == ""
	|| document.registerForm.firstName.value == ""
	|| document.registerForm.email.value == ""
	|| document.registerForm.address.value == ""
	|| document.registerForm.city.value == ""
	|| document.registerForm.state.value == ""
	|| document.registerForm.zip.value == ""
	|| document.registerForm.creditCard.value == ""	){
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
						<li class = "heading_li"><a class = "heading_option" href="login.jsp">Log-in</a></li>
						<li class = "heading_li"><a class = "heading_option_selected" href="">Sign-Up</a></li>
						<li class = "heading_li"><a class = "heading_option" href="">Contact</a>		</li>
						<li class = "heading_li"><a class = "heading_option" href="">About</a>		</li>
					</ul>
				</div>
			</div>



				<div class="row main" style="margin-right: 0px !important;">
		<div class="col-md-1"></div>
		<div class="col-md-5">
			<h1>Register</h1>
			<form name="registerForm" action="signup" method="post">
				<div class="form-group">
					<label for="SSN">SSN / ID Number</label> <input type="text"
						class="form-control" name="SSN" id="SSN" placeholder="111-11-1111">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="profileid">ProfileID </label> <input
						type="text" class="form-control" name="profileid" id="profileid"
						placeholder="123dog">
				</div>
				
				<div class="form-group">
					<label for="password">Password</label> <input
						type="text" class="form-control" name="password" id="password"
						placeholder="************">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="telephone">Telephone Number</label> <input
						type="text" class="form-control" name="telephone" id="telephone"
						placeholder="333-333-3333">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="lastName">Last Name</label> <input type="text"
						class="form-control" name="lastName" id="lastName"
						placeholder="Smolka">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="firstName">First Name</label> <input type="text"
						class="form-control" name="firstName" id="firstName"
						placeholder="Scott">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="mf">Gender</label> <input type="text"
						class="form-control" name="mf" id="mf"
						placeholder="Male">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="email">Email</label> <input type="text"
						class="form-control" name="email" id="email"
						placeholder="sas@cs.stonybrook.edu">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<label for="address">Address</label> <input type="text"
						class="form-control" name="address" id="address"
						placeholder="New CS 117">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="city">City</label> <input type="text"
						class="form-control" name="city" id="city"
						placeholder="Stony Brook">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="state">State</label> <input type="text"
						class="form-control" name="state" id="state" placeholder="NY">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="zip">Zip Code</label> <input type="text"
						class="form-control" name="zip" id="zip" placeholder="11790">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="age">Age</label> <input
						type="text" class="form-control" name="age" id="age"
						placeholder="23">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="datingagerangestart">Dating Age Range Start</label> <input
						type="text" class="form-control" name="datingagerangestart" id="datingagerangestart"
						placeholder="20">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="datingagerangeend">Dating Age Range End</label> <input
						type="text" class="form-control" name="datingagerangeend" id="datingagerangeend"
						placeholder="25">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="datinggeorange">Dating Geo Range</label> <input
						type="text" class="form-control" name="datinggeorange" id="datinggeorange"
						placeholder="40">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="hobbies">Hobbies</label> <input
						type="text" class="form-control" name="hobbies" id="hobbies"
						placeholder="you;)">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="height">Height</label> <input
						type="text" class="form-control" name="height" id="height"
						placeholder="5.8">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="weight">Weight</label> <input
						type="text" class="form-control" name="weight" id="weight"
						placeholder="270">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="haircolor">Hair Color</label> <input
						type="text" class="form-control" name="haircolor" id="haircolor"
						placeholder="red">
						<span class="focus-border"></span>
				</div>
				
				<div class="form-group">
					<label for="creditCard">Credit Card Number</label> <input
						type="text" class="form-control" name="creditCard" id="creditCard"
						placeholder="0123-4567-7890-1234">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<div class="form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="userType"
							value="U" checked> Free - User Tier: 
							Lowest Priority (Default);

						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="userType"
							value="G"> $50/year - Good Tier:

							Middle Range Priority for Dates;

						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="userType"
							value="S"> $100/year - Super Tier:

							Highest Range Priority for all aspects of codersmingle
						</label>
					</div>

					<br>
					<div class="form-group">
						<input type="submit" class="btn"
							onclick="return Submit_onclick()">
					</div>
				</div>
			</form>
		</div>
	</div>

			
		</div>


	</body>

	
</html>





