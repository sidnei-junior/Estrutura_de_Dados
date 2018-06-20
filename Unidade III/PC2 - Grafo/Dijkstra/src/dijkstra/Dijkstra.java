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
import java.util.PriorityQueue;

// Algoritmo de Dijkstra
public class Dijkstra {
	final Graph g; 
	final int n; 
	final int source; 
	final int dest; 
	Fenetre f; 
        
        int[] dist;
        int[] pred;
        boolean[] settled;
        PriorityQueue<Node> naoacomodados;

	// construtor
	Dijkstra(Graph g, int source, int   dest) {
		this.g = g;
		n = g.n;
		this.source = source;
		this.dest = dest;
                this.dist = new int[n];
                this.pred = new int[n];
                this.settled = new boolean[n];
                naoacomodados = new PriorityQueue<Node>();
                for(int i = 0; i < n; i++){
                    if (i != source){
                        this.dist[i] = Integer.MAX_VALUE;
                        this.pred[i] = -1;
                        
                    }else{
                        this.dist[i] = 0;
                        this.pred[i] = source;
                    }
                    this.settled[i] = false;
                    naoacomodados.add(new Node(i,dist[i]));
                    
                }
                
	}
	
	// atualizacao da distancia, da prioridade, e do predecessor de um no
	void update(int y, int x) {
            System.out.println("");
            System.out.println("y = " + y + ", x = " + x);
            System.out.println("dist[y] = " + dist[y] + " ----Novo");
            //System.out.println("dist["+y+"] = " + dist[y]);
            //System.out.println("dist["+x+"] + g.value("+x+","+y+")= " + (dist[x] + g.value(x,y)));
            System.out.println("dist[y] ?> dist[x] + g.value(x,y)");
            System.out.println(dist[y] + " ?> " + dist[x] + " + " + g.value(x,y));
            if(dist[y] > dist[x] + g.value(x,y)){
                dist[y] = dist[x] + g.value(x,y);
                pred[y] = x;
                naoacomodados.add(new Node(y, dist[y]));
            }
            System.out.println("dist[y] = " + dist[y] + " ----atualizado");
	}
	
	// retorna o próximo nó a ser acomodado
	int nextNode() {
            Node nxt;
            do{
                if(naoacomodados.isEmpty()){
                    return -1;
                }
                nxt = naoacomodados.poll();
                
            }while(settled[nxt.id]);
                
            return nxt.id;
	}
	
	// uma etapa do algoritmo de Dijkstra
	int oneStep() {
            
            int next = nextNode();
            //System.out.println("Entrou no OneStep!!!!");
            if(next != -1){
                settled[next] = true;
                for(int i = 0; i < n; i++){
                    if(!settled[i]){
                        update(i, next);
                    }
                }
            }
            return next;
            
	}
	
	// algoritmo de Dijsktra completo
	int compute() {
            int testParada = -1;
            do{
                //System.out.println("step 03 - variavel testeParada = " + testParada);
                testParada = oneStep();
            }while(testParada != -1 && !settled[dest]);
            //System.out.println("Saiu do while!!!");
            if(dist[dest] == Integer.MAX_VALUE){
                return -1;
            }
            return dist[dest];
	}
	
	// desacelera o visualizador
	void slow(){
	    if(f == null) return;
	    try {
	        Thread.sleep(5);
	    } catch (InterruptedException e) {}
	}
}

