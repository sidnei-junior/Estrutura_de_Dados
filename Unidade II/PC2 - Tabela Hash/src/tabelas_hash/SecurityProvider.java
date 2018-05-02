/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas_hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sidnei
 */
public class SecurityProvider {

    public static String salt = "5a1t";

    public static String md5(String stringToConvert) {
        String hashtext = "";
        stringToConvert += salt;
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(stringToConvert.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            hashtext = bigInt.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityProvider.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return hashtext;
    }

    public static String md5ToServer(Conta conta) {
        if (!conta.getAgencia().equals("null") && !conta.getNumero().equals("null") && !conta.getNumero().equals("null")) {
            return md5(conta.getAgencia() + conta.getNumero() + conta.getSenha() + SecurityProvider.salt);
        }
        return "null";
    }

    public static String[] md5ToClient(Conta conta) {
        String toCrypt = conta.getNomeCliente() + " " + conta.getSaldo();
        String[] cripitado = new String[toCrypt.length()];
        for (int i = 0; i < toCrypt.length(); i++) {
            String aux = String.valueOf(toCrypt.charAt(i));
            cripitado[i] = md5(aux);
        }
        //for(toCrypt.)
        return cripitado;
    }

    public static void test1() {
        System.out.println(SecurityProvider.md5("teste"));
    }

    public static void main(String[] args) {
        System.out.println("====== Teste 1 ======");
        test1();
        System.out.println("====== Teste 2 ======");
        test2();
        System.out.println("====== Teste 3 ======");
        test3();
        System.out.println("====== Teste 4 ======");
        test4();
        System.out.println("====== Teste 6 ======");
        test6();
        System.out.println("====== Teste 5 ======");
        test5();
        /*System.out.println((char) 48);
        Database d = new Database();
        for(int i = 0; i < 53; i ++){
            System.out.print(d.caracteres.get(i).getCaractere());
        }*/
    }

    public static void test2() {
        Conta c = new Conta("1234", "2222", "1245");
        System.out.println(SecurityProvider.md5ToServer(c));
    }

    public static void test3() {
        Conta c = new Conta("1234", "2222", "1245");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        System.out.println(chave);
        Conta conta = ServerDatabase.getConta(chave);
        System.out.println(conta);
    }

    public static void test4() {
        Conta c = new Conta("124", "333", "1234", "10", "john doe");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        Conta conta = ServerDatabase.getConta(chave);
        String chars[];
        chars = SecurityProvider.md5ToClient(conta);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    public static void test6() {
        Letra l = new Letra("9");
        String md5 = l.getMd5Code();
        System.out.println(md5);
        Letra ll = Database.getLetra(md5);
        System.out.println(ll.getCaractere());
    }

    public static void test5() {
        Conta c = new Conta("124", "333", "1234", "10", "john doe");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        Conta conta = ServerDatabase.getConta(chave);
        String chars[];
        chars = SecurityProvider.md5ToClient(conta);
        System.out.println(Database.getConta(chars));
    }

}
