package com.example.teste_api.controllers;
import com.example.teste_api.dtos.ProductRecordDto;
import com.example.teste_api.models.ProductModel;
import com.example.teste_api.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody ProductRecordDto productDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productDto, productModel);

       ProductModel savedProduct = productRepository.save(productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping("/products")
     public ResponseEntity<List<ProductModel>> getProducts(){

        List<ProductModel> productList = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(productList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value ="id") UUID id){
        Optional<ProductModel> product0 = productRepository.findById(id);

        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id")UUID id,@RequestBody  ProductRecordDto productRecordDto){
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuário não encontrado");
        }
        var productModel = product0.get();
        BeanUtils.copyProperties(productRecordDto,productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado na base");

        }
        var productModel = product0.get();
        productRepository.delete(productModel);
        return ResponseEntity.status(HttpStatus.OK).body("produto deletado");
    }



}
