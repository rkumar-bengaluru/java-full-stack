/**
 * 
 */
package org.java.full.stack.java14;

/**
 * A new class called record (aka data class), it is a final class, not
 * abstract, and all of its fields are final as well. The record will
 * automatically generate the tedious constructors, public get, equals(),
 * hashCode(), toString() during compile time.
 * 
 * @author Rupak Kumar...
 *
 */
public class J14RecordJEP359 {
	record Point(int x, int y) {
	}

	record Rectangle(Point l, Point r) {
	}

	/**
	 * Check if 2 rectangle overlaps.
	 * 
	 * @param r1
	 * @param r2
	 */
	public static boolean checkOverlap(Rectangle r1, Rectangle r2) {
		
		if (r1.l.x >= r2.r.x || r2.l.x >= r1.r.x) {
			return false;
		}

		if (r1.r.y >= r2.l.y || r2.r.y >= r1.l.y) {
			return false;
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(new Point(0, 10), new Point(10, 0));
		Rectangle r2 = new Rectangle(new Point(5, 12), new Point(15, 0));
		System.out.println(checkOverlap(r1, r2));
		Rectangle r3 = new Rectangle(new Point(-1, 0), new Point(1, 1));
		Rectangle r4 = new Rectangle(new Point(0, -1), new Point(0, 1));
		System.out.println(checkOverlap(r3, r4));

	}

}
