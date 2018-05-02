/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas_hash;

import java.util.ArrayList;

/**
 *
 * @author Sidnei
 */
public class Database {

    public static final ArrayList<Letra> caracteres;

    static {
        caracteres = new ArrayList<Letra>();
        for (int i = 48; i < 123; i++) {
            if (i < 58 || (i > 64 && i < 91) || i > 96) {
                caracteres.add(new Letra(String.valueOf((char) i)));
            }
        }
        caracteres.add(new Letra(" "));
    }

    public static Letra getLetra(String md5) {
        for (int i = 0; i < caracteres.size(); i++) {
            if (caracteres.get(i).getMd5Code().equals(md5)) {
                return caracteres.get(i);
            }
        }
        return null;
    }

    public static Conta getConta(String[] chars) {
        String nCliente = "";
        String saldoC = "";
        for (int i = 0; i < chars.length; i++) {
            Letra l = getLetra(chars[i]);
            Letra nextl = null;
            if (i < chars.length - 1) {
                nextl = getLetra(chars[i + 1]);
                
            }
            
            
            if (l.getCaractere().equals(" ") && (nextl.getCaractere().equals("0")
                    || nextl.getCaractere().equals("1") || nextl.getCaractere().equals("2")
                    || nextl.getCaractere().equals("3") || nextl.getCaractere().equals("4")
                    || nextl.getCaractere().equals("5") || nextl.getCaractere().equals("6")
                    || nextl.getCaractere().equals("7") || nextl.getCaractere().equals("8")
                    || nextl.getCaractere().equals("9"))) {
                    
            } else {
                if (l.getCaractere().equals("0")
                        || l.getCaractere().equals("1") || l.getCaractere().equals("2")
                        || l.getCaractere().equals("3") || l.getCaractere().equals("4")
                        || l.getCaractere().equals("5") || l.getCaractere().equals("6")
                        || l.getCaractere().equals("7") || l.getCaractere().equals("8")
                        || l.getCaractere().equals("9")) {
                    
                    saldoC += String.valueOf(l.getCaractere());
                } else {
                    
                    nCliente += String.valueOf(l.getCaractere());
                }
            }
        }

        return (new Conta(nCliente, saldoC));
    }

}
