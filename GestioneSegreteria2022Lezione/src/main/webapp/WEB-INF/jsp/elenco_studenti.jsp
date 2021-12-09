<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Elenco Studenti</title>
		
		<link href="../css/common.css" rel="stylesheet" type="text/css" />
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
		
		<script language="javascript" src="../js/modelloDati.js"></script>
		<script language="javascript" src="../js/gestioneElencoStudenti.js"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	</head>

	<body>
		<h1>Elenco Studenti</h1>
		<form method="GET" action="/provaaa" >
		<table id="tabellaStudenti" class="table table-striped ">
			<thead>
				<tr>
					<th><input type="checkbox" /></th>
					<th>Matricola</th>
					<th>Cognome</th>
					<th>Nome</th>					
					<th>AZIONI</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studenti}" var="stud">
					<tr>
						<td><input id="${stud.matricola}" type="checkbox" /></td>
						<td>${stud.matricola}</td>
						<td>${stud.cognome}</td>
						<td>${stud.nome}</td>
					</tr>
				</c:forEach>					
			</tbody>
		</table>
		</form>
		
		<input class="btn btn-danger" id="btnCancella" type="button" value="Cancella studente" />
		<br/>
		<input class="btn btn-warning" id="btnModifica" type="button" value="Modifica studente" />
		<br/>
		<input id="campoMatricola" type="text" placeholder="Inserisci la matricola" />
		<input id="campoCognome" type="text" placeholder="Inserisci il cognome" />
		<input id="campoNome" type="text" placeholder="Inserisci il nome" />
		<input class="btn btn-primary" id="btnInserisci" type="button" value="Inserisci studente" />
		
		<a href="../">Torna alla home page</a>

	</body>
	

</html>