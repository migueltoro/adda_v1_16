package us.lsi.pli.test;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class TestPLI {

	public static void main(String[] args) {
		SolutionPLI a = AlgoritmoPLI.getSolutionFromFile("ficheros/ejemplo1.txt");
//		System.out.println(p.toStringConstraints());
		System.out.println("-------------------");	
		System.out.println("________");
		System.out.println("Goal = "+a.getGoal());
		for (int j = 0; j < 4; j++) {
			System.out.println(a.getName(j)+" = "+a.getSolution()[j]);
		}
		System.out.println("________");
//		System.out.println(s);
	}

}
