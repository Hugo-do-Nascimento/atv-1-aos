package com.brasil.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasil.demo.exception.EstadoNotFoundException;
import com.brasil.demo.model.Estado;
import com.brasil.demo.model.Regiao;
import com.brasil.demo.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado insert(Estado e){
        return estadoRepository.save(e);
    }
    public void deleteById(Long id) throws EstadoNotFoundException{
        Optional<Estado> opEstado = estadoRepository.findById(id);
        if(opEstado.isPresent()){
            estadoRepository.deleteById(id);
        }
        throw new EstadoNotFoundException("Estado com id " + id + " não encontrado");
    }
    public Estado findById(Long id) throws EstadoNotFoundException{
        Optional<Estado> opEstado = estadoRepository.findById(id);
        if(opEstado.isPresent()){
            return opEstado.get();
        }
        throw new EstadoNotFoundException("Estado com ID "+ id +" não encontrado");
    }
    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }
    public Estado findByNome(String nome) throws EstadoNotFoundException{
        Optional<Estado> opEstado = estadoRepository.findByNome(nome);
        if(opEstado.isPresent()){
            return opEstado.get();
        }
        throw new EstadoNotFoundException("Estado "+ nome +" não encontrado");
    }
    public Estado findBySigla(String sigla) throws EstadoNotFoundException{
        Optional<Estado> opEstado = estadoRepository.findBySigla(sigla);
        if(opEstado.isPresent()){
            return opEstado.get();
        }
        throw new EstadoNotFoundException("Estado com sigla "+ sigla +" não encontrado");
    }
    public List<Estado> findByRegiao(Regiao regiao){
        return estadoRepository.findByRegiao(regiao);
    }
}
