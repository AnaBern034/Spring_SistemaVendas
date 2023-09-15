package com.example.SistemaDeVendas.APPLICATION.SERVICE;

import com.example.SistemaDeVendas.DOMAIN.ENTITY.Costumer;
import com.example.SistemaDeVendas.DOMAIN.REPOSITORY.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CostumerConsult {
        @Autowired
       private CostumerRepository repositoryC ;
        public List<Costumer> getAllCostumers() {
            return repositoryC.findAll();
    }
}

