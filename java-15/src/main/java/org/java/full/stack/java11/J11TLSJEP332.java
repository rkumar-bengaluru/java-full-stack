package org.java.full.stack.java11;

import java.io.IOException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * Java 11 supports RFC 8446 Transport Layer Security (TLS) 1.3 protocol. 
 * However, not all TLS 1.3 feature is implemented, refer to this 
 * JEP 332 for detail.
 * 
 * @author Rupak Kumar...
 */
public class J11TLSJEP332 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SSLSocketFactory factory =
		        (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket socket;
		try {
			socket = (SSLSocket) factory.createSocket("google.com", 443);
			socket.setEnabledProtocols(new String[]{"TLSv1.3"});
			socket.setEnabledCipherSuites(new String[]{"TLS_AES_128_GCM_SHA256"});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
