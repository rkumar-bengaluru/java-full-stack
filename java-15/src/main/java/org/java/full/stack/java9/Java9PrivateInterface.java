
package org.java.full.stack.java9;

/**
 * In Java 9, we can create private methods inside an interface. Interface
 * allows us to declare private methods that help to share common code between
 * non-abstract methods.
 * 
 * @author Rupak Kumar...
 *
 */
interface Greeting {
	default void sayHello() {
		callPrivateHello();
	}

	private void callPrivateHello() {
		System.out.println("hello from private interface method...");
	}
}

public class Java9PrivateInterface implements Greeting {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Greeting g = new Java9PrivateInterface();
		g.sayHello();
	}

}
