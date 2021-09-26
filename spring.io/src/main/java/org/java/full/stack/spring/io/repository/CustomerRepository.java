package org.java.full.stack.spring.io.repository;

import java.util.List;

import org.java.full.stack.spring.io.model.LocalShopCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<LocalShopCustomer, Long> {
	/**
	 * Custom query to find name containing the given name.
	 * 
	 * @param name
	 * @return
	 */
	//@Query("Select c from LocalShopCustomer c where c.name like  %:name%")
	List<LocalShopCustomer> findByName(@Param("name") String name);

	/**
	 * Find product by given id.
	 * 
	 * @param id
	 * @return
	 */
	LocalShopCustomer findById(long id);
}
