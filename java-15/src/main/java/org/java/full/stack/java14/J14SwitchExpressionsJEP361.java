package org.java.full.stack.java14;

/**
 * The switch expression was a preview feature in Java 12 and Java 13; now it is
 * officially JDK standard feature.
 * 
 * There are 2 approaches for this, yield and array function.
 * 
 * @author Rupak Kumar...
 */
public class J14SwitchExpressionsJEP361 {

	/**
	 * Switch expression with yield.
	 * 
	 * @param shape
	 * @return
	 */
	public static int calcAreaByYield(Shape shape) {
		var result = switch (shape.type()) {
		case 0, 1: {
			if (shape instanceof Square s) {
				yield s.size() * s.size();
			} else if (shape instanceof Rectangle r) {
				yield r.length * r.breadth;
			}
		}
		case 2: {
			if (shape instanceof Circle c) {
				yield (22 * c.radius * c.radius) / 7;
			}
		}
		default:
			yield -1;
		};
		return result;
	}
	/**
	 * Switch expression with arrow function
	 * 
	 * @param shape
	 * @param type
	 * @return
	 */
	public static int calAreaByArrow(Shape shape) {

		var result = switch (shape.type()) {
		case 0,1 -> {
			var area = 0;
			if (shape instanceof Square s) {
				area = s.size() * s.size();
			} else if (shape instanceof Rectangle r) {
				area = r.length * r.breadth;
			}
			yield area;
		}
		case 2 -> {
			var area = 0;
			if (shape instanceof Circle c) {
				area = (22 * c.radius * c.radius) / 7;
			}
			yield area;
		}
		default -> -1;
		};
		return result;

	}

	public sealed interface Shape permits Square,Rectangle,Circle {
		int type();
	}

	public final record Square(int size) implements Shape {

		@Override
		public int type() {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public final record Rectangle(int length, int breadth) implements Shape {

		@Override
		public int type() {
			// TODO Auto-generated method stub
			return 1;
		}
	}

	public final record Circle(int radius) implements Shape {

		@Override
		public int type() {
			// TODO Auto-generated method stub
			return 2;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape square = new Square(10);
		Rectangle rectangle = new Rectangle(10,5);
		Circle circle = new Circle(5);
		assert calcAreaByYield(square) == 100 : "failed";
		assert calcAreaByYield(rectangle) == 50 : "failed";
		assert calcAreaByYield(circle) == 78 : "failed";
		assert calAreaByArrow(square) == 100 : "failed";
		assert calAreaByArrow(rectangle) == 50 : "failed";
		assert calAreaByArrow(circle) == 78 : "failed";
		
	}

}
