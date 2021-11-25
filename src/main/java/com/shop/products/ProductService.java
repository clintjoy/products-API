package com.shop.products;

import com.shop.products.exception.ProductNotFoundException;
import com.shop.products.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseMessage createProduct(Product product){
        ResponseMessage responseMessage = new ResponseMessage(product.toString());
        if(!productRepository.findByName(product.getName()).isEmpty()) {
            responseMessage.setMessage("Product "+ product.getName() +" already exist!");
        }
        else {
            responseMessage.setMessage(productRepository.save(product).toString());
        }
        return responseMessage;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
