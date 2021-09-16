/**
 * 
 */
package org.java.full.stack.java15;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Java 14 JEP 359 introduced the records as a preview feature. This JEP
 * enhanced the records with features like support sealed types, local records,
 * annotation on records, and Reflection APIs for records.
 * 
 * @author Rupak Kumar...
 */
public class J15RecordJEP384 {
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface Custom {public String value() default "";}

	public sealed interface CoOrdinates permits Point,Rectangle {
		boolean doOverLap(Rectangle other);
	}

	record Point(int x, int y) implements CoOrdinates {
		public boolean doOverLap(Rectangle other) {
			throw new RuntimeException();
		}
	}

	record Rectangle(@Custom Point l, @Custom Point r) implements CoOrdinates {
		public boolean doOverLap(Rectangle other) {

			if (this.l.x >= other.r.x || this.r.x <= other.l.x) {
				return false;
			}

			if (this.r.y >= other.l.y || this.l.y <= other.r.y) {
				return false;
			}

			return true;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(new Point(0, 10), new Point(10, 0));
		Rectangle r2 = new Rectangle(new Point(5, 12), new Point(15, 0));
		System.out.println(r1.doOverLap(r2));
		Rectangle r3 = new Rectangle(new Point(-1, 0), new Point(1, 1));
		Rectangle r4 = new Rectangle(new Point(0, -1), new Point(0, 1));
		System.out.println(r3.doOverLap(r4));
	}

}
