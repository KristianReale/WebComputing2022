

window.addEventListener("load", function(){
	aggiungiEventi();
	//popolaTabella();	
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
		
		campoMatricola.value = "";
		campoCognome.value = "";
		campoNome.value = "";
		
		console.log(matricola);
		console.log(cognome);
		console.log(nome);
		
		var studente = new Studente(matricola, cognome, nome);
		
		studentiConId[matricola] = studente;
		
		aggiungiStudenteInTabella(studente);
		
	});
	
	btnCancella.addEventListener("click", function(){
		var selectedCheckBoxes = document.querySelectorAll("input:checked");
		
		if (selectedCheckBoxes.length > 0){
			selectedCheckBoxes.forEach(function(checkBox, indice){
				console.log(checkBox);
				console.log(checkBox.getAttribute("id"));
				
				var matricola = checkBox.getAttribute("id");
				var studente = studentiConId[matricola];
				console.log(studente.nome);
				
				delete studentiConId[matricola];
				
				cancellaStudenteDaTabella(studente);
				
			});
		}else{
			alert("Si prega di selezionare almeno un elemento");
		}
		
	});
	
	var butModifica = document.getElementById("btnModifica");
	butModifica.addEventListener("click", modificaStudente);
	
}

function cancellaStudenteDaTabella(studente){
	var rigaDaCancellare = document.querySelector("#riga_" + studente.matricola);
	rigaDaCancellare.remove();
}


function popolaTabella(){
	for (const [chiave, studente] of Object.entries(studentiConId)){
		aggiungiStudenteInTabella(studente);
	}
}

function aggiungiStudenteInTabella(studente){
	var tableElement = document.querySelector("#tabellaStudenti tbody");
	var riga = tableElement.insertRow(-1);
	//riga.innerHTML = "<td>" + studente.matricola + "</td>"
	//				+ "<td>" + studente.nome + "</td>"
	//				+ "<td>" + studente.cognome + "</td>";
	
	riga.setAttribute("id", "riga_" + studente.matricola);
	
	var cellaCheckbox = riga.insertCell(0);
	cellaCheckbox.innerHTML = "<input id=\"" + studente.matricola + "\" type=\"checkbox\" />";
	
	
	var cellaMatricola = riga.insertCell(1);
	cellaMatricola.textContent = studente.matricola;
	
	var cellaCognome = riga.insertCell(2);
	cellaCognome.textContent = studente.cognome;
	
	var cellaNome = riga.insertCell(3);
	cellaNome.textContent = studente.nome;
}

function modificaStudente(){
	var checkBox = document.querySelector('tbody input:checked');
	if (checkBox != null){
		let matricola = checkBox.getAttribute("id");
		studenteDaModificare = studentiConId[matricola];
		
		var matr = document.querySelector("#campoMatricola").value;				
		var cogn = document.querySelector("#campoCognome").value;
		var nome = document.querySelector("#campoNome").value;
	
		studenteDaModificare.matricola = matr;
		studenteDaModificare.cognome = cogn;
		studenteDaModificare.nome = nome;
		
		modificaDaTabella(matricola, studenteDaModificare);
		
	}
}

function modificaDaTabella(matricola, studente){
	var row = document.getElementById("riga_" + matricola);	
	row.innerHTML = "<tr id=\"riga_" + studente.matricola + "\"><td><input id=\"" + studente.matricola + "\" type=\"checkbox\"></td><td>" + studente.matricola + "</td><td>" + studente.cognome + "</td><td>" + studente.nome + "</td></tr>";
}


