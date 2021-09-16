package org.java.full.stack.java11;

/**
 * It means more code points, more emoji icons The below example prints a Unicode code point.
 * 
 * @author Rupak Kumar...
 *
 */
public class J11UnicodeJEP327 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String codepoint = "U+1F92A";   // crazy face
		Integer i = Integer.valueOf(codepoint.substring(2), 16);
        char[] chars = Character.toChars(i);
        System.out.println(chars);
	}

}
