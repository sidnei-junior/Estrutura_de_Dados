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

// Test de la classe Graph
public class Test1 {
	public static void main(String[] args) throws Exception {
		System.out.println("Teste 1 : teste da classe Graph");
		
		Graph g;

		// petit graphe
		g = new Graph("mini.gr");
		System.out.println(g);

		// gros graphe
		g = new Graph("USA-road-d-NY.gr");
		g.setCoordinates("USA-road-d-NY.co");
		Fenetre f;
		f = new Fenetre("NY_Metropolitan.png", "Dijkstra", -73.9987, -73.9437, 40.7523, 40.78085);
		g.drawGraph(f);
	}
}