package org.java.full.stack.java8;

import java.util.function.BiFunction;

/**
 * Java provides a new feature called method reference in Java 8. Method 
 * reference is used to refer method of functional interface. It is 
 * compact and easy form of lambda expression. Each time when you are 
 * using lambda expression to just referring a method, you can replace 
 * your lambda expression with method reference.
 * 
 * @author Rupak Kumar...
 *
 */
public class J8MethodReference {
	// merge with passed lambda
	public static <T> T appendWithLambda(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }
	// merge static
	public static String appendWithStaticMethod(String a, String b) {
        return a + b;
    }
	// merge instance methods
	public String appendWithInstanceMethod(String a, String b) {
        return a + b;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		J8MethodReference ref = new J8MethodReference();
		// Calling the methodappendWithLambda with a lambda expression
		System.out.println(J8MethodReference.appendWithLambda(
				"Rupak ", 
				"Kumar", 
				(a,b) -> (a + b)
		));
		// Reference to a static method
		System.out.println(J8MethodReference.appendWithLambda(
				"Rupak ", 
				"Kumar", 
				J8MethodReference::appendWithStaticMethod
		));
		// Reference to an instance method of a particular object 
		System.out.println(J8MethodReference.appendWithLambda(
				"Rupak ", 
				"Kumar", 
				ref::appendWithInstanceMethod
		));
		// Reference to an instance method of an arbitrary object of a
        // particular type
		System.out.println(J8MethodReference.appendWithLambda(
				"Rupak ", 
				"Kumar", 
				String::concat
		));
	}

}
