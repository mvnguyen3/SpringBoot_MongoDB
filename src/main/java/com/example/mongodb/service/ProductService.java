package com.example.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mongodb.domain.Product;
import com.example.mongodb.repository.ProductRepository;

@Component
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public Product saveProduct(Product product) {
//		Product p = new Product();
//		p.setProductCategory(product.getProductCategory());
//		p.setProductId(product.getProductId());
//		p.setProductName(product.getProductName());					
		return repository.save(product);
	}
}
