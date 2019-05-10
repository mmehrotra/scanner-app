package com.core.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.product.model.Product;
import com.core.product.model.Review;
import com.core.product.model.ReviewRequest;
import com.core.product.repository.ProductRepository;
import com.core.product.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ReviewRepository reviewRepository;

	public Review addReview(Long productId, ReviewRequest reviewRequest) {

		Review review = new Review();
		review.setReviewComment(reviewRequest.getReviewComment());
		review.setRating(reviewRequest.getRating());

		Product product = productRepository.findOne(productId);
		Product returnProduct = null;

		if (product != null) {
			product.getReviews().add(review);
			returnProduct = productRepository.save(product);
			if (returnProduct != null && returnProduct.getReviews() != null && returnProduct.getReviews().size() > 0) {
				Long reviewId = returnProduct.getReviews().get(returnProduct.getReviews().size() - 1).getReviewId();
				review.setReviewId(reviewId);
			}
		} else {
			review = null;
		}

		return review;
	}

	public List<Review> getReviews(Long productId) {

		Product product = productRepository.findOne(productId);
		if (product != null && product.getReviews() != null && product.getReviews().size() > 0) {
			return product.getReviews();
		} else {
			return null;
		}
	}

}
