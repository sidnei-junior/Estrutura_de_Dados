/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 *
 * @author Sidnei
 */

// Test de l'algorithme de Dijkstra basique 
public class Test3 {
	public static void main(String args[]) throws Exception {
		System.out.println("Teste 3 : teste do algoritmo de Dijkstra");
	    
		// petit graphe
		System.out.println("\ngrafo pequeno");
		Graph g = new Graph("mini.gr");
		Dijkstra d = new Dijkstra(g, 2, 7);
		System.out.print("caminho mais curto entre 2 e 7 = ");
                System.out.println(d.compute());
		d = new Dijkstra(g, 7, 2);
		System.out.println("caminho mais curto entre 7 e 2 = " + d.compute());

		// gros graphe
		//System.out.println("\ngrafo grande");
		//g = new Graph("USA-road-d-NY.gr");
	   // d = new Dijkstra(g, 190637, 187333);
	    //System.out.println("caminho mais curto entre 190637 e 187333 = " + d.compute());
	  }
}
