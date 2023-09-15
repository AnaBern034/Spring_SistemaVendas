package com.example.SistemaDeVendas.DOMAIN.REPOSITORY;

import com.example.SistemaDeVendas.DOMAIN.ENTITY.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
