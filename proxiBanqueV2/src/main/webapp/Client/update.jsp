<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.gtm.service.ClientService"%>
<%@ page import="fr.gtm.domaine.Client"%>
<%@ page import="fr.gtm.dao.ClientDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fr.gtm.presentation.ListerClientServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="../assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>ProxyBanque</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />

        <!-- CSS Files -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <script src="assets/js/core/jquery.min.js"></script>
        <script src="assets/js/core/popper.min.js"></script>
        <script src="assets/js/core/bootstrap.min.js"></script>
        <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="assets/js/now-ui-dashboard.js?v=1.0.1"></script>

    </head>

    <body class="">
        <div class="wrapper ">
            <div class="sidebar" data-color="blue">
                <!--
            Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
                -->
                <div class="logo">

                    <a href="DemarrageServlet" class="simple-text logo-normal">
                        ProxiBanqueSI
                    </a>
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                    <li>
                            <a href="ListerClientServlet">
                                <i class="now-ui-icons users_single-02"></i>
                                <p>Clients</p>
                            </a>
                        </li>

					<li><a href="InitVirementServlet"> <i
							class="now-ui-icons location_map-big"></i>
							<p>Virement</p>
					</a></li>
					<li><a href="LogoutServlet"> <i
							class="now-ui-icons ui-1_bell-53"></i>
							<p>Logout</p>
					</a></li>
				</ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-transparent  navbar-absolute bg-primary fixed-top">
                    <div class="container-fluid">
                        <div class="navbar-wrapper">
                            <div class="navbar-toggle">
                                <button type="button" class="navbar-toggler">
                                    <span class="navbar-toggler-bar bar1"></span>
                                    <span class="navbar-toggler-bar bar2"></span>
                                    <span class="navbar-toggler-bar bar3"></span>
                                </button>
                            </div>
                            <a class="navbar-brand" href="DemarrageServlet">Accueil</a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-end" id="navigation">

                            <ul class="navbar-nav">

                                <li class="nav-item">

                                    <a class="nav-link" href="#pablo">
                                        <i class="now-ui-icons users_single-02"></i>
                                        <p>
                                            <span class="d-lg-none d-md-block">Account</span>
                                        </p>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- End Navbar -->
                <div class="panel-header panel-header-sm">
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title"> Modification d'un Client : </h4>

                                </div>
                                <div class="card-body">
                                         <form methode="get" action="UpdateUtilisationCLientServlet">
                                    <div class="row">
                                      <div class="col-md-12 px-1">
                                            <div class="form-group">
                                                <label>Id Client</label>
                                                <input type="text" name="idClient" class="form-control"  placeholder="idClient" value="<c:out value="${idClient}" />">
                                            </div>
                                        </div>
                                        <div class="col-md-4 px-1">
                                            <div class="form-group">
                                                <label>Nom</label>
                                                <input type="text" name="nomClient" class="form-control"  placeholder="Nom" value="<c:out value="${nom}" />">
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-1">
                                            <div class="form-group">
                                                <label for="Prenom">Prenom</label>
                                                <input type="text" class="form-control" name="prenomClient" placeholder="prenomClient" value="<c:out value="${prenom}" />">
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-1">
                                            <div class="form-group">
                                                <label for="Email">Email</label>
                                                <input type="text" class="form-control" name="emailClient" placeholder="Email" value="<c:out value="${email}" />">
                                            </div>
                                        </div>
                                    </div>
                                   
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Addresse :</label>
                                                <input type="text" name="adresseClient" class="form-control" placeholder="Home Address" value="<c:out value="${adresse}" />">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-1">
                                            <div class="form-group">
                                                <label>Code postal</label>
                                                <input type="text" name="codePostalClient" class="form-control" placeholder="CodePostal" value="<c:out value="${cdPostal}" />">
                                            </div>
                                        </div>
                                        <div class="col-md-6 px-1">
                                            <div class="form-group">
                                                <label>Ville</label>
                                                <input type="text" name="villeClient" class="form-control" placeholder="ville" value="La <c:out value="${ville}" />">
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                <button id="singlebutton" name="singlebutton" class="btn btn-primary btn-block  ">Modifier</button>
                                        </div>
                                    </div>
                                </form>
                                    
                                    
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <footer class="footer">
                    <div class="container-fluid">

                        <div class="copyright">

                            Designed by Tarik & Mehdi &copy;

                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </body>
    <!--   Core JS Files   -->


</html>
