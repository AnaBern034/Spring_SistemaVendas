package com.example.SistemaDeVendas.DOMAIN.REPOSITORY;

import com.example.SistemaDeVendas.DOMAIN.ENTITY.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("from product t where t.price > :price")
    List<Product> findByPriceAbove(@Param("price") Float price);

    @Modifying
    @Query("UPDATE product p SET p.totalPrice = 0 Where p.totalPrice IS NULL")
    void updateTotalValueToZero();

}
