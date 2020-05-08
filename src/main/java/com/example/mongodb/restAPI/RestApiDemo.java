package com.example.mongodb.restAPI;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.mongodb.config.MultipleMongoConfig;
import com.example.mongodb.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class RestApiDemo {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ProductService productService;
	
	
	static String collectionName;
	
	@Value("${collection_name}")
	private void setCollectionName(String name) {
		collectionName = name;
	}
	
	@Autowired
	public RestApiDemo() {
		System.out.println("I got called");
	}
	
	@Autowired
	private MultipleMongoConfig multipleMongoConfig;

	@GetMapping("/getProduct")
	Object[] myMethod() {
		ResponseEntity<Object[]> response = this.restTemplate.getForEntity("http://localhost:8080/getProduct",
				Object[].class);
		Object[] obj = response.getBody();
		Arrays.stream(obj).forEach(product -> {
			try {
				//multipleMongoConfig.primaryMongoTemplate().save(product, collectionName);
				System.out.println("Collection Name " + collectionName);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		return obj;
	}
		

}
