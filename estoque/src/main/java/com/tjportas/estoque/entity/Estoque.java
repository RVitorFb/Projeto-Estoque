package com.tjportas.estoque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class Estoque {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
private Long id;
private String nome;
private Integer quantidade;
private Double valor;
private String fornecedor;
private Produto produto;
}
