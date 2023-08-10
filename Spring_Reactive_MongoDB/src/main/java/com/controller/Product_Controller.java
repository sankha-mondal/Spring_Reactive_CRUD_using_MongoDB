package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.repository.Product_Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class Product_Controller {
	
	@Autowired
	private Product_Repository productRepo;
	
//================================================================================================================
	
	// Insert Operation |  Op:1
	// localhost:8585/products/store
	
	@PostMapping(("/store"))
	public Mono<Product> createProdut(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
//================================================================================================================
	
	// Read All Products |  Op:2A
	// localhost:8585/products/getAll
	
	@GetMapping("/getAll")
	public Flux<Product> getProduct() {
		return productRepo.findAll();
	}
	
	// Read Single Product |  Op:2B
	// localhost:8585/products/getById/{_id}
	
	@GetMapping("/getById/{_id}")
	public Mono<Product> getById(@PathVariable("_id") String _id) {
		return productRepo.findById(_id);
	}

//================================================================================================================

	// Update Product |  Op:3
	// localhost:8585/products/updateProduct
	
	@PutMapping("/updateProduct")
	public Mono<Product> updateProduct(@RequestBody Product product) {
		
//		Mono<Product> _product = productRepo.findById(_id);
		
//		_product.setName(product.getName());
//		_product.setDescriptio(product.getDescription());
//		_product.setPrice(product.getPrice());
//      return productRepo.save(_product);
		
		return productRepo.save(product);
	}
	
//================================================================================================================
	
	// Delete Product |  Op:4
	// localhost:8585/products/deleteProduct/{_id}
	
	@DeleteMapping("/deleteProduct/{_id}")
	public Mono<Void> deleteProduct(@PathVariable("_id") String _id) {
		return productRepo.deleteById(_id);
	}
	
	
//================================================================================================================
//================================================================================================================
	
}
