<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<link rel="stylesheet" href="css/style.css">


	<script language="javascript" type="text/javascript">
		// <!CDATA[
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
				<a href = "./addDate.jsp" >
					<button type="submit"  class = "option_button" name="action" value="MakeADate" >
						Make a Date
					</button>
				</a>
				<br>
				<a href = "./addGeoDate.jsp">
					<button type="submit"  class = "option_button" name="action" value="MakeGeoDate">
						Make a Geo-Date
					</button>
				</a>
				<br>
				<a href = "./setGeoLocation.jsp">
					<button type="submit"  class = "option_button" name="action" value="MakeGeoDate">
						Set Geo-Location (Others will See this!)
					</button>
				</a>
				<br>


				<a href = "./cancelDate.jsp">
					<button type="submit" class = "option_button" name="action" value="CancelDate">
						Cancel a Date
					</button>
				</a>
				<br>


				<a href = "./commentOnDate.jsp">
					<button type="submit"  class = "option_button" name="action" value="CommentOnDate">
						Comment On a Date
					</button>
				</a>
				<br>

				<a href = "./blindDate.jsp">
					<button type="submit"  class = "option_button" name="action" value="BlindDate">
						Refer Someone For a BlindDate
					</button>
				</a>
				<br>


				<a href = "./viewPendingDates.jsp">
					<button type="submit" class = "option_button" name="action" value="GetPendingDates">
						View Pending Dates
					</button>
				</a>
				<br>

				<a href = "./viewPastDates.jsp">
					<button type="submit" class = "option_button" name="action" value="GetPastDates">
						View Past Dates
					</button>
				</a>
				<br>

				<a href = "./viewFavorites.jsp">
					<button type="submit" class = "option_button" name="action" value="favoritesList">
						View Favorite's List (Based On Likes)
					</button>
				</a>
				<br>

				<a href = "./viewProfilesBasedOnPhysicalAttributes.jsp">
					<button type="submit" class = "option_button" name="action" value="SearchProfile">
						Search for Someone Based On Physical Attributes
					</button>
				</a>
				<br>

				<a href = "./viewMostActiveProfiles.jsp">
					<button type="submit" class = "option_button" name="action" value="getMostActiveProfiles">
						See Most Active Profiles
					</button>
				</a>
				<br>

				<a href = "./viewHighestRatedProfiles.jsp">
					<button type="submit" class = "option_button" name="action" value="getHighestRatedProfiles">
						See Highest Rated Profiles
					</button>
				</a>
				<br>


				<a href = "./rateDate.jsp">
					<button type="submit" class = "option_button" name="action" value="getHighestRatedProfiles">
						Rate a Date
					</button>
				</a>
				<br>


				<a href = "./likeProfile.jsp">
					<button type="submit" class = "option_button" name="action" value="getHighestRatedProfiles">
						Like a Profile
					</button>
				</a>
				<br>

				<a href = "./viewPopularGeoLocations.jsp">
					<button type="submit" class = "option_button" name="action" value="getMostPopularGeoLocations">
						See Most Popular Geo-Locations
					</button>
				</a>
				<br>

				<a href = "./showPersonalizedSuggestionList.jsp">
					<button type="submit" class = "option_button" name="action" value="getDateSuggestions">
						Get Personalized Date Suggestions
					</button>
				</a>
				<br>

			</div>
		</div>

		</div>

			
		</div>


	</body>

	
</html>
