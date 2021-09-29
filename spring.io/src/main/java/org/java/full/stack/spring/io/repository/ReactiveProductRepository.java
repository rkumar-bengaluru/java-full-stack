package org.java.full.stack.spring.io.repository;

import org.java.full.stack.spring.io.model.LocalShopProduct2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveProductRepository extends ReactiveCrudRepository<LocalShopProduct2, Long> {
	/**
	 * Custom query to find name containing the given name.
	 * 
	 * @param name
	 * @return
	 */
	@Query("Select c from LocalShopProduct c where c.name like  %:name%")
	Flux<LocalShopProduct2> findByName(@Param("name") String name);
	/**
	 * Find product by given id.
	 * 
	 * @param id
	 * @return
	 */
	Mono<LocalShopProduct2> findById(long id);
}
