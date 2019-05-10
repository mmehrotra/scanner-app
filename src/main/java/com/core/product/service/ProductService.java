package com.core.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.product.model.Product;
import com.core.product.model.ProductRequest;
import com.core.product.repository.ProductRepository;
import com.core.product.repository.ReviewRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	private AmazonClient amazonClient;

	public Product addProduct(ProductRequest productRequest) {

		Product p = new Product();
		p.setProductImageUrl(productRequest.getProductImageUrl());
		p.setProductName(productRequest.getProductName());
		Product returnProduct = productRepository.save(p);
		return populatePreSignedUrl(returnProduct);

	}

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(products::add);

		for (Product product : products) {
			product = populatePreSignedUrl(product);
		}

		return products;
	}

	public Product getProduct(Long productId) {
		Product product = productRepository.findOne(productId);
		return populatePreSignedUrl(product);
	}

	public Product populatePreSignedUrl(Product product) {

		if (product.getProductImageUrl() != null && product.getProductImageUrl() != "") {
			String objectName = amazonClient.getObjectNameFromS3Url(product.getProductImageUrl());
			String presignedUrl = amazonClient.generatePreSignedUrl(objectName);
			product.setProductImagePreSignedUrl(presignedUrl);
		}

		return product;
	}

}
