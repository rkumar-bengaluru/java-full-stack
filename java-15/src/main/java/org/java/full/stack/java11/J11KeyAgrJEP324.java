package org.java.full.stack.java11;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.NamedParameterSpec;

/**
 * It replaced the existing elliptic curve Diffie-Hellman (ECDH) scheme with
 * Curve25519 and Curve448 algorithms, a key agreement scheme defined in RFC
 * 7748
 * 
 * @author Rupak Kumar...
 *
 */
public class J11KeyAgrJEP324 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("X25519");
			KeyPair kp = kpg.generateKeyPair();

			System.out.println("--- Public Key ---");
			PublicKey publicKey = kp.getPublic();

			System.out.println(publicKey.getAlgorithm()); // XDH
			System.out.println(publicKey.getFormat()); // X.509

			// save this public key
			byte[] pubKey = publicKey.getEncoded();

			System.out.println("---");

			System.out.println("--- Private Key ---");
			PrivateKey privateKey = kp.getPrivate();

			System.out.println(privateKey.getAlgorithm()); // XDH
			System.out.println(privateKey.getFormat()); // PKCS#8

			// save this private key
			byte[] priKey = privateKey.getEncoded();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

}
