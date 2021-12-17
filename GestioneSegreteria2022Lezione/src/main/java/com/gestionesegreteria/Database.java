package com.gestionesegreteria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.gestionesegreteria.persistenza.dao.CorsoDiLaureaDao;
import com.gestionesegreteria.persistenza.dao.DipartimentoDao;
import com.gestionesegreteria.persistenza.dao.ScuolaDao;
import com.gestionesegreteria.persistenza.dao.StudenteDao;
import com.gestionesegreteria.persistenza.dao.jdbc.CorsoDiLaureaDaoJDBC;
import com.gestionesegreteria.persistenza.dao.jdbc.DipartimentoDaoJDBC;
import com.gestionesegreteria.persistenza.dao.jdbc.ScuolaDaoJDBC;
import com.gestionesegreteria.persistenza.dao.jdbc.StudenteDaoJDBC;

public class Database {
	private static Database instance = null;
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	Connection conn;
	
	private Database() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", 
											"postgres", "postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		studenti.add(new Studente("123321", "Bianchi", "Bruno"));
//		studenti.add(new Studente("123456", "Rossi", "Mario"));
//		studenti.add(new Studente("132111", "Verdi", "Giulia"));
	}
//	List<Studente> studenti = new ArrayList<Studente>();
//
//	public List<Studente> dammiStudenti(){
//		return studenti;
//	}
//	
//	public boolean addStudente(Studente s) {
//		if (!studenti.contains(s)) {
//			studenti.add(s);
//			return true;
//		}
//		return false;
//	}
	
	public StudenteDao getStudenteDao() {
		return new StudenteDaoJDBC(conn);
	}
	
	public CorsoDiLaureaDao getCorsoDiLaureaDao() {
		return new CorsoDiLaureaDaoJDBC(conn);
	}
	
	public ScuolaDao getScuolaDao() {
		return new ScuolaDaoJDBC(conn);
	}
	
	public DipartimentoDao getDipartimentoDao() {
		return new DipartimentoDaoJDBC(conn);
	}

}
