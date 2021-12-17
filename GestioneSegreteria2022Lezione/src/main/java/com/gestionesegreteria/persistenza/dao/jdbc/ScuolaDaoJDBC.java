package com.gestionesegreteria.persistenza.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gestionesegreteria.model.Scuola;
import com.gestionesegreteria.persistenza.dao.ScuolaDao;

public class ScuolaDaoJDBC implements ScuolaDao{
	Connection conn;
	
	public ScuolaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Scuola> findAll(){
		return null;
	}

	@Override
	public Scuola findByPrimaryKey(Long id) {
		Scuola scuola = null;
		String query = "select * from scuola where id = ?";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				scuola = new Scuola();
				scuola.setId(rs.getLong("id"));
				scuola.setCodiceMeccanografico(rs.getString("codicemeccanografico"));
				scuola.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scuola;
	}

	@Override
	public boolean saveOrUpdate(Scuola studente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Scuola studente) {
		// TODO Auto-generated method stub
		return false;
	}


}
