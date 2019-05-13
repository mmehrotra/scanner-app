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


	@JsonProperty("productName")
	private String productName = null;
	
	@Id
	@JsonProperty("productId")
	private Long productId = null;

	@OneToMany(cascade = { CascadeType.ALL })
	private List<Review> reviews;

	@OneToMany(cascade = { CascadeType.ALL })
	private List<Image> images;

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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	

}
