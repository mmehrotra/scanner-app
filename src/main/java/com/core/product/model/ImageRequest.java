package com.core.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Review
 */
public class ImageRequest {

	@JsonProperty("productImageUrl")
	private String productImageUrl = null;

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

}
