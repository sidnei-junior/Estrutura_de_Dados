/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas_hash;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Sidnei
 */
public class ServerDatabase extends Database{

    public static final ArrayList<ArrayList<Conta>> contas;
    public static final int N = 100;

    static {
        contas = new ArrayList<ArrayList<Conta>>();
        for (int i = 0; i < N; i++) {
            contas.add(new ArrayList<Conta>());
        }
    }

    public static int hashCode(String md5) {
        BigInteger bi = new BigInteger(md5, 16);
        BigInteger m = new BigInteger(Integer.toString(N), 10);
        int pos;
        pos = bi.mod(m).intValue();
        return pos;
    }

    public static void insereConta(Conta conta) {
        //falta verificar o caso em que são iguais, pq se for igual não adiciona
        contas.get(hashCode(conta.getMd5())).add(conta);
    }

    public static Conta getConta(String md5) {
        int hCode = hashCode(md5);
        for(int i = 0; i < contas.get(hCode).size(); i++){
            if(contas.get(hCode).get(i).getMd5().equals(md5)) return contas.get(hCode).get(i);
        }
        return null;
    }
}
