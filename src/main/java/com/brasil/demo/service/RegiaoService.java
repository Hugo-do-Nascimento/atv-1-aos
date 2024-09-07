package com.brasil.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasil.demo.exception.RegiaoNotFoundException;
import com.brasil.demo.model.Regiao;
import com.brasil.demo.repository.RegiaoRepository;

@Service
public class RegiaoService {
    
    @Autowired
    private RegiaoRepository regiaoRepository;

    public List<Regiao> findAll() {
        return regiaoRepository.findAll();
    }

    public Regiao findById(Long id) throws RegiaoNotFoundException{
        Optional<Regiao> regiao = regiaoRepository.findById(id);
        if (!regiao.isPresent()) {
            throw new RegiaoNotFoundException("Região com o ID"+ id +" não econtrada."  );
        }
        return regiao.get();
    }

    public Regiao findByNome(String nome) throws RegiaoNotFoundException {
        Regiao regiao = regiaoRepository.findByNome(nome);
        if (regiao == null) {
            throw new RegiaoNotFoundException("Região com nome "+ nome +" não econtrada.");
        }
        return regiao;
    }

    public Regiao save(Regiao regiao) {
        return regiaoRepository.save(regiao);
    }

    public void deleteById(Long id) throws RegiaoNotFoundException {
        Optional<Regiao> opRegiao = regiaoRepository.findById(id);

        if (opRegiao.isPresent()) {
            regiaoRepository.deleteById(id);
        } else {
            throw new RegiaoNotFoundException("Região com o ID "+ id +" não encontrado!");
        }
    }
}
