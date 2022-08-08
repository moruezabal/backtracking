package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> conjunto = new ArrayList<Integer>(Arrays.asList(5,3,7,9,2,1));
		
		Estado e = new Estado(conjunto, 9);
		
		Backtraking b = new Backtraking(e);
		
		ArrayList<Subconjunto> solucion = b.back();
		
		
		
		System.out.println("Solucion\n" + solucion);
	}

}
