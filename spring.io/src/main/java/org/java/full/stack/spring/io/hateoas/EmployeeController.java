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


	@GetMapping("")
	public ResponseEntity<CollectionModel<EntityModel<Employee>>> all() {
		Stream<Employee> all = service.all().stream();
		List<EntityModel<Employee>> a = all.map(e -> {
			return EntityModel.of(e, linkTo(methodOn(EmployeeController.class).findOne(e.id())).withSelfRel());
		}).collect(Collectors.toList());
		return ResponseEntity.ok(CollectionModel.of(a));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Employee>> findOne(@PathVariable Long id) {

		return service.findById(id).map(e -> {
			return EntityModel.of(e, linkTo(methodOn(EmployeeController.class).findOne(e.getId().get())).withSelfRel(),
					linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
		}).map(ResponseEntity::ok).findFirst().get();
	}
}
