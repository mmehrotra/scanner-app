package com.core.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.core.product.model.FileObject;
import com.core.product.model.ImageRequest;
import com.core.product.model.Product;
import com.core.product.model.ProductRequest;
import com.core.product.model.Review;
import com.core.product.model.ReviewRequest;
import com.core.product.service.AmazonClient;
import com.core.product.service.ProductService;
import com.core.product.service.ReviewService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ReviewService reviewService;

	@Autowired
	AmazonClient amazonClient;

	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping("/products/{productId}")
	public Product getProduct(@PathVariable Long productId) {
		return productService.getProduct(productId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public Product addProduct(@RequestBody ProductRequest productRequest) {
		return productService.addProduct(productRequest);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/products/{productId}/images")
	public Product addImage(@PathVariable Long productId, @RequestBody ImageRequest imageRequest) {
		return productService.addImageToProduct(productId, imageRequest);
	}

	@RequestMapping("/products/{productId}/reviews")
	public List<Review> getReviews(@PathVariable Long productId) {
		return reviewService.getReviews(productId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/products/{productId}/reviews")
	public Review addReview(@PathVariable Long productId, @RequestBody ReviewRequest reviewRequest) {
		return reviewService.addReview(productId, reviewRequest);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/products/temp/uploadFile")
	public FileObject uploadTempFile(@RequestPart(value = "file") MultipartFile file, @RequestHeader String fileType) {

		FileObject fileObject = new FileObject();
		fileObject = this.amazonClient.uploadFile(file, 0L, fileType, fileObject);
		return fileObject;
	}

}
