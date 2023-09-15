package com.example.SistemaDeVendas.APPLICATION.SERVICE;

import com.example.SistemaDeVendas.DOMAIN.ENTITY.Product;
import com.example.SistemaDeVendas.DOMAIN.REPOSITORY.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductConsult {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

}
