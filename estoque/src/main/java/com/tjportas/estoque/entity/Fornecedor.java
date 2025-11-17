package com.tjportas.estoque.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor
@ToString

public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_fornecedor;

    private String nome;
    private String localidade;
    private String telefone;
    private String email;

    @OneToMany
    private List<Modelo> modelos;

}