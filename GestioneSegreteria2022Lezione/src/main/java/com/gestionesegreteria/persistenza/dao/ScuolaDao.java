package com.gestionesegreteria.persistenza.dao;

import java.util.List;

import com.gestionesegreteria.model.Scuola;
import com.gestionesegreteria.model.Studente;

public interface ScuolaDao {
	public List<Scuola> findAll();
	public Scuola findByPrimaryKey(Long id);
	public boolean saveOrUpdate(Scuola studente);
	public boolean delete(Scuola studente);
	
	
}
