package com.example.SistemaDeVendas.CONTROLLER;

import com.example.SistemaDeVendas.APPLICATION.DTO.RequestCostumerDTO;
import com.example.SistemaDeVendas.APPLICATION.SERVICE.CostumerConsult;
import com.example.SistemaDeVendas.DOMAIN.ENTITY.Costumer;
import com.example.SistemaDeVendas.DOMAIN.REPOSITORY.CostumerRepository;
import com.example.SistemaDeVendas.APPLICATION.DTO.ResponseCostumer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumer")
public class CostumerController {
    @Autowired
    private CostumerConsult costumerConsult;
    @Autowired
    private CostumerRepository repository;
    @GetMapping
    public ResponseEntity<List<Costumer>> getAllCostumers(){
        return ResponseEntity.ok(costumerConsult.getAllCostumers());
    }
    @PostMapping
    public ResponseEntity creatDataCostumer(@RequestBody @Valid RequestCostumerDTO dataCostumers){
            Costumer costumer = new Costumer(dataCostumers);
            repository.save(costumer);
            System.out.println("Costumer added successfully ");
            return ResponseEntity.ok().build();
    }
    // search a costumer by id returning only one costumer that was sended
    @RequestMapping(value = "/code/{id}",method = RequestMethod.GET)
    public @ResponseBody Costumer filterIdCostumer(@PathVariable Integer id){
        return repository.findByIdCostumer(id);
    }
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseCostumer remove(@PathVariable Integer id){
        ResponseCostumer response = new ResponseCostumer();
    try{
        Costumer costumer = filterIdCostumer(id);
        this.repository.delete(costumer);
        response.setText("Product removed successfully");
        }catch (Exception error){
        response.setText("Faild to remove"+error.getMessage());
    }
        return response;
    }
}
