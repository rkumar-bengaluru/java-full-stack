package org.java.full.stack.java15;

public class J15Hidden {
	public static String lookup() {
		System.out.println("Hello from inside of Hidden class...");
		return "Hello World from Java 15 Hidden Class...my name is -->" + J15Hidden.class.getName();
	}
}