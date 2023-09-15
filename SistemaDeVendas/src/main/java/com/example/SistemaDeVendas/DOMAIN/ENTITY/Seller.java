package com.example.SistemaDeVendas.DOMAIN.ENTITY;

import com.example.SistemaDeVendas.APPLICATION.DTO.RequestSellerDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "seller")
@Table(name = "seller")
@EqualsAndHashCode(of = "id")
public class Seller {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeller;

    @OneToMany(mappedBy = "seller")
    private List<Product> productList;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "salary")
    private Float salary;

    public Seller(RequestSellerDTO requestSellerDTO){
        this.name = requestSellerDTO.name();
        this.email = requestSellerDTO.email();
        this.cpf = requestSellerDTO.cpf();
        this.salary= requestSellerDTO.salary();
    }
}
