package com.core.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.product.model.Image;
import com.core.product.model.ImageRequest;
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
		Image i = new Image();
		i.setProductImageUrl(productRequest.getProductImageUrl());
		p.setProductName(productRequest.getProductName());
		p.setProductId(productRequest.getProductId());
		if (i.getProductImageUrl() != null && i.getProductImageUrl() != "") {
			List<Image> imageList = new ArrayList<Image>();
			imageList.add(i);
			p.setImages(imageList);
		}
		Product returnProduct = productRepository.save(p);
		return populatePreSignedUrl(returnProduct);

	}

	public Product addImageToProduct(Long productId, ImageRequest imageRequest) {

		Product product = productRepository.findOne(productId);
		if (product != null) {
			List<Image> imageList = product.getImages();
			if (imageList == null) {
				imageList = new ArrayList<Image>();
			}
			Image i = new Image();
			i.setProductImageUrl(imageRequest.getProductImageUrl());
			imageList.add(i);
			product.setImages(imageList);
			Product returnProduct = productRepository.save(product);
			return populatePreSignedUrl(returnProduct);
		}

		return null;

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

		if (product.getImages() != null && product.getImages().size() > 0) {
			List<Image> images = product.getImages();
			for (Image image : images) {
				if (image.getProductImageUrl() != null && image.getProductImageUrl() != "") {
					String objectName = amazonClient.getObjectNameFromS3Url(image.getProductImageUrl());
					String presignedUrl = amazonClient.generatePreSignedUrl(objectName);
					image.setProductImagePreSignedUrl(presignedUrl);
				}
			}
			product.setImages(images);
		}

		return product;
	}

}
