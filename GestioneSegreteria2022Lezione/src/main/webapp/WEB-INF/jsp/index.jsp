<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Gestione Segreteria universitaria</title>
		<link rel="icon" href="immagini/segreteria.jpg" type="image/x-icon"/>
		
		 
		<link href="css/indexCSS.css" rel="stylesheet" type="text/css" />
		<!-- 
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		-->
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</head>

	<body>
		<aside >
			<img id="logo_unical" src="immagini/unical.jpg" />
		</aside>
	
		<div class="container-fluid">
			<header class="row">
				<figure class="col-md-4 col-lg-4" id="logo_segreteria">
					<a href="https://www.treccani.it/vocabolario/segreteria/">
						<img src="immagini/segreteria.jpg" />
					</a>
					<figcaption>Questa è la nostra segreteria</figcaption>
				</figure>
				<h1 class="col-md-6 col-lg-6" id="titolo">Sito di Gestione della Segreteria</h1>
			</header>
		</div>
		
		${username}
		
		<a href="paginaLogin">Login</a>
		
		<p>Benvenuti nel nostro <i>sito</i> per la <u>gestione</u>  degli <strong>studenti iscritti</strong>, 
		dei <strong>dipartimenti</strong> e dei <strong>corsi di laurea</strong></p>
		<p><h2>
			Attraverso questa pagina puoi accedere a tutte le funzionalità
			</h2>
			</font></p>
		<nav class="navbar navbar-expand-sm navbar-light bg-light">
			<ul class="navbar-nav">
				<li class="nav-item"> 
					<a class="nav-link" href="#">Home</a>
				</li>
				<li class="nav-item dropdown ">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Studenti</a>
					<ul class="dropdown-menu ">
						<li><a class="dropdown-item" href="gestioneStudenti/elenco_studenti.html">Elenco Studenti</a></li>
						<li><a class="dropdown-item" href="gestioneStudenti/iscrivi_studente.html">Iscrivi uno Studente</a></li>
					</ul>
					
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#"> Elenco Dipartimenti </a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="gestioneCorsiDiLaurea/elenco_corsi_di_laurea.html">
						Elenco Corsi di Laurea
					</a>
				</li>
			</ul>
		</nav>
		
		<div class="container-fluid">
			<section class="row">
				<article class="col-md-4 col-lg-4">
					<h2 class="titolo">Come iscriversi all'università </h2>
					<p>Per inscriversi seguire la seguente procedura....</p>
				</article>
				<article class="col-md-4 col-lg-4">
					<h2>Come pagare le tasse</h2>
					<p>Per pagare le tasse è necessario scaricare un bollettino.... Per pagare le tasse è necessario scaricare un bollettino....Per pagare le tasse è necessario scaricare un bollettino....Per pagare le tasse è necessario scaricare un bollettino....Per pagare le tasse è necessario scaricare un bollettino....Per pagare le tasse è necessario scaricare un bollettino....Per pagare le tasse è necessario scaricare un bollettino....</p>
				</article>
				<article class="col-md-4 col-lg-4">
					<h2 class="titolo">Dicono di noi</h2>
					<p>La nostra segreteria, secondo le ultime recensioni, è molto....</p>
				</article>
			</section>
		</div>
		
		<footer>
				<p>
					<small>
						Per maggiori informazioni sui nostri servizi contattaci all'indirizzo <a href="mailto:reale@mat.unical.it"> reale@mat.unical.it</a>
					</small>
				</p>
				<p>
					<small>
						<a href="privacy.html">Informativa sulla privacy</a>
					</small>
				</p>
			
		</footer>
	</body>
	

</html>