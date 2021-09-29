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
		all.add(new Employee(2L, "Rupak1", "Kumar1", "Admin"));
		all.add(new Employee(3L, "Rupak2", "Kumar1", "Admin"));
		all.add(new Employee(4L, "Rupak3", "Kumar1", "Admin"));
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
