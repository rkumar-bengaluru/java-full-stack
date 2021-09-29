package org.java.full.stack.spring.io.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("") // CollectionModel
	public ResponseEntity<CollectionModel<EntityModel<Employee>>> all() {
		// get stream of employees
		Stream<Employee> all = service.all().stream();
		// map each employee to EntityModel with links.
		List<EntityModel<Employee>> a = all.map(e -> {
			return EntityModel.of(e, linkTo(methodOn(EmployeeController.class).findOne(e.id())).withSelfRel());
		}).collect(Collectors.toList());
		// convert list to CollectionModel with links.
		return ResponseEntity
				.ok(CollectionModel.of(a, linkTo(methodOn(EmployeeController.class).all()).withRel("employees")));
	}

	@GetMapping("/{id}") // EntityModel
	public ResponseEntity<EntityModel<Employee>> findOne(@PathVariable Long id) {
		// get stream of employees
		Stream<Employee> all = service.findById(id);
		// map each employee to EntityModel with self link
		Stream<EntityModel<Employee>> allEntityModel = all.map(e -> {
			return EntityModel.of(e, linkTo(methodOn(EmployeeController.class).findOne(e.getId().get())).withSelfRel(),
					linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
		});
		// convert from EntityModel to ResponseEntity
		return allEntityModel.map(ResponseEntity::ok).findFirst().get();
	}
}
