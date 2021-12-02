package com.gestionesegreteria.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {
	@GetMapping("/")
	public String homePage(HttpServletRequest req, HttpServletResponse resp) {
		
		//SONO EQUIVALENTI
//		try {
//			RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
//			dispacher.forward(req, resp);
//		} catch (ServletException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		return "index";
	}
}
