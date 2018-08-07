<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[
	//check for valid input or nah

function validYear(year){
	var isValid = true;
	for(var i = 0; i < 4; i ++ ){
		if(isNaN(year.charAt(i) - '0')){
			isValid &= false;
		}
	}
	return isValid;
}

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
	var isValid = true;

	if(document.registerForm.year.value == "" || document.registerForm.month.value == "" ){
	    alert("Fields cannot be empty");
	    return false;
	}
	if(document.registerForm.initYear.value == "" || document.registerForm.initMonth.value == "" ){
	    alert("Fields cannot be empty");
	    return false;
	}

	isValid &= validYear(document.registerForm.year);
	isValid &= validMonth(document.registerForm.month);

	if(isValid){
		isValid &= isValidDate(parseInt(document.registerForm.month), 1, parseInt(document.registerForm.year))
	}


	isValid &= validYear(document.registerForm.initYear);
	isValid &= validMonth(document.registerForm.initMonth);

	if(isValid){
		isValid &= isValidDate(parseInt(document.registerForm.initMonth), 1, parseInt(document.registerForm.initYear))
	}


	/**
		Make function to check for invalid/valid date combos
		return false if inValid;
	
	

		
	**/


	if(!isValid){
		return isValid;
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
			<form name="registerForm" action="salesReportServlet" method="post">
				<div class="form-group">
					<label for="initMonth">Start Month</label> <input type="text"
						class="form-control" name="initMonth" id="initMonth" placeholder="10">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="initYear">Start Year</label> <input type="text"
						class="form-control" name="initYear" id="initYear" placeholder="2014">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="month">End Month</label> <input type="text"
						class="form-control" name="month" id="month" placeholder="10">
						<span class="focus-border"></span>
				</div>
				<div class="form-group">
					<label for="year">End Year</label> <input type="text"
						class="form-control" name="year" id="year" placeholder="2017">
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





