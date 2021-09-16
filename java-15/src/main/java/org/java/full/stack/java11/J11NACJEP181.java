package org.java.full.stack.java11;

/**
 * It supports private access within nest members directly, no more 
 * via an auto-generated bridge method access$000. Furthermore, 
 * new nested APIs for validation and allowed private reflection 
 * access within nest members.
 * 
 * @author Rupak Kumar...
 */
public class J11NACJEP181 {
	
	public class Parent {
		private String parentName;
		public Parent(String name) {this.parentName = name;}
		
		private class Child {
			private String childName;
			public Child(String name) {this.childName = name;}
			
			public void printParentName() {
				System.out.println(parentName);
			}
			
			public void printChildName() {
				System.out.println(this.childName);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		J11NACJEP181.Parent.Child p = new J11NACJEP181().new Parent("Rupak Kumar...").new Child("Raj");
		p.printChildName();
		p.printParentName();
		
	}

}
