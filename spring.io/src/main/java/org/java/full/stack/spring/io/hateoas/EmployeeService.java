package org.java.full.stack.spring.io.hateoas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	private List<Employee> all = new ArrayList<>();

	public EmployeeService() {
		all.add(new Employee(1L, "Rupak", "Kumar", "Admin"));
		all.add(new Employee(2L, "Raj", "Aryan", "User"));
		all.add(new Employee(3L, "Amrita", "Sinha", "User"));
		all.add(new Employee(4L, "Anurag", "Kumar", "User"));
	}

	public List<Employee> all() {
		return all;
	}

	public Stream<Employee> findById(long id) {
		return all.stream().filter(e -> {
			return e.getId().get() == id;
		});
	}
}
