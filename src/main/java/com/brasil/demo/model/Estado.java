package com.brasil.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Estado {
    
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String sigla;

    @ManyToOne
    @JoinColumn(name="regiao_id")
    @JsonIgnore
    private Regiao regiao;
}
