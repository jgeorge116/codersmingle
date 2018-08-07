<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[

		function Submit_onclick() {
		if(document.loginForm.account.value == ""
			|| document.loginForm.userID.value == ""
			|| document.loginForm.telephone.value == ""){
			    alert("Fields cannot be empty");
			    return false;
			}
		javascript:loginForm.submit();
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
						<li class = "heading_li"><a class = "heading_option_selected" href="login.jsp">Log-in</a></li>
						<li class = "heading_li"><a class = "heading_option" href="signup.jsp">Sign-Up</a></li>
						<li class = "heading_li"><a class = "heading_option" href="">Contact</a>		</li>
						<li class = "heading_li"><a class = "heading_option" href="">About</a>		</li>
					</ul>
				</div>
			</div>



			<div class="container default">
				<div class="row main" style="margin-right: 0px !important;">
				<div class="col-md-1"></div>
					<div class="col-md-5">

						<label class = "instructions">Log in</label>
						<form name="loginForm" action="login" method="post">
							<div class="form-group">
								<label for="userID">User ID</label> <input type="text"
								class="form-control" name="userID" placeholder="My ID">
								<span class="focus-border"></span>
							</div>
							<div class="form-group">
								<label for="pass">Password</label> <input
								type="password" class="form-control" name="pass"
								placeholder="">
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


