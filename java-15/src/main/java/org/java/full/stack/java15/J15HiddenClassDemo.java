package org.java.full.stack.java15;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class HiddenClassDemo {
	/**
	 * Reads the hidden class byte codes as base64 encoded string.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String readByteCodesOfClass() throws Exception {
		byte[] array = Files.readAllBytes(Paths.get("./bin/main/org/java/full/stack/java15/Hidden.class"));
		String s = Base64.getEncoder().encodeToString(array);
		return s;
	}

	/**
	 * Making the method call in hidden class.
	 * 
	 * @param encoded
	 * @throws Throwable
	 */
	public static void callHiddenClass(String encoded) throws Throwable {
		byte[] classInBytes = Base64.getDecoder().decode(encoded);
		Class<?> proxy = MethodHandles.lookup()
				.defineHiddenClass(
						classInBytes, 
						true, 
						MethodHandles.Lookup.ClassOption.NESTMATE).lookupClass();
		MethodHandle mh = MethodHandles.lookup().findStatic(
				proxy, 
				"lookup", 
				MethodType.methodType(String.class));
		String status = (String) mh.invokeExact();
		System.out.println(status);
	}
	// driver code.
	public static void main(String[] args) {
		try {
			String encoded = readByteCodesOfClass();
			callHiddenClass(encoded);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
