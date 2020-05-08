package com.example.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.domain.Product;
import com.example.mongodb.repository.ProductRepository;
import com.example.mongodb.service.ProductService;

@RestController
public class MainController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/getProduct")
	public List<Product> getProduct(){		
		return productRepository.findAll();
	}
	
	@PostMapping("/generateDummy")
	public Product generateDummyPojo(@RequestBody Product product) {
		
		return productService.saveProduct(product);
	}
		
	
}








