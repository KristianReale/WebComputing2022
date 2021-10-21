package com.gestionesegreteria.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginActions {
	//USA LA SESSION
	@GetMapping("/user_profile")
	public String profile(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute("username") != null) {
			String sql = "select profilo_personale from users "
					+ "where username = '" + request.getSession().getAttribute("username") + "'";
			Connection con;
			try {
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
						"postgres", "postgres");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next()) {
					String contenutoProfilo = rs.getString(1);
					response.setStatus(HttpServletResponse.SC_OK);
					return contenutoProfilo;
				}else {
					String errore = "Utente non registrato";
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					return errore;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				response.sendRedirect("/login.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//USA I COOKIE
//	@GetMapping("/user_profile")
//	public String profile(HttpServletRequest request, HttpServletResponse response) {
//		boolean foundCookie = false;
//		
//		if (request.getCookies() != null) {
//			for (Cookie c : request.getCookies()) {
//				if (c.getName().equals("username")){
//					foundCookie = true;
//					String sql = "select profilo_personale from users "
//							+ "where username = '" + c.getValue() + "'";
//					Connection con;
//					try {
//						con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
//								"postgres", "postgres");
//						Statement st = con.createStatement();
//						ResultSet rs = st.executeQuery(sql);
//						if (rs.next()) {
//							String contenutoProfilo = rs.getString(1);
//							response.setStatus(HttpServletResponse.SC_OK);
//							return contenutoProfilo;
//						}else {
//							String errore = "Utente non registrato";
//							response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//							return errore;
//						}
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		if (!foundCookie) {
//			try {
//				response.sendRedirect("/login.html");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
	
	// doLogin(new HttpServletRequest(), "reale", "kristian")
	
	//USA I COOKIE
//	@PostMapping("/doLogin")
//	public String doLogin(HttpServletRequest request, HttpServletResponse response,
//						String username, String pass) {
//		String sql = "select * from users where username = '" + username + "'";
//		
//		String risposta = "Fail";
//		
//		try {
//			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
//															"postgres", "postgres");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			if (rs.next()) {
//				if (rs.getString(2).equals(pass)) {
//					response.addCookie(new Cookie("username", username));
//					response.setStatus(HttpServletResponse.SC_OK);
//					risposta = "OK";
//				}else {
//					risposta = "Attenzione, la password è errata";
//					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//				}
//			}else {
//				risposta = "Lo username indicato non appartiene a nessun utente";
//				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			}
//				
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return risposta;
//	}
	
	//USA LA SESSION
	@PostMapping("/doLogin")
	public String doLogin(HttpServletRequest request, HttpServletResponse response,
						String username, String pass) {
		String sql = "select * from users where username = '" + username + "'";
		
		String risposta = "Fail";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
															"postgres", "postgres");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				if (rs.getString(2).equals(pass)) {
					request.getSession().setAttribute("username", rs.getString(1));
					response.setStatus(HttpServletResponse.SC_OK);
					risposta = "OK";
				}else {
					risposta = "Attenzione, la password è errata";
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}else {
				risposta = "Lo username indicato non appartiene a nessun utente";
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return risposta;
	}
}
