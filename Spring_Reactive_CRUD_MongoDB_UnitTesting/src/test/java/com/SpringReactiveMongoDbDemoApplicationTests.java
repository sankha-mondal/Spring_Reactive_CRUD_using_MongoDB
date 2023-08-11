package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.controller.Product_Controller;
import com.entity.Product;
import com.repository.Product_Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class SpringReactiveMongoDbDemoApplicationTests {
	
	@Autowired
	Product_Controller productController;
	
	@MockBean
	Product_Repository productRepo;  // productRepo is mocked-out guy
	
//=================================================================================================================

	@Test
	void teat_createProdut() {
		Product product = new Product(null, "IPhone", "It's cool", 1200d);
		Product savedProduct = new Product("abc123", "IPhone", "It's cool", 1200d);
		when(productRepo.save(product)).thenReturn(Mono.just(savedProduct));

		StepVerifier.create(productController.createProdut(product))
		            .assertNext(p->{
		            	assertNotNull(p);
		            	assertNotNull(p.getId());
		            	assertEquals("abc123", p.getId());
		            })
		            .expectComplete()
					.verify();
		
		// Mockito Verify | Optional
		verify(productRepo).save(product);
	}
	
//=================================================================================================================
	
	@Test
	void teat_getProduts() {
		when(productRepo.findAll()).thenReturn(Flux.just(
				new Product("abc123", "IPhone", "It's cool", 1200d),
				new Product("abc124", "MacBook", "It's awsome", 1500d),
				new Product("abc125", "Xiaomi", "It's sexy", 1800d)));
		StepVerifier.create(productController.getProducts())
					.expectNextCount(3)
					.expectComplete()
					.verify();
		
		// Mockito Verify | Optional
	    verify(productRepo).findAll();
	}
	
//=================================================================================================================
//=================================================================================================================

	
	
}
