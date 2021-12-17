package com.gestionesegreteria.persistenza.dao;

import java.util.List;

import com.gestionesegreteria.model.Studente;

public interface StudenteDao {
	public List<Studente> findAll();
	public Studente findByPrimaryKey(String matricola);
	public boolean saveOrUpdate(Studente studente);
	public boolean delete(Studente studente);
	
	public List<Studente> cercaPerAnnoDiIscrizione(int anno);
	
}
