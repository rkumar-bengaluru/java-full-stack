package org.java.full.stack.java15;
/**
 * This JEP introduced few new keywords, sealed, non-seal, permits to 
 * support sealed classes and interfaces. The sealed classes and interfaces 
 * restrict who can be a subtype.
 * 
 * @author Rupak Kumar...
 */
public class J15SealedJEP360 {
	// sealed interface with allowed sub types.
	public abstract sealed interface Shape permits Circle,Square,AbstractRectangle {
		void draw();
		void rotate(double angle);
	}

	/**
	 * no more extension possible.
	 */
	public final class Circle implements Shape {
		@Override
		public void draw() {
			System.out.println("drawing circle...");
		}

		@Override
		public void rotate(double angle) {
			System.out.println("rotate circle..." + angle);
		}
	}

	// can still be subclassed with Rectangle class.
	public sealed class AbstractRectangle implements Shape permits Rectangle {
		@Override
		public void draw() {
			System.out.println("drawing abstract rectangle...");
		}

		@Override
		public void rotate(double angle) {
			System.out.println("rotate AbstractRectangle..." + angle);
		}
	}

	// final
	public final class Rectangle extends AbstractRectangle {

		@Override
		public void draw() {
			System.out.println("drawing real rectangle...");
		}

		@Override
		public void rotate(double angle) {
			System.out.println("rotate Rectangle..." + angle);
		}
	}

	// non sealed
	public non-sealed class Square implements Shape {

		@Override
		public void draw() {
			System.out.println("drawing Square...");
		}

		@Override
		public void rotate(double angle) {
			System.out.println("rotate Square..." + angle);
		}
	}

	public sealed interface Expr permits ConstantExpr,PlusExpr {
	}

	public record ConstantExpr(int i) implements Expr {
	}

	public record PlusExpr(Expr a, Expr b) implements Expr {
	}

	public void rotate1(Shape shape, double angle) {
		if (shape instanceof Circle)
			shape.rotate(angle);
		else if (shape instanceof Rectangle)
			shape.rotate(angle);
		else if (shape instanceof Square)
			shape.rotate(angle);
	}
}
