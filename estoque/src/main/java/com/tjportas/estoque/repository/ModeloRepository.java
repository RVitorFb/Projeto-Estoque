package com.tjportas.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjportas.estoque.entity.Modelo;


@Repository

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    
}
