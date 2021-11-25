package com.shop.products;

import com.shop.products.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping( path = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseMessage createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

}

