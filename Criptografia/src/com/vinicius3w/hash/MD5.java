package com.vinicius3w.hash;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.swing.JOptionPane;

public class MD5 {

	private static String msg = "Atacar";
	private static String hash = "1bc33ad5ec21902d36800b62872e3a35";
	
	public String encode(String message) {
		String digest = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(message.getBytes("UTF-8"));

			StringBuilder sb = new StringBuilder(2 * hash.length);
			for (byte b : hash) {
				sb.append(String.format("%02x", b & 0xff));
			}
			digest = sb.toString();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return digest;
	}

	public static void main(String args[]) throws Exception {
		
		//String salt = "ABC123";
		
		MD5 md5 = new MD5();
		String str_encoded = md5.encode(msg);
		System.out.println("Enviando Mensagem: "+msg);
		System.out.println("MD5: " + str_encoded);
				
		//Recebendo a mensagem.
		String msg="Nosso comando é: ";
		if(md5.encode("Atacar").equals(hash) ){
			msg += "Atacar";
		}else
			msg += "Esperar";
		
		JOptionPane.showMessageDialog(null, msg);
	}
}
