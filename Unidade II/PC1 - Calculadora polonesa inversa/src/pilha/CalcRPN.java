/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import static pilha.Pilha.test2;

/**
 *
 * @author C6-PROF
 */
public class CalcRPN {

    Pilha<Double> aPilha;
    Pilha<Operacao> hist;

    // vari´aveis da instancia :
// uma pilha para os c´alculos
// construtor
    CalcRPN() {
        aPilha = new Pilha<>();
        hist = new Pilha<>();
    }
// Adi¸c~ao de dois elementos do topo da pilha

    void mais() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        aPilha.empilha(b + a);
        hist.empilha(new Operacao(a, b, '+'));
    }
// Subtra¸c~ao de dois elementos do topo da pilha

    void menos() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        aPilha.empilha(b - a);
        hist.empilha(new Operacao(a, b, '-'));
    }
// Multiplica¸c~ao de dois elementos do topo da pilha

    void vezes() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        aPilha.empilha(b * a);
        hist.empilha(new Operacao(a, b, '*'));
    }
// Divis~ao de dois elementos no topo da pilha

    void dividido() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        aPilha.empilha(b / a);
        hist.empilha(new Operacao(a, b, '/'));
    }
// retorna o conteudo do topo da pilha

    Double resultado() {
        return aPilha.topo(); //tá certo?
    }
// interpretador de comandos

    void exec(String cmd) {
        switch (cmd) {
            case "+":
                mais();
                break;
            case "-":
                menos();
                break;
            case "*":
                vezes();
                break;
            case "/":
                dividido();
                break;
            case "clear":
                aPilha.reinicialize();
                hist.reinicialize();
                break;
            case "hist":
                System.out.print("Historico = ");
                System.out.println(hist.toStringInverse());
                break;
            case "undo":
                cancela();
                System.out.print("Historico = ");
                System.out.println(hist.toStringInverse());
                break;
            default:
                aPilha.empilha(Double.parseDouble(cmd));
                hist.empilha(new Operacao(Double.parseDouble(cmd)));

        }
        
        
        // cmd será um string com um caracter apenas e se for um número execute 
    }
    public void cancela(){
    
        Operacao opUndo = hist.desempilha();
        if(opUndo.getCode() == 'e'){
            aPilha.desempilha();
        }else{
            aPilha.desempilha();
            aPilha.empilha(opUndo.getB());
            aPilha.empilha(opUndo.getA());
        }
    
    }
    static void test() {
        CalcRPN calc = new CalcRPN();
        System.out.print("3 2 + = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 - = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.menos();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 * = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.vezes();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 / = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.dividido();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("1 2 + 3 4 - / 10 3 - * = ");
        calc.aPilha.empilha(1.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(4.0);
        calc.menos();
        calc.dividido();
        calc.aPilha.empilha(10.0);
        calc.aPilha.empilha(3.0);
        calc.menos();
        calc.vezes();
        System.out.println(calc.resultado());
    }

    public static void main(String[] args) throws IOException {
        //test();
        //Pilha.test2();
        interfaceUsuario();
    }

    static void interfaceUsuario() throws IOException {
        CalcRPN calc = new CalcRPN();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }
            for (String s : line.split(" ")) {
                calc.exec(s);
            }
            System.out.println("Pilha = " + calc.aPilha);
        }
        System.out.println("Até logo");
    }
/*
    public static void main(String[] args) {
        Operacao[] op = new Operacao[9];
        op[0] = new Operacao(16.0);
        op[1] = new Operacao(8.0);
        op[2] = new Operacao(4.0);
        op[3] = new Operacao(2.0);
        op[4] = new Operacao(1.0);
        op[5] = new Operacao(2.0, 1.0, '+');
        op[6] = new Operacao(4.0, 3.0,'-');
        op[7] = new Operacao(8.0, 1.0, '*');
        op[8] = new Operacao(16.0, 8.0,'/');
        for (int i = 0; i < op.length; i++) {
            System.out.print(op[i] + " ");
        }
        System.out.println();
    }
*/
    // void undo() -> falta adicionar essa função.
}
