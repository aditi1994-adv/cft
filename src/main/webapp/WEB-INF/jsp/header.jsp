<!DOCTYPE html>
<%@ page import="com.cft.model.AuditLogs" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>CCT | Connecting Companies Together</title>
<link rel="stylesheet"
	href="resource/assets/libs/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resource/assets/libs/material-design-iconic-font/css/material-design-iconic-font.min.css">
<link rel="stylesheet"
	href="resource/assets/libs/jquery-ui/jquery-ui.min.css">
<link rel="stylesheet"
	href="resource/assets/libs/rslides/responsiveslides.css">
<link rel="stylesheet" href="resource/assets/libs/slick/slick.css">
<link rel="stylesheet" href="resource/assets/css/main.css">
<link rel="stylesheet" href="resource/assets/css/chat.css">
<link rel="stylesheet" href="resource/assets/css/agent_chat.css">
<link rel="stylesheet" href="resource/assets/css/aos.css">
<link rel="stylesheet" href="resource/assets/css/captcha.css">
<script src="resource/assets/libs/jquery/jquery.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Work+Sans:400,500,600%7CMontserrat:300,400,600%7CRaleway:300,400,400i,600%7COpen+Sans:400,400i%7CVarela+Round">
<link href="https://fonts.googleapis.com/css?family=Anton&display=swap"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Oswald&display=swap"
	rel="stylesheet">
	
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"> 
    

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="resource/assets/css/richtext.min.css">
      
      <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"> -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
      
      
</head>
<body id="index1" class="homepage">
<style>

ul.chat-list-details.chat-user-list {
    font-size: small;
}

.logo-img{
background: #003e75;
    border-radius: 50%;
    width: 70px;
    padding: 5px;
    margin: 0 10px 0 0;
}

.logo-img-footer{

    border-radius: 50%;
    width: 70px;
   
    margin: 0 10px 0 0;
}
</style>
	<header class="header-top">
		<div class="container">
			<div id="topbar">
				<h1 class="logo">
				
				
					<a href="index"> <!-- <img src="" alt="CCT"> --><img alt="" class="logo-img" src="resource/assets/images/new_cct_logo.png">Connecting
						Companies Together
					</a>
				</h1>
				<div>
					<!-- <input type="search" name="search" class="search-header from-control" placeholder="Search..."> -->
					<a href="contact"><i class="zmdi zmdi-phone"></i> Contact</a>

					<%
					
					AuditLogs str=	(AuditLogs)	session.getAttribute("customerSession");
					if (session.getAttribute("customerSession") != null) {
					%>

					<a href="logOut" id="logout-session-show" onclick="return logoutFunction();"><i
						class="zmdi zmdi-power"></i> logout</a>
					<%
						}
						else{
					String shipmentId=	(String)session.getAttribute("shipmentIdSession");
							%>
							
							
							<a href="javascript:void(0)" id="logout-session"><i
						class="zmdi zmdi-power"></i> logout</a>
							<%
						}	%>

				</div>
			</div>
		</div>
		<div class="navigation">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<i class="zmdi zmdi-menu zmdi-hc-lg"></i>
			</button>
			<nav class="collapse navbar-collapse" id="myNavbar">
				<ul>
					<!-- <li class=""><a href="index">Home</a></li> -->
					<li class=""><a href="freightforwarding">Freight
							Forwarders platform</a>   </li>
							
					<li class=""><a href="document">International trading platform</a></li>
					<li class=""><a href="projectManagement">Project
							management services</a></li>
					<li class="login-service"><a href="servicelogin">Online customer services
							</a></li>
					<li class="dropdown d-none"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">Online customer services<b class="caret"></b>
					</a>
						<ul class="dropdown-menu custom-dropdown-menu">
							<li><a href="customerdashboard">Customer Dashboard/ Chat
									with Both Agencies</a></li>
							<li><a href="emailMarketing">Email Marketing</a> <!-- <ul class="dropdown-menu custom-dropdown-menu">
						    <li><a href="customerdashboard">Customer Dashboard/ Chat with Both Agencies</a></li>
						    <li><a href="emailMarketing">Email Marketing</a></li>
						  </ul> --></li>
						</ul></li>
					
					
				 	<!-- <li class=""> <a href="advertisement">advertisement</a></li>  -->
					<%-- <%
					if (session.getAttribute("customerSession") != null) {
					%>
					<li class=""> <a href="advertisement">Email marketing</a></li>
					<%
					}
					%> --%>
				<li class=""><a href="about">About Us</a></li>
				</ul>
			</nav>
		</div>
	</header>
	