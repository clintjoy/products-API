package com.shop.products;

import com.shop.products.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import org.springframework.util.Assert;

@SpringBootTest
class ProductCatalogueApplicationTests {

	@Autowired
	ProductService service;
	@MockBean
	ProductRepository repository;

	@Test
	public void getAllProductsTest(){
		List<Product> productList1 = new ArrayList<Product>();
		productList1.add(new Product(1l,"Mobile",1, BigDecimal.valueOf(20000)));
		productList1.add(new Product(2l,"HeadPhone",5, BigDecimal.valueOf(999)));
		productList1.add(new Product(3l,"DataCable",2, BigDecimal.valueOf(499)));

		when(repository.findAll()).thenReturn(productList1);
		Assertions.assertEquals(3, service.getAllProducts().size());
	}

	@Test
	public void createProductTest(){
		Product p = new Product(1l,"Mobile",1, BigDecimal.valueOf(20000));
		when(repository.save(p)).thenReturn(p);
		Assertions.assertEquals(p, repository.save(p));
	}

	@Test
	public void getProductByIdTest(){
		long id = 1;
		Product p = new Product(1l,"Mobile",1, BigDecimal.valueOf(20000));
		when(repository.findById(id)).thenReturn(Optional.of(p));
		Assertions.assertEquals(p, service.getProductById(id));
	}

}
