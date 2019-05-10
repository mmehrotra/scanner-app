package com.core.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Review
 */
public class ReviewRequest {

	@JsonProperty("reviewComment")
	private String reviewComment = null;

	@JsonProperty("rating")
	private int rating = 0;

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
