package com.brasil.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brasil.demo.exception.EstadoNotFoundException;
import com.brasil.demo.model.Estado;
import com.brasil.demo.model.Regiao;
import com.brasil.demo.service.EstadoService;

@RestController
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public Estado insertEstado(@RequestBody Estado estado){
        return estadoService.insert(estado);
    }
    @DeleteMapping
    public boolean deleteByIdEstadoHandler(@PathVariable("id") Long id){
        try{
            estadoService.deleteById(id);
            return true;
        } catch (EstadoNotFoundException e){
            return false;
        }
    }
    @GetMapping
    public boolean findByIdEstadoHandler(@PathVariable("id") Long id){
        try{
            estadoService.findById(id);
            return true;
        } catch(EstadoNotFoundException e){
            return false;
        }
    }
    @GetMapping
    public List<Estado> findAllEstadoHandler(){
        return estadoService.findAll();
    }
    @GetMapping
    public boolean findByNomeEstadoHandler(@PathVariable("nome") String nome){
        try{
            estadoService.findByNome(nome);
            return true;
        } catch(EstadoNotFoundException e){
            return false;
        }
    }
    @GetMapping
    public boolean findBySiglaEstadoHandler(@PathVariable("sigla") String sigla){
        try{
            estadoService.findBySigla(sigla);
            return true;
        } catch(EstadoNotFoundException e){
            return false;
        }
    }
    @GetMapping
    public List<Estado> findByRegiaoEstadoHandler(@PathVariable("regiao") Regiao regiao){
        return estadoService.findByRegiao(regiao);
    }
}
