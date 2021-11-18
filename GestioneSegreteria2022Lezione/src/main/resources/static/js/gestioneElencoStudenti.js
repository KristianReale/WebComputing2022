

window.addEventListener("load", function(){
	aggiungiEventi();
	popolaTabella();	
});

function aggiungiEventi(){
	var btnAggiungi = document.querySelector("#btnInserisci");
	btnAggiungi.addEventListener("click", function(){
		var campoMatricola = document.querySelector("#campoMatricola");
		var campoCognome = document.querySelector("#campoCognome");
		var campoNome = document.querySelector("#campoNome");
		
		var matricola = campoMatricola.value;
		var cognome = campoCognome.value;
		var nome = campoNome.value;
		
		console.log(matricola);
		console.log(cognome);
		console.log(nome);
		
		var studente = new Studente(matricola, cognome, nome);
		
		studentiConId[matricola] = studente;
		
		aggiungiStudenteInTabella(studente);
		
	});
}


function popolaTabella(){
	for (const [chiave, studente] of Object.entries(studentiConId)){
		aggiungiStudenteInTabella(studente);
	}
}

function aggiungiStudenteInTabella(studente){
	var tableElement = document.querySelector("#tabellaStudenti");
	var riga = tableElement.insertRow(-1);
	//riga.innerHTML = "<td>" + studente.matricola + "</td>"
	//				+ "<td>" + studente.nome + "</td>"
	//				+ "<td>" + studente.cognome + "</td>";
	
	var cellaMatricola = riga.insertCell(0);
	cellaMatricola.textContent = studente.matricola;
	
	var cellaCognome = riga.insertCell(1);
	cellaCognome.textContent = studente.cognome;
	
	var cellaNome = riga.insertCell(2);
	cellaNome.textContent = studente.nome;
	

	

	
}
