package com.example.SistemaDeVendas.DOMAIN.ENTITY;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "sale")
@Table(name = "sale")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSale;

    @ManyToOne
    @JoinColumn(name = "costumer_id", referencedColumnName = "idCostumer")
    private Costumer costumer;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "idProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "seller_id",referencedColumnName = "idSeller")
    private Seller seller;

    @Column(name = "total")
    private BigDecimal totalValue;

    @Column(name = "quantity")
    private Integer quantity;


}