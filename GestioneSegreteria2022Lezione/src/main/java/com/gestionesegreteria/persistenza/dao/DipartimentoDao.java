package com.gestionesegreteria.persistenza.dao;

import java.util.List;

import com.gestionesegreteria.model.CorsoDiLaurea;
import com.gestionesegreteria.model.Dipartimento;

public interface DipartimentoDao {
	public List<Dipartimento> findAll();
	public Dipartimento findByPrimaryKey(Long id);
	public List<CorsoDiLaurea> findCorsiDiLaurea(Long idDip);
	public boolean saveOrUpdate(Dipartimento dipartimento);
	public boolean delete(Dipartimento dipartimento);
	
	
}
