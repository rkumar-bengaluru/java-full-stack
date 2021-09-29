package org.java.full.stack.spring.io.hateoas;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
record Employee(@Id @GeneratedValue Long id, String firstName, String lastName, String role) {
	public Employee() {
		this(null, null, null, null);
	}

	public Employee(Long id) {
		this(id, null, null, null);
	}

	public Optional<Long> getId() {
		return Optional.ofNullable(this.id);
	}
}
