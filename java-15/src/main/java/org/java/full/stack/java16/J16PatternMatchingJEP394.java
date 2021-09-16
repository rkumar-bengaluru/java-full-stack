package org.java.full.stack.java16;

/**
 * The pattern matching for instanceof is a standard or product feature in Java
 * 16.
 * 
 * @author Rupak Kumar...
 *
 */
public class J16PatternMatchingJEP394 {

	public sealed interface Shape permits Square,Rectangle {
	}

	public final record Square(int size) implements Shape {
	}

	public final record Rectangle(int length, int breadth) implements Shape {
	}

	public static int calcArea(Shape shape) throws Exception {
		if (shape instanceof Square s) {
			return s.size() * s.size();
		} else if (shape instanceof Rectangle r) {
			return r.length() * r.breadth();
		} else {
			throw new Exception("Unexpected Shape...");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape square = new Square(10);
		Shape rectangle = new Rectangle(10,5);
		try {
			System.out.println("square area is -->" + calcArea(square));
			System.out.println("rectangle area is -->" + calcArea(rectangle));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
