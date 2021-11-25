package com.gestionesegreteria.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//MVC
public class LoginSpringBoot {
	
	@GetMapping("/paginaLogin")
	public String paginaLogin() {
		return "login";
	}
	
	@PostMapping("/loginServices")
	public String faiLogin(HttpServletRequest req, HttpServletResponse resp, String username, String pass) throws IOException {
		String sql = "select * from users where username = '" + username + "'";
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "postgres");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				resp.sendRedirect("/");
//				RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/jsp/index.jsp");
//				dispacher.forward(req, resp);
				
//				return "redirect:/";
			}else {
				return "login";
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
