package org.java.full.stack.spring.io.repository;

import java.util.Set;

import org.java.full.stack.spring.io.model.LocalShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<LocalShopProduct, Long> {
	/**
	 * Custom query to find name containing the given name.
	 * 
	 * @param name
	 * @return
	 */
	@Query("Select c from LocalShopProduct c where c.name like  %:name%")
	Set<LocalShopProduct> findByName(@Param("name") String name);
	/**
	 * Find product by given id.
	 * 
	 * @param id
	 * @return
	 */
	LocalShopProduct findById(long id);
}
