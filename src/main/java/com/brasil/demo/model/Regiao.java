
package com.brasil.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Regiao {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String sigla;
    
    @OneToMany(mappedBy = "regiao")
    private List<Estado> estados;
}