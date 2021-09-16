package org.java.full.stack.java8;

/**
 * An Interface that contains exactly one abstract method is known as functional
 * interface. It can have any number of default, static methods but can contain
 * only one abstract method. It can also declare methods of object class.
 * 
 * @author Rupak Kumar...
 */
public class J8Functional {

	@FunctionalInterface
	interface Greeting {
		void functional();
		
		default void sayHello() {
			System.out.println("from default say hello...");
		}
		
		static void sayStaticHello() {
			System.out.println("from static method say hello...");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Greeting g = () -> {
			System.out.println("from functional method say hello...");
		};
		Greeting.sayStaticHello();
		g.sayHello();
		g.functional();

	}

}
