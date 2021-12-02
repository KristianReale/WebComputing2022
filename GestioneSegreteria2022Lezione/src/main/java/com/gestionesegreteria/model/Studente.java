package com.gestionesegreteria.model;

public class Studente {
	private String matricola;
	private String cognome;
	private String nome;
	
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
}
