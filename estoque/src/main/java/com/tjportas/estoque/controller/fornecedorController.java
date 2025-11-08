package com.tjportas.estoque.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tjportas.estoque.entity.Fornecedor;
import com.tjportas.estoque.repository.FornecedorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class fornecedorController {

    @Autowired
    FornecedorRepository repository;

    // Create - Post
    @PostMapping("/fornecedor")
    public ResponseEntity<Fornecedor> salvar(@RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorSalva = repository.save(fornecedor);
        return new ResponseEntity<>(fornecedorSalva, HttpStatus.OK);
    }

    // Read - Get
    @GetMapping("/fornecedor")
    public ResponseEntity<List<Fornecedor>> listar() {
        List<Fornecedor> fornecedor = new ArrayList<>();
        repository.findAll().forEach(fornecedor::add);

        if (fornecedor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fornecedor, HttpStatus.OK);
    }

    // Update - Put
    @PutMapping("/fornecedor/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        Optional<Fornecedor> fornecedorExistente = repository.findById(id);

        if (fornecedorExistente.isPresent()) {
            Fornecedor fornecedorAtualizado = fornecedorExistente.get();
            fornecedorAtualizado.setNome(fornecedor.getNome());
            fornecedorAtualizado.setLocalidade(fornecedor.getLocalidade());
            fornecedorAtualizado.setTelefone(fornecedor.getTelefone());
            fornecedorAtualizado.setEmail(fornecedor.getEmail());

            repository.save(fornecedorAtualizado);
            return new ResponseEntity<>(fornecedorAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete - Delete
    @DeleteMapping("/fornecedor/{id}")
    public ResponseEntity<Fornecedor> deletar(@PathVariable Long id) {

        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
