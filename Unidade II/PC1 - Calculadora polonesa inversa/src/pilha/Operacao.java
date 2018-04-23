/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

/**
 *
 * @author C6-PROF
 */
public class Operacao {

    private double a, b;
    private char code;

    public Operacao(double a, double b, char code) {
        this.a = a;
        this.b = b;
        this.code = code;
    }

    public Operacao(double a) {
        this.a = a;
        this.code = 'e';
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public char getCode() {
        return code;
    }

    @Override
    public String toString() {
        if (code == 'e') {
            return Double.toString(a);
        } else {
            return String.valueOf(code);
        }
    }
    
    /*
    public String toString(int i) {
        System.out.println("entrou no toString de operacao int i");
            return a + b + String.valueOf(code);
        
    }
    */

    

}
