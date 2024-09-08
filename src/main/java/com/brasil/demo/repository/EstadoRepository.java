package com.brasil.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brasil.demo.model.Estado;
import com.brasil.demo.model.Regiao;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
    public Optional<Estado> findByNome(String nome);

    public Optional<Estado> findBySigla(String sigla);

    public List<Estado> findByRegiao(Regiao regiao);
}
