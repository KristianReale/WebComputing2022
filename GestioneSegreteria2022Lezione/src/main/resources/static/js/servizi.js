function prendiStudente(matricola){
	return studentiConId[matricola];
}


function prendiMatricolaPassata(){
	urlStringa = window.location;
	url = new URL(urlStringa);
	var matricola = url.searchParams.get("matricola");
	return matricola;
}

function calcolaISEE(){
	console.log(prendiMatricolaPassata());
	studente = prendiStudente(prendiMatricolaPassata());
	alert(studente.dammiInfo());
	//ISEE
	//Numero componenti nucleo familiare
	//Reddito dei componenti
	//Patrimonio dei componenti
	
	if(typeof studente.numeroComponenti === 'undefined') {	
		studente.numeroComponenti = prompt("Inserisci il numero dei componenti");
	}else{
		alert("Numero componenti: " + studente.numeroComponenti);
	}
	
	redditi = new Array();
	patrimoni = new Array();
	
	for (var i = 0; i < studente.numeroComponenti; i++){
		redditi[i] = prompt("Inserisci il reddito del componente " + (i + 1) );
		patrimoni[i] = prompt("Inserisci il patrimonio del componente " + (i + 1) );
	} 
	
	ISR = 0;
	ISP = 0;
	riepilogo = "";
	for (var i = 0; i < studente.numeroComponenti; i++){
		riepilogo += "Reddito " + (i + 1) + ": " + redditi[i] + "\n";
		riepilogo += "Patrimonio " + (i + 1) + ": " + patrimoni[i] + "\n";
		
		ISR += parseInt(redditi[i]);
		ISP += parseInt(patrimoni[i]);
	}
	
	ISE = ISR + ISP * 20/100;
	
	console.log(riepilogo);
	console.log("ISP " + ISP);
	console.log("ISR " + ISR);
	console.log("ISE " + ISE);
	
	// 1 -> 1
	// 2 -> 1.57
	// 3 -> 2.04
	// 4 -> 2.46
	// >5 -> 2.85
	
	scalaEquivalenza = {
		1: 1,
		2: 1.57,
		3: 2.04,
		4: 2.46,
		me5: 2.85
	};
	
	if (numeroComponenti < 5){
		SE = scalaEquivalenza[numeroComponenti];
	}else{
		SE = scalaEquivalenza["me5"];
	}
	console.log("SE " + SE);
	
	ISEE = ISE / SE;
	console.log("ISEE " + ISEE);
	return ISEE;
}

