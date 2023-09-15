package com.example.SistemaDeVendas.CONTROLLER;

import com.example.SistemaDeVendas.APPLICATION.DTO.RequestSellerDTO;
import com.example.SistemaDeVendas.APPLICATION.SERVICE.SellerConsult;
import com.example.SistemaDeVendas.DOMAIN.ENTITY.Seller;
import com.example.SistemaDeVendas.DOMAIN.REPOSITORY.SellerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerConsult sellerConsult;
    @Autowired
    private SellerRepository repository;
    @GetMapping
    public ResponseEntity<List<Seller>> getAllSellers(){
        return ResponseEntity.ok(sellerConsult.getAllSellers());
    }
    @PostMapping
    public ResponseEntity creatSeller(@Valid @RequestBody RequestSellerDTO dataSeller){
        Seller seller = new Seller(dataSeller);
        repository.save(seller);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/salary")
    public ResponseEntity<List<Seller>> getAllSalayOrdenByDesc(){
        return ResponseEntity.ok(repository.findBySalario());
    }
    // retornar a quantidade e mostrar quem são
    @GetMapping("/email")
    public ResponseEntity<Long> getAmountSellersWithEmail() {
        Long count = repository.findBySellerEmail();
        return ResponseEntity.ok(count);
    }
}



