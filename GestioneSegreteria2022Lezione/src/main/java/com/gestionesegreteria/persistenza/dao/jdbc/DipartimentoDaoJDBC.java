package com.gestionesegreteria.persistenza.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionesegreteria.model.CorsoDiLaurea;
import com.gestionesegreteria.model.Dipartimento;
import com.gestionesegreteria.persistenza.dao.DipartimentoDao;

public class DipartimentoDaoJDBC implements DipartimentoDao{
	Connection conn;
	
	public DipartimentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Dipartimento> findAll(){
		return null;
	}

	@Override
	public Dipartimento findByPrimaryKey(Long id) {
		Dipartimento dip = null;
		String query = "select d.id as id_dip, d.nome as nome_dip, cdl.id as id_cdl"
				+ " cdl.nome as nome_cdl from "
				+ "dipartimento d inner join afferisce af on d.id = af.dipartimento"
				+ " inner join corsodilaurea cdl on cdl.id = af.corsodilaurea "
				+ " where d.id = " + id;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				if (dip == null) {
					dip = new Dipartimento();
					dip.setId(rs.getLong("id_dip"));
					dip.setNome(rs.getString("nome_dip"));
					dip.setCorsiDiLaurea(new ArrayList<CorsoDiLaurea>());
				}
				CorsoDiLaurea cdl = new CorsoDiLaurea();
				cdl.setId(rs.getLong("id_cdl"));
				cdl.setNome(rs.getString("nome_cdl"));
				dip.getCorsiDiLaurea().add(cdl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dip;
	}
	
	public Dipartimento findByPrimaryKeyLazy(Long id) {
		Dipartimento dip = null;
		String query = "select d.id as id_dip, d.nome as nome_dip "
				+ "from dipartimento d "
				+ " where d.id = " + id;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				dip = new DipartimentoProxy();
				dip.setId(rs.getLong("id_dip"));
				dip.setNome(rs.getString("nome_dip"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dip;
	}

	@Override
	public boolean saveOrUpdate(Dipartimento dipartimento) {
		return false;
	}

	@Override
	public boolean delete(Dipartimento scuola) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CorsoDiLaurea> findCorsiDiLaurea(Long idDip) {
		// TODO Auto-generated method stub
		return null;
	}


}
