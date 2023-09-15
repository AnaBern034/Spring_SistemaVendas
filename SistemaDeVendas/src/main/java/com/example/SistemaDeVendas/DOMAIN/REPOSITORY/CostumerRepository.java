package com.example.SistemaDeVendas.DOMAIN.REPOSITORY;

import com.example.SistemaDeVendas.DOMAIN.ENTITY.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostumerRepository extends JpaRepository<Costumer,Integer > {
    @Override
    void delete(Costumer entity);
    Costumer findByIdCostumer(int idCostumer);
}
