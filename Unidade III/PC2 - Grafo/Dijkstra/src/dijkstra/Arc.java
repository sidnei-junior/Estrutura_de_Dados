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

// arco de um grafo
public class Arc {
	int origin; 
	int destination; 
	
	// constructeur
	public Arc(int o, int d) {
		this.origin = o;
		this.destination = d;
	}

	
	public boolean equals(Object o) {
		Arc a=(Arc)o;
		return this.origin == a.origin && this.destination == a.destination;
	}
	
	
	public int hashCode() {
		return Graph.c*this.origin + this.destination;
	}
	
}

