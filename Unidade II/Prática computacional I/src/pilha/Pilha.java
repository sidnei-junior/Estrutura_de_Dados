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
    
    public void clear(){
        conteudo.clear();
    }

}


