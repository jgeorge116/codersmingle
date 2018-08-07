<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[

function validYear(year){
	var isValid = true;
	for(var i = 0; i < 4; i ++ ){
		if(isNaN(year.charAt(i) - '0')){
			isValid &= false;
		}
	}
	return isValid;
}


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

	if(document.registerForm.SSN.value == "" && ( document.registerForm.year.value == "" || 
		document.registerForm.month.value == "" || 
		document.registerForm.day.value == "" || document.registerForm.year2.value == "" || 
		document.registerForm.month2.value == "" || 
		document.registerForm.day2.value == ""  )){
		return false;
	}



	var isValid = true;

	if(document.registerForm.SSN.value == ""){
		if(document.registerForm.year.length != 4 || document.registerForm.month.length != 2 || document.registerForm.day.length != 2){
			return false;
		}

		isValid &= validYear(document.registerForm.year.value);
		isValid &= validMonth(document.registerForm.month.value);
		isValid &= validDay(document.registerForm.day.value);
		isValid &= validYear(document.registerForm.year2.value);
		isValid &= validMonth(document.registerForm.month2.value);
		isValid &= validDay(document.registerForm.day2.value);

		if(isValid){
			isValid &= isValidDate(parseInt(document.registerForm.month.value), parseInt(document.registerForm.date.value), parseInt(document.registerForm.year.value));
			isValid &= isValidDate(parseInt(document.registerForm.month2.value), parseInt(document.registerForm.date2.value), parseInt(document.registerForm.year2.value));
		}

	}
	


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
			<label class = "instructions">
				Get list of dates by profile or calendar dates </label>
				<form name="produceListOfDates" action="produceListOfDates" method="post">
					<div class="form-group">
						<label for="SSN">Profile</label> <input type="text"
						class="form-control" name="SSN" placeholder="My ID" id = "SSN">
					</div>
					
					<br>
					<hr>
					OR
					<hr>

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
					<br>

					<div class="form-group">
						<label for="year2">End Date (YYYY): </label> <input
							type="text" class="form-control" name="year2" id="year2"
							placeholder="2017">
							<span class="focus-border"></span>
					</div>
					<div class="form-group">
						<label for="month2">End Date (MM): </label> <input
							type="text" class="form-control" name="month2" id="month2"
							placeholder="10">
							<span class="focus-border"></span>
					</div>
					<div class="form-group">
						<label for="day2">End Date (DD): </label> <input
							type="text" class="form-control" name="day2" id="day2"
							placeholder= "04">
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





