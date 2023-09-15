package com.example.SistemaDeVendas.CONTROLLER;

import com.example.SistemaDeVendas.APPLICATION.DTO.RequestProductDTO;
import com.example.SistemaDeVendas.APPLICATION.SERVICE.ProductConsult;
import com.example.SistemaDeVendas.DOMAIN.ENTITY.Product;
import com.example.SistemaDeVendas.DOMAIN.REPOSITORY.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductConsult productConsult;
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productConsult.getAllProduct());
    }

    @PostMapping
    public ResponseEntity creatProduct(@Valid @RequestBody RequestProductDTO dataProduct){
        Product product = new Product(dataProduct);
        if (product.getTotalPrice() == null ){
            product.setTotalPrice(BigDecimal.ZERO);
            repository.save(product);
        }else {
            repository.save(product);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/above-price/{price}")
    public ResponseEntity<List<Product>> getProductAbovePrice(@PathVariable Float price){
        return ResponseEntity.ok(repository.findByPriceAbove(price));
    }



}

