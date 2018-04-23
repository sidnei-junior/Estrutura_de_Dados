/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

import java.util.LinkedList;

/**
 *
 * @author C6-PROF
 */
public class Pilha<T> {

    private LinkedList<T> conteudo;
   
    
    public Pilha() {
        conteudo = new LinkedList<>();
    }

    public void empilha(T novoDado) {
        conteudo.addFirst(novoDado);
    }

    public T desempilha() {
        return conteudo.removeFirst();
    }

    public T topo() {
        return conteudo.getFirst();
    }

    public void reinicialize() {
        conteudo.clear();
    }

    public String toString() {
        return conteudo.toString();
    }

   public String toStringInverse(){
       String temp = "[";
       Pilha<T> tempS = new Pilha<>();
       for(int i = 0 ; i < conteudo.size(); i++){
           tempS.empilha(conteudo.get(i));
       }
       int N = conteudo.size();
       for(int i = 0; i < N; i++){
           temp += tempS.desempilha().toString();
           if (i < N-1) temp += ", ";
       }
       temp += "]";
       return temp;
   }
    
    static void test2() {
        Pilha<Double> aPilha = new Pilha<Double>();
        System.out.println(aPilha);
        aPilha.empilha(1.1);
        System.out.println(aPilha);
        aPilha.empilha(2.1);
        System.out.println(aPilha);
        aPilha.empilha(3.1);
        System.out.println(aPilha);
        double valor = 0.0;
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        System.out.println(aPilha);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        System.out.println(aPilha);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        System.out.println(aPilha);
    }

}
