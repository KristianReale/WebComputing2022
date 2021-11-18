//alert("Servizi Studenti");

function Studente(matricola, cognome, nome, numeroComponenti){
	this.matricola = matricola;
	this.cognome = cognome;
	this.nome = nome;
	this.numeroComponenti = numeroComponenti;

	this.dammiInfo = function(){
		return this.matricola + " " + this.nome + " " + this.cognome;
	}
}

/*
elencoStudenti = new Array();
elencoStudenti.push(new Studente("123456", "Rossi", "Mario"));
elencoStudenti.push(new Studente("123321", "Bianchi", "Bruno"));
elencoStudenti.push(new Studente("132111", "Verdi", "Giulia"));
*/

studentiConId = {
	"123456": new Studente("123456", "Rossi", "Mario"),
	"123321": new Studente("123321", "Bianchi", "Bruno"),
	"132111": new Studente("132111", "Verdi", "Giulia")
}