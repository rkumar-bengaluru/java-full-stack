package org.java.full.stack.java9;

import java.util.Map;

/**
 * It is an annotation which applies on a method or constructor that takes
 * varargs parameters. It is used to ensure that the method does not perform
 * unsafe operations on its varargs parameters.
 * 
 * It was included in Java7 and can only be applied on - Final methods - Static
 * methods - Constructors
 * 
 * From Java 9, it can also be used with private instance methods.
 * 
 * @author Rupak Kumar...
 *
 */
public class Java9SafeVarargsExample {
	// on constructors
	@SafeVarargs
	public Java9SafeVarargsExample(Map<String, String>... props) {
		// TODO
	}

	// final methods
	@SafeVarargs
	public final void scanProps(Map<String, String>... props) {
		scanPrivate(props);
	}

	@SafeVarargs
	public static void scanStaticProps(Map<String, String>... props) {
		// TODO
	}

	@SafeVarargs
	private void scanPrivate(Map<String, String>... props) {
		// TODO
	}
}
