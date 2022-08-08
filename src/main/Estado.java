package main;

import java.util.ArrayList;

public class Estado {
	private ArrayList<Integer> candidatos;
	private int objetivo;
	private ArrayList<Subconjunto> subconjuntos;
	
	public Estado(ArrayList<Integer> candidatos, int objetivo) {
		this.candidatos= candidatos;
		this.objetivo= objetivo;
		this.subconjuntos = this.agregarSubconjuntos();
		
	}
	
	private ArrayList<Subconjunto> agregarSubconjuntos() {
		ArrayList<Subconjunto> inicial = new ArrayList<>();
		inicial.add(new Subconjunto());
		inicial.add(new Subconjunto());
		inicial.add(new Subconjunto());
		return inicial;
	}
	
	public ArrayList<Subconjunto> getSubconjuntos() {
		return subconjuntos;
	}
	
	public void setSubconjuntos(ArrayList<Subconjunto> subconjuntos) {
		this.subconjuntos = subconjuntos;
	}
	
	public int getObjetivo() {
		return this.objetivo;
	}
	
	public ArrayList<Integer> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Integer> candidatos) {
		this.candidatos = candidatos;
	}

	public boolean esEstadoFinal() {
		return this.getCandidatos().isEmpty();
	}

	public boolean esSolucion() {
		return this.subconjuntosLlenos() && this.cumpleConjuntosSuma();
	}
	
	private boolean cumpleConjuntosSuma() {
		for (Subconjunto s : this.getSubconjuntos()) {
			if(!this.coincideSuma(s))
				return false;
		}
		return true;	
	}
	
	private boolean coincideSuma(Subconjunto s) {
		int suma=0;
		for(int elem : s.getElementos()) {
			suma+= elem;
		}
		return suma==this.objetivo;
	}
	
	private boolean subconjuntosLlenos() {
		for (Subconjunto s : this.getSubconjuntos()) {
			if(s.getElementos().isEmpty())
				return false;
		}
		return true;
	}	
}
