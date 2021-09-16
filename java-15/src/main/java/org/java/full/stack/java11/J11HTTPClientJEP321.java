package org.java.full.stack.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * This HTTP Client API, in the java.net.http package was introduced in Java 9,
 * updated in Java 10, now a standard feature in Java 11
 * 
 * @author Rupak Kumar...
 */
public class J11HTTPClientJEP321 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
				.connectTimeout(Duration.ofSeconds(10)).build();
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://www.vlocalshop.in"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();
		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		HttpHeaders headers = response.headers();
		headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

		System.out.println(response.statusCode());
		System.out.println(response.body());
	}

}
