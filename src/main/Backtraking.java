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
				e.imprimirConjuntos();
				return e.getSubconjuntos();
			}
		}
		else {
			int candidato= e.getCandidatos().remove(0);
			for (Subconjunto actual : e.getSubconjuntos()) {
				//Hacer cambios
				actual.getElementos().add(candidato);
				//Llamar backtracking
				this.back();
				//Deshacer
				actual.getElementos().remove(actual.getElementos().size() - 1);
			}
			e.getCandidatos().add(candidato);
		}
		return e.getSubconjuntos();
	}
}
