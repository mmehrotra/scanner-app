package com.core.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Product
 */

public class ProductRequest {

	@JsonProperty("productImageUrl")
	private String productImageUrl = null;

	@JsonProperty("productName")
	private String productName = null;
	
	@JsonProperty("productId")
	private Long productId = null;

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
