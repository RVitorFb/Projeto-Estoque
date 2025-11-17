package com.tjportas.estoque.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_modelo;

    private String cor;
    private String material;
    private String largura;
    private String altura;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id_fornecedor")
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "modelo")
    @JsonIgnore
    private List<Estoque> estoque;
}
