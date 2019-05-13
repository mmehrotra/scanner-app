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
public class Image {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("imageId")
	private Long imageId;
		
	@JsonProperty("productImageUrl")
	private String productImageUrl = null;

	@JsonProperty("productImagePreSignedUrl")
	private String productImagePreSignedUrl = null;

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
	
}
