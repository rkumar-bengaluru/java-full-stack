package org.java.full.stack.java15;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

/**
 * Java 15 implements an additional digital signature scheme using the
 * Edwards-Curve Digital Signature Algorithm (EdDSA) as described by RFC 8032.
 * The EdDSA signature scheme is popular due to its improved security and
 * performance (faster) over other signature schemes, and it is also one of the
 * signatures schemes that are allowed in TLS 1.3
 * 
 * @author Rupak Kumar...
 */
public class J15EdDSAJEP339 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
			KeyPair kp = kpg.generateKeyPair();

			byte[] msg = "Rupak Kumar...".getBytes(StandardCharsets.UTF_8);

			Signature sig = Signature.getInstance("Ed25519");
			sig.initSign(kp.getPrivate());
			sig.update(msg);
			byte[] s = sig.sign();

			System.out.println(Base64.getEncoder().encodeToString(s));
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
		}
	}

}
