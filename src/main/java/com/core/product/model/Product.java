package com.core.product.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Product
 */
@Entity
public class Product {

	@JsonProperty("prductImageUrl")
	private String productImageUrl = null;

	@JsonProperty("productImagePreSignedUrl")
	private String productImagePreSignedUrl = null;

	@JsonProperty("productName")
	private String productName = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("productId")
	private Long productId = null;

	@OneToMany(cascade = { CascadeType.ALL })
	private List<Review> reviews;

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public String getProductImagePreSignedUrl() {
		return productImagePreSignedUrl;
	}

	public void setProductImagePreSignedUrl(String productImagePreSignedUrl) {
		this.productImagePreSignedUrl = productImagePreSignedUrl;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}
