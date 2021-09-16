package org.java.full.stack.java9;

/**
 * @author Rupak Kumar...
 *
 */
public class Java9TryResource {
	
	public class SomeResource implements AutoCloseable {
		@Override
		public void close() throws Exception {
			// close resource.
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SomeResource resource = new Java9TryResource().new SomeResource();
		try(resource) {
			System.out.println("using try with resouces as local variable...");
		}catch(Exception e) {  
            System.out.println(e);  
        }      
	}

}
