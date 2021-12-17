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
	public boolean saveOrUpdate(Scuola scuola) {
		if (scuola.getId() == 0) {
			//INSERT
			try {
				scuola.setId(IdBrokerScuola.getId(conn));
				String query = "insert into scuola "
						+ "values (?, ?, ?)";
				PreparedStatement st = conn.prepareStatement(query);
				st.setLong(1, scuola.getId());
				st.setString(2, scuola.getCodiceMeccanografico());
				st.setString(3, scuola.getNome());
				st.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			//UPDATE
			try {
				String query = "update scuola "
						+ "set codicemeccanografico = ?, nome = ? "
						+ "where id = ?";
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, scuola.getCodiceMeccanografico());
				st.setString(2, scuola.getNome());
				st.setLong(3, scuola.getId());
				
				st.executeUpdate();
				
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(Scuola scuola) {
		// TODO Auto-generated method stub
		return false;
	}


}
