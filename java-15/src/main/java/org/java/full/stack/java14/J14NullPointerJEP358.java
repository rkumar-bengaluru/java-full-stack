package org.java.full.stack.java14;

/**
 * Improved the description of NullPointerExceptions by telling which variable
 * was null. Add -XX:+ShowCodeDetailsInExceptionMessages option to enable this
 * feature.
 * 
 * @author Rupak Kumar...
 *
 */
public class J14NullPointerJEP358 {
	
	public static String changeCase(String str) {
		return str.toUpperCase();
	}

	public static void main(String[] args) {
		String input = null;
		/**
		 * Before Java 14.
		 * Exception in thread "main" java.lang.NullPointerException
		 * 		at NullPointerJEP358.changeCase(Test.java:13)
		 * 		at Test.main(Test.java:17)
		 */
		String result = changeCase(input); 
		/**
		 * Now
		 *  Exception in thread "main" java.lang.NullPointerException:
		 *  	Cannot invoke "String.toUpperCase()" because "<parameter1>" is null
		 *  	at NullPointerJEP358.changeCase(Test.java:13)
		 *  	at Test.main(Test.java:17)
		 */
		System.out.println(result);
	}
}
