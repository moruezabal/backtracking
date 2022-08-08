package main;

import java.util.ArrayList;

public class Backtraking {
	private Estado e;
	public Backtraking(Estado e) {
		this.e=e;
	}

	public boolean back() {
		//el estado es solucion?
		if(e.esEstadoFinal()) {
			if(e.esSolucion()) {
				e.imprimirConjuntos();
				return true;
			}
		}
		else {
			int candidato= e.getCandidatos().remove(0);
			for (Subconjunto actual : e.getSubconjuntos()) {
				//Hacer cambios
				actual.getElementos().add(candidato);
				//Llamar backtracking
				if(this.back())
					return true;
				//Deshacer
				actual.getElementos().remove(actual.getElementos().size() - 1);
			}
			e.getCandidatos().add(candidato);
		}
		return false;
	}
}
