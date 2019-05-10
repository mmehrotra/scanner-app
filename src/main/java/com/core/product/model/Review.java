package com.core.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Review
 */
@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("reviewId")
	private Long reviewId = null;

	@JsonProperty("reviewComment")
	private String reviewComment = null;

	@JsonProperty("rating")
	private int rating = 0;

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

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
