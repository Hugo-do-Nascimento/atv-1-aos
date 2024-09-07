package com.brasil.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brasil.demo.model.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

    public Regiao findByNome(String nome);

    public List<Regiao> findBySigla(String sigla);

} 
