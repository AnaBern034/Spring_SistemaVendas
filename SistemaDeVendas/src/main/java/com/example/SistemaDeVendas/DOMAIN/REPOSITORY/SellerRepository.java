package com.example.SistemaDeVendas.DOMAIN.REPOSITORY;

import com.example.SistemaDeVendas.DOMAIN.ENTITY.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Integer> {
    @Query("FROM seller t ORDER BY t.salary DESC")
    public List<Seller> findBySalario();

    @Query("SELECT COUNT(*) FROM seller s WHERE s.email LIKE '%zup.com.br'")
    public Long findBySellerEmail();
}
