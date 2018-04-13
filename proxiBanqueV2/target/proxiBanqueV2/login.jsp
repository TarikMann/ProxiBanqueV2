<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr" data-textdirection="ltr" class="loading">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">



<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">


<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">
<script src="assets/js/core/jquery.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>


<!-- END Custom CSS-->
</head>
<body data-open="click" data-menu="vertical-menu" data-col="1-column"
	class="vertical-layout vertical-menu 1-column  blank-page blank-page">
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<div class="container">
		<h1 class="welcome text-center">ProxiBanque</h1>


		<div class="card card-container">
			<h2 class='login_title text-center'>
				<br>Identification 
			</h2>
			<hr>
			<p class="text-danger">
				<c:out value="${erreur}" />
			</p>
			<form class="form-signin" action="IdentificationServlet">
				<span id="reauth-email" class="reauth-email"></span>
				<p class="input_title">Login</p>
				<input type="text" id="logConseiller" name="logConseiller"
					class="login_box" placeholder="login" required autofocus>
				<p class="input_title">Password</p>
				<input type="password" id="psswrdConseiller" name="psswrdConseiller"
					class="login_box" placeholder="******" required>
				<div id="remember" class="checkbox">
					<label> </label>
				</div>
				<button class="btn btn-lg btn-primary" type="submit">Connexion</button>
			</form>
			<!-- /form -->
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->

</body>
</html>
