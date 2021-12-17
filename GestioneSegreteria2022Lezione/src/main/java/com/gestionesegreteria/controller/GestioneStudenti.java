package com.gestionesegreteria.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionesegreteria.Database;
import com.gestionesegreteria.model.Studente;

@Controller
@RequestMapping("/gestioneStudenti")
public class GestioneStudenti {
	
	@GetMapping("/elencoStudenti")
	public String elencoStudenti(HttpServletRequest req) {
		if (req.getSession().getAttribute("username") != null) {
			List<Studente> studenti = Database.getInstance().getStudenteDao().findAll();
			
			req.setAttribute("studenti", studenti);
			
			return "elenco_studenti";
		}else {
			return "notAuthorized";
		}
		
		
	}
}
