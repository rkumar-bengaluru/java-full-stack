package org.java.full.stack.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Java 9 Collection library includes static factory methods for List, 
 * Set and Map interface. These methods are useful to create small 
 * number of collection.
 * 
 * @author Rupak Kumar...
 *
 */
public class Java9Factory {
	public static void main(String[] args) {
		Consumer<Integer> c = (e)->System.out.println(e);
		List<Integer> list = List.of(5,4,3,2,1,0); 
		list.forEach(c);
		Set<Integer> set = Set.of(5,4,3,2,1,0);  
		set.forEach(c);
		Map<Integer,Integer> map = Map.of(1,"Me".hashCode(),2,"You".hashCode(),3,"Them".hashCode());  
		map.keySet().forEach(c);
		map.values().forEach(c);
	}

}
