package com.tjportas.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjportas.estoque.entity.Fornecedor;

@Repository

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
