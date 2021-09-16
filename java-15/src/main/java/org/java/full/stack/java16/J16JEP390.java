package org.java.full.stack.java16;

/**
 * This JEP provides a new warning if we synchronize instances of value-based classes.
 * The annotation @jdk.internal.ValueBased tells if a class is a value-based class
 * 
 * @author Rupak Kumar...
 */
public class J16JEP390 {
	
	public static void main(String[] args) {
		Double d = 20.0;
		// A program may produce unpredictable results if it attempts to 
		// distinguish two references to equal values of a value-based class, 
		// whether directly via reference equality or indirectly via an appeal 
		// to synchronization, identity hashing, serialization, or any other 
		// identity-sensitive mechanism. Use of such identity-sensitive operations
		// on instances of value-based classes may have unpredictable effects and 
		// should be avoided.
		synchronized(d) {
			// do something with d
		}

	}

}
