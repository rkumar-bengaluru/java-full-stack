package org.java.full.stack.java9;

/**
 * Java 9 introduced a new feature that allows us to use diamond operator with
 * anonymous classes
 * 
 * @author Rupak Kumar...
 */
interface Circle<T> {
	T area(T a);
}

public class Java9Anonymous {
	
	interface Square<T> {
		T area(T a);
	}

	public static void main(String[] args) {
		Circle<Integer> circleAnonymous = new Circle<>() {
			@Override
			public Integer area(Integer radius) {
				return (22 * radius * radius)/7;
			}
		};
		
		Square<Integer> squareAnonymous = new Square<>() {
			@Override
			public Integer area(Integer edge) {
				return edge * edge;
			}
		};
		System.out.println(circleAnonymous.area(2));
		System.out.println(squareAnonymous.area(2));
	}

}
