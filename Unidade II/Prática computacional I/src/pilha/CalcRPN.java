package pilha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        throw new Error("a ser completado");
    }
// Adi¸c~ao de dois elementos do topo da pilha

    void mais() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        aPilha.empilha(b + a);
        hist.empilha(new Operacao(a,b,'+'));
    }
// Subtra¸c~ao de dois elementos do topo da pilha

    void menos() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        aPilha.empilha(b - a);
        hist.empilha(new Operacao(a,b,'-'));
    }
// Multiplica¸c~ao de dois elementos do topo da pilha

    void vezes() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        aPilha.empilha(b * a);
        hist.empilha(new Operacao(a,b,'*'));
    }
// Divis~ao de dois elementos no topo da pilha

    void dividido() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        aPilha.empilha(b / a);
        hist.empilha(new Operacao(a,b,'/'));
    }
// retorna o conteudo do topo da pilha

    Double resultado() {
        return aPilha.topo(); //tá certo?
    }
// interpretador de comandos

    void exec(String cmd) {
       
        
        // cmd será um string com um caracter apenas e se for um número execute 
    }
    
    // void undo() -> falta adicionar essa função.
}
