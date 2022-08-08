package main;

import java.util.ArrayList;

public class Backtraking {
	private Estado e;
	public Backtraking(Estado e) {
		this.e=e;
	}

	public ArrayList<Subconjunto> back() {
		//el estado es solucion?
		if(e.esEstadoFinal()) {
			if(e.esSolucion()) {
				return e.getSubconjuntos();
			}
		}
		else {
			int candidato= e.getCandidatos().remove(0);
			for (Subconjunto actual : e.getSubconjuntos()) {
				//Hacer cambios
				actual.getElementos().add(candidato);
				//Llamar backtracking
				//Deshacer
			return null;
		}
		
		return null;
	}
		return null;
	}
}
