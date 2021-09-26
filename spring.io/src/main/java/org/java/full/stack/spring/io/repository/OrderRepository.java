package org.java.full.stack.spring.io.repository;

import java.util.List;

import org.java.full.stack.spring.io.model.LocalShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<LocalShopOrder, Long> {
	/**
	 * Custom query to find name containing the given name.
	 * 
	 * @param name
	 * @return
	 */
	//@Query("Select c from LocalShopOrder c where c.customer.name like  %:name%")
	List<LocalShopOrder> findByCustomerName(@Param("name") String name);

	/**
	 * Find product by given id.
	 * 
	 * @param id
	 * @return
	 */
	LocalShopOrder findById(long id);
}
