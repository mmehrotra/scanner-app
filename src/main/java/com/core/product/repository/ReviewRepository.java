package com.core.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.product.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	
}
