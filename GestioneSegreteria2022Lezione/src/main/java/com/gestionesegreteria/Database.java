package com.gestionesegreteria;

import java.util.ArrayList;
import java.util.List;

import com.gestionesegreteria.model.Studente;

public class Database {
	private static Database instance = null;
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	private Database() {
		studenti.add(new Studente("123321", "Bianchi", "Bruno"));
		studenti.add(new Studente("123456", "Rossi", "Mario"));
		studenti.add(new Studente("132111", "Verdi", "Giulia"));
	}
	List<Studente> studenti = new ArrayList<Studente>();

	public List<Studente> dammiStudenti(){
		return studenti;
	}
	
	public boolean addStudente(Studente s) {
		if (!studenti.contains(s)) {
			studenti.add(s);
			return true;
		}
		return false;
	}
	
	

}
