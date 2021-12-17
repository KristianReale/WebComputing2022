package com.gestionesegreteria.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestionesegreteria.Database;
import com.gestionesegreteria.messaggi.AggiuntaStudenteStatus;
import com.gestionesegreteria.model.Studente;

@RestController
public class GestioneStudentiREST {
	@PostMapping("/addStudente")
	public AggiuntaStudenteStatus aggiungiStudente(@RequestBody Studente studente,
								HttpServletResponse resp) {
		AggiuntaStudenteStatus status = new AggiuntaStudenteStatus();
		if (Database.getInstance().getStudenteDao().saveOrUpdate(studente)) {
			status.setStatus("OK");
			status.setMessaggio("Studente aggiunto con successo");
		}else {
			resp.setStatus(500);
			status.setStatus("Fail");
			status.setMessaggio("Studente duplicato");
		}
		return status;
	}
}
