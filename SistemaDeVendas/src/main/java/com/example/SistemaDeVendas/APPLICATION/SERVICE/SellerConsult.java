package com.example.SistemaDeVendas.APPLICATION.SERVICE;

import com.example.SistemaDeVendas.APPLICATION.DTO.RequestSellerDTO;
import com.example.SistemaDeVendas.DOMAIN.ENTITY.Seller;
import com.example.SistemaDeVendas.DOMAIN.REPOSITORY.SellerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SellerConsult {
    @Autowired
    SellerRepository repository;

    public List<Seller> getAllSellers(){
        return  repository.findAll();
    }

}
