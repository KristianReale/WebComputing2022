package com.gestionesegreteria.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestionesegreteria.Database;
import com.gestionesegreteria.model.Studente;

@RestController
public class GestioneStudentiREST {
	@PostMapping("/addStudente")
	public String aggiungiStudente(@RequestBody Studente studente) throws Exception {
		if (Database.getInstance().addStudente(studente)) {
			return "OK";
		}
		throw new Exception("Errore nell'inserimento dati");
	}
}
