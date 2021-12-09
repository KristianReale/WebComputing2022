package com.gestionesegreteria.model;

public class Studente {
	private String matricola;
	private String cognome;
	private String nome;
	//private Dipartimento dipartimentoDiAfferenza;
	
	public Studente() {
	}
	
	public Studente(String matricola, String cognome, String nome) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
	}
	
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Studente other = (Studente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
//	public Dipartimento getDipartimentoDiAfferenza() {
//		return dipartimentoDiAfferenza;
//	}
//	public void setDipartimentoDiAfferenza(Dipartimento dipartimentoDiAfferenza) {
//		this.dipartimentoDiAfferenza = dipartimentoDiAfferenza;
//	}
}
