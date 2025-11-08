package com.tjportas.estoque.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tjportas.estoque.entity.Produto;
import com.tjportas.estoque.repository.ProdutoRepository;

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
public class produtoController {

    @Autowired
    ProdutoRepository repository;

    // Create - Post
    @PostMapping("/produto")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        Produto produtoSalva = repository.save(produto);
        return new ResponseEntity<>(produtoSalva, HttpStatus.OK);
    }

    // Read - Get
    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> produto = new ArrayList<>();
        repository.findAll().forEach(produto::add);

        if (produto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    // Update - Put
    @PutMapping("/produto/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        Optional<Produto> produtoExistente = repository.findById(id);

        if (produtoExistente.isPresent()) {
            Produto produtoAtualizado = produtoExistente.get();
            produtoAtualizado.setPorta(produto.getPorta());
            produtoAtualizado.setBatente(produto.getBatente());
            produtoAtualizado.setFechadura(produto.getFechadura());
            produtoAtualizado.setGuarnicao(produto.getGuarnicao());

            repository.save(produtoAtualizado);
            return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete - Delete
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Produto> deletar(@PathVariable Long id) {

        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
