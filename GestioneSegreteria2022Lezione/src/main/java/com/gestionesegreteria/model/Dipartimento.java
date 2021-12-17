package com.gestionesegreteria.model;

import java.util.ArrayList;

public class Dipartimento {
	long id;
	String nome;
	ArrayList<CorsoDiLaurea> corsiDiLaurea;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<CorsoDiLaurea> getCorsiDiLaurea() {
		return corsiDiLaurea;
	}
	
	public void setCorsiDiLaurea(ArrayList<CorsoDiLaurea> corsiDiLaurea) {
		this.corsiDiLaurea = corsiDiLaurea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dipartimento other = (Dipartimento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
