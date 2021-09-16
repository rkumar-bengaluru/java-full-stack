package org.java.full.stack.java9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * In Java 9, Stream API has improved and new methods are added to the Stream
 * interface. These methods are tabled below.
 * 
 * - takeWhile(Predicate<? super T> predicate) 
 * - dropWhile(Predicate<? super T> predicate) 
 * - ofNullable(T t) 
 * - iterate(T seed, Predicate<? super T> hasNext,UnaryOperator<T> next)
 * 
 * @author Rupak Kumar...
 *
 */
public class Java9Stream {
	public static void main(String[] args) {
		// It returns, if this stream is ordered, a stream consisting 
		// of the longest prefix of elements taken from this stream 
		// that match the given predicate. Otherwise returns, 
		// if this stream is unordered, a stream consisting of a 
		// subset of elements taken from this stream that match 
		// the given predicate.
		List<Integer> takeWhileList = Stream.of(
				2, 2, 3, 4, 5, 6, 7, 8, 9, 10).takeWhile(
						i -> (i % 2 == 0))
				.collect(Collectors.toList());
		System.out.println(takeWhileList);
		// It returns, if this stream is ordered, a stream consisting 
		// of the remaining elements of this stream after dropping 
		// the longest prefix of elements that match the given predicate. 
		// Otherwise returns, if this stream is unordered, a stream consisting 
		// of the remaining elements of this stream after dropping a subset of 
		// elements that match the given predicate.
		List<Integer> dropWhile   
        	= Stream.of(2,2,3,4,5,6,7,8,9,10)  
                .dropWhile(i -> (i % 2 == 0)).collect(Collectors.toList());     
		System.out.println(dropWhile); 
		// It returns a sequential Stream containing a single element, 
		// if non-null, otherwise returns an empty Stream.
		List<Integer> ofNullable   
        	= Stream.of(2,2,3,4,5,6,7,8,9,10)  
                .dropWhile(i -> (i % 2 == 0)).collect(Collectors.toList());     
		System.out.println(ofNullable); 
		// It returns a sequential ordered Stream produced by 
		// iterative application of the given next function to 
		// an initial element, conditioned on satisfying the given 
		// hasNext predicate. The stream terminates as soon as the 
		// hasNext predicate returns false.
		Stream.iterate(1, i -> i <= 10, i -> i*3)  
        	.forEach(System.out::println);  
	}

}
