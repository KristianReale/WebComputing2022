package com.gestionesegreteria.persistenza.dao.jdbc;

import java.util.ArrayList;

import com.gestionesegreteria.Database;
import com.gestionesegreteria.model.CorsoDiLaurea;
import com.gestionesegreteria.model.Dipartimento;


public class DipartimentoProxy extends Dipartimento{
	@Override
	public ArrayList<CorsoDiLaurea> getCorsiDiLaurea() {
		if (super.getCorsiDiLaurea() == null) {
			ArrayList<CorsoDiLaurea> corsi = (ArrayList<CorsoDiLaurea>) Database.getInstance().getDipartimentoDao().findCorsiDiLaurea(getId());
			setCorsiDiLaurea(corsi);
		}
		return super.getCorsiDiLaurea();
	}
}
