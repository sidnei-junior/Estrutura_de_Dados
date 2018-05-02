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
public class Tabelas_hash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(md5("Chuck"));
        System.out.println(md5("teste"));
        System.out.println(md5("Júnior"));
    }
    
    
    public static String md5(String stringToConvert) {
        String hashtext = "";
        stringToConvert += "838ns923n";
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(stringToConvert.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            hashtext = bigInt.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            //Logger.getLogger(SecurityProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashtext;
    }

}
