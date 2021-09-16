package org.java.full.stack.java15;

public class TextBlocks {

	private static final String twoDimensionalCodeBlock = """
				<html>
					<body>
						<p>Hello, world</p>
					</body>
				</html>
			""";
	private static final String jsonCodeBlock = """
			<product>
				<id>20001</id>
				<title>Apacs Ziggler Badminton Racquet</title>
				<mrp>1900</mrp>
			</product>
			""";
	private static final String sqlQueryBlock = """
			SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
			            WHERE "CITY" = 'INDIANAPOLIS'
			            ORDER BY "EMP_ID", "LAST_NAME";
			""";

	// driver code.
	public static void main(String[] args) {
		try {
			System.out.println(twoDimensionalCodeBlock);
			System.out.println(jsonCodeBlock);
			System.out.println(sqlQueryBlock);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
