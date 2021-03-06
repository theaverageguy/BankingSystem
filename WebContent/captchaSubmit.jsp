<%@ page import="nl.captcha.Captcha" %>
 <!DOCTYPE html>
<html lang="en">
<head>
		<!-- Meta information -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Title of the website -->
		<title>OnlineBankingSystem</title>
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

		<!-- Font awesome -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

		<!-- Custom CSS files -->
		<link rel="stylesheet" href="css/custom_style.css">

		<!-- Google Font -->
		<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"><img src="img/bank.png" height=80 width=100 style="margin-top: -30px"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li>
						<a href="/tranfer.html"><i class="fa fa-inr fa-lg"></i> Tranfer Money</a>
					</li>
					<li>
						<a href="#"><i class="glyphicon glyphicon-user"></i> Update Profile</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-question fa-lg"></i> FAQ</a>
					</li>
				</ul>
			</div>
		</nav>
			<header class="jumbotron jumb">
			<div class="container">
				<h2 style="text-decoration: underline; letter-spacing: 5px; font-family: 'Montserrat', sans-serif">Welcome</h2>
				<br>
				<h3 style="letter-spacing: 5px; font-family: 'Montserrat', sans-serif">Your Details</h3>
				<br>		  

<% 
// We're doing this in a JSP here, but in your own app you'll want to put
// this logic in your MVC framework of choice.

Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
request.setCharacterEncoding("UTF-8"); // Do this so we can capture non-Latin chars
String answer = request.getParameter("answer");
if (captcha.isCorrect(answer)) { %>


    <b>Transaction Successful!</b>
<% } else { %>
    <b>Transaction Unsuccessful!</b>
<% } %>
</div></header></body></html>