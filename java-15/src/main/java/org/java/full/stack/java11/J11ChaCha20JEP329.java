/**
 * 
 */
package org.java.full.stack.java11;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.ChaCha20ParameterSpec;

/**
 * ChaCha20 is a high-speed stream cipher, an encryption and decryption 
 * algorithm. ChaCha20-Poly1305 means ChaCha20 running in AEAD mode 
 * with the Poly1305 authenticator, encryption and authentication 
 * together, both are defined in RFC 7539. This JEP update of 
 * ChaCha20 cryptographic algorithms is a replacement for the 
 * insecure RC4 stream cipher.
 * 
 * The inputs to ChaCha20 are:
 * 	- A 256-bit secret key (32 bytes)
 *  - A 96-bit nonce (12 bytes)
 *  - A 32-bit initial count (4 bytes)
 * 
 * @author Rupak Kumar...
 */
public class J11ChaCha20JEP329 {
	
	public static byte[] encrypt(byte[] nonce, 
			int counter,
			SecretKey key, 
			String textToEncrypt) 
					throws NoSuchAlgorithmException, 
					NoSuchPaddingException, 
					InvalidKeyException, 
					InvalidAlgorithmParameterException, 
					IllegalBlockSizeException, 
					BadPaddingException {
		Cipher cipher = Cipher.getInstance("ChaCha20");
	    ChaCha20ParameterSpec param = new ChaCha20ParameterSpec(nonce, counter);
	    cipher.init(Cipher.ENCRYPT_MODE, key, param);
	    byte[] encryptedText = cipher.doFinal(textToEncrypt.getBytes());
	    return encryptedText;
	}
	
	public static byte[] decrypt(byte[] nonce, 
			int counter,
			SecretKey key, 
			byte[] toDecrypt) 
					throws NoSuchAlgorithmException, 
					NoSuchPaddingException, 
					InvalidKeyException, 
					InvalidAlgorithmParameterException, 
					IllegalBlockSizeException, 
					BadPaddingException {
		Cipher cipher = Cipher.getInstance("ChaCha20");
	    ChaCha20ParameterSpec param = new ChaCha20ParameterSpec(nonce, counter);
	    cipher.init(Cipher.DECRYPT_MODE, key, param);
		byte[] decrypted = cipher.doFinal(toDecrypt); 
		return decrypted;
	}
	

}
