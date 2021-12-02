package com.gestionesegreteria;

import java.util.ArrayList;
import java.util.List;

import com.gestionesegreteria.model.Studente;

public class Database {
	public static List<Studente> dammiStudenti(){
		List<Studente> studenti = new ArrayList<Studente>();
		
		studenti.add(new Studente("123321", "Bianchi", "Bruno"));
		studenti.add(new Studente("123456", "Rossi", "Mario"));
		studenti.add(new Studente("132111", "Verdi", "Giulia"));
		
		return studenti;
	}
}
