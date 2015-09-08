package com.vinicius3w.cripto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
 
public class Criptografia {
  static String IV = "AAAAAAAAAAAAAAAA"; //precisa ter 16 bytes
  static String encryptionKey = "0123456789abcdef"; //precisa ter 16 bytes
 
  public byte[] encrypt(String plainText) throws Exception {
	  
	  
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    return cipher.doFinal(plainText.getBytes("UTF-8"));
  }
 
  public String decrypt(byte[] cipherText) throws Exception{
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    return new String(cipher.doFinal(cipherText),"UTF-8");
  }
}