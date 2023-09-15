package com.example.SistemaDeVendas.DOMAIN.ENTITY;

import com.example.SistemaDeVendas.APPLICATION.DTO.RequestProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
@EqualsAndHashCode(of = "id")
public class Product {
    @ManyToOne
    @JoinColumn(name = "id_Costumer",referencedColumnName = "idCostumer")
    private Costumer costumer;

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @ManyToOne
    @JoinColumn(name = "id_Seller",referencedColumnName = "idSeller")
    private Seller seller;

    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private Integer amout;
    @Column(name = "price")
    private Float price;
    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    public Product(RequestProductDTO requestProductDTO){
        this.name = requestProductDTO.name();
        this.amout = requestProductDTO.amout();
        this.price = requestProductDTO.price();
        this.totalPrice = requestProductDTO.totalPrice();
    }

}
