package org.java.full.stack.spring.io.repository;

import java.util.List;

import org.java.full.stack.spring.io.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("Select c from Product c where c.name like  %?1%")
	List<Product> findByName(String name);

	Product findById(long id);
}
