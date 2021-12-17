package com.gestionesegreteria.persistenza.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionesegreteria.model.CorsoDiLaurea;
import com.gestionesegreteria.model.Studente;
import com.gestionesegreteria.persistenza.dao.CorsoDiLaureaDao;

public class CorsoDiLaureaDaoJDBC implements CorsoDiLaureaDao{
	Connection conn;
	
	public CorsoDiLaureaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<CorsoDiLaurea> findAll(){
		return null;
	}

	@Override
	public CorsoDiLaurea findByPrimaryKey(Long id) {
		CorsoDiLaurea cdl = null;
		String query = "select * from corsodilaurea where id = ?";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				cdl = new CorsoDiLaurea();
				cdl.setId(rs.getLong("id"));
				cdl.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cdl;
	}

	@Override
	public boolean saveOrUpdate(CorsoDiLaurea studente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CorsoDiLaurea studente) {
		// TODO Auto-generated method stub
		return false;
	}


}
