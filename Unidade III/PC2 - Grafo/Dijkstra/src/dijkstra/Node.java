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

@SuppressWarnings("rawtypes")
// No de um grafo
class Node implements Comparable {

  final int id; 
  final int val;

  
  Node(int i, int v){
    id = i;
    val = v;
  }


  public int compareTo(Object o1) {
    Node n = (Node) o1;
    if (this.val == n.val) return (this.id - n.id);
    return this.val - n.val;
  }
}