<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[
	//check for valid input or nah
function validMonth(month){
	var isValid = true;
	for(var i = 0; i < 2; i ++ ){
		if(isNaN(month.charAt(i) - '0')){
			isValid &= false;
		}
	}

	if(isValid){ 
		if(parseInt(month)){
			isValid = (1 <= isValid && isValid <= 12);
		}
	}

	return isValid;
}

function validDay(day){
	var isValid = true;

	for(var i = 0; i < 2; i++){
		if(isNaN(document.registerForm.day.charAt(i) - '0')){
			isValid &= false;
		}
	}


	if(isValid){ 
		if(parseInt(month)){
			isValid = (1 <= isValid && isValid <= 31);
		}
	}
	return isValid;
}

function validYear(year){
	var isValid = true;
	for(var i = 0; i < 4; i ++ ){
		if(isNaN(year.charAt(i) - '0')){
			isValid &= false;
		}
	}
	return isValid;
}

function validPay(pay){
	var isValid = true;
	for(var i = 0; i < pay.length; i++){
		if(!('0' <= pay.charAt(i) && pay.charAt(i) <= '9')){
			isValid = false;
		}
	}
	return isValid
}

function isValidDate(month, date, year){
	var isValid = false;
	if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
		if(1 <= date && date <= 31){
			isValid = true;
		}
	}

	if(month == 2){
		if(1 <= date && date <= 28){
			isValid = true;
		}
	}

	if(month == 4 || month == 6 || month == 9 || month == 11){
		if(1 <= date && date <= 30){
			isValid = true;
		}
	}

	return isValid;
}


function Submit_onclick() {
	if(document.registerForm.SSN.value == "" || 
		document.registerForm.telephone.value == ""
	|| document.registerForm.password.value == ""
	|| document.registerForm.lastName.value == ""
	|| document.registerForm.firstName.value == ""
	|| document.registerForm.email.value == ""
	|| document.registerForm.address.value == ""
	|| document.registerForm.city.value == ""
	|| document.registerForm.state.value == ""
	|| document.registerForm.zip.value == ""
	||
		document.registerForm.year.value == "" || 
		document.registerForm.month.value == "" || 
		document.registerForm.day.value == "" || 
		document.registerForm.pay.value == ""){
	    alert("Fields cannot be empty");
	    return false;
	}





	var isValid = true;



	if(!isValid){
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
			<div class="col-md-1"></div>
			<div class="col-md-5">
			<form name="registerForm" action="addNewEmployee" method="post">
				<div class="form-group">
					<label for="SSN">SSN / ID Number</label> <input type="text"
						class="form-control" name="SSN" id="SSN" placeholder="111-11-1111">
						<span class="focus-border"></span>
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
					<label for="year">Start Date (YYYY): </label> <input
						type="text" class="form-control" name="year" id="year"
						placeholder="2017">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="month">Start Date (MM): </label> <input
						type="text" class="form-control" name="month" id="month"
						placeholder="10">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="day">Start Date (DD): </label> <input
						type="text" class="form-control" name="day" id="day"
						placeholder= "04">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="pay">Hourly Rate: </label> <input
						type="text" class="form-control" name="pay" id="pay"
						placeholder= "04">
						<span class="focus-border"></span>
				</div>

				<div class="form-group">
					<div class="form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="role"
							value="C" checked> Customer Rep.

						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="role"
							value="M"> Manager
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

			
		</div>


	</body>

	
</html>





