package com.gestionesegreteria.persistenza.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionesegreteria.Database;
import com.gestionesegreteria.model.CorsoDiLaurea;
import com.gestionesegreteria.model.Scuola;
import com.gestionesegreteria.model.Studente;
import com.gestionesegreteria.persistenza.dao.StudenteDao;

public class StudenteDaoJDBC implements StudenteDao{
	Connection conn;
	
	public StudenteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Studente> findAll() {
		List<Studente> studenti = new ArrayList<Studente>();
		String query = "select * from studenti";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Studente stud = new Studente();
				stud.setMatricola(rs.getString("matricola"));
				stud.setNome(rs.getString("nome"));
				stud.setCognome(rs.getString("cognome"));
				
				Scuola scuola = Database.getInstance().getScuolaDao()
								.findByPrimaryKey(rs.getLong("scuola"));
				stud.setScuola(scuola);
				
				CorsoDiLaurea cdl = Database.getInstance().getCorsoDiLaureaDao()
						.findByPrimaryKey(rs.getLong("corso_di_laurea"));
				stud.setCorsoDiLaurea(cdl);
				
				studenti.add(stud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studenti;
	}

	@Override
	public Studente findByPrimaryKey(String matricola) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveOrUpdate(Studente studente) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Studente studente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Studente> cercaPerAnnoDiIscrizione(int anno) {
		// TODO Auto-generated method stub
		return null;
	}

}
