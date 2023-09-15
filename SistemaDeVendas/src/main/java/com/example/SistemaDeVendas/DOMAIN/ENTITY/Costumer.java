package com.example.SistemaDeVendas.DOMAIN.ENTITY;

import com.example.SistemaDeVendas.APPLICATION.DTO.RequestCostumerDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COSTUMER")
@Table(name = "COSTUMER")
@EqualsAndHashCode(of = "id")
public class Costumer {

    @OneToMany(mappedBy = "costumer")
    private List<Product> productList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCostumer;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "address")
    private String address;
    public Costumer (RequestCostumerDTO requestCostumerDTO){
        this.name = requestCostumerDTO.name();
        this.email = requestCostumerDTO.email();
        this.address = requestCostumerDTO.address();
        this.cpf = requestCostumerDTO.cpf();
    }

}
