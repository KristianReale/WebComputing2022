package com.gestionesegreteria.persistenza.dao;

import java.util.List;

import com.gestionesegreteria.model.CorsoDiLaurea;

public interface CorsoDiLaureaDao {
	public List<CorsoDiLaurea> findAll();
	public CorsoDiLaurea findByPrimaryKey(Long id);
	public boolean saveOrUpdate(CorsoDiLaurea studente);
	public boolean delete(CorsoDiLaurea studente);
	
	
}
