package com.tjportas.estoque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_produto;

    private String porta;
    private String batente;
    private String fechadura;
    private String guarnicao;

    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

}
