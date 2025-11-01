package com.tjportas.estoque.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tjportas.estoque.entity.Estoque;
import com.tjportas.estoque.repository.EstoqueRepository;

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
public class estoqueController {

    @Autowired
    EstoqueRepository repository;

    // Create - Post
    @PostMapping("/estoque")
    public ResponseEntity<Estoque> salvar(@RequestBody Estoque estoque) {
        Estoque estoqueSalva = repository.save(estoque);
        return new ResponseEntity<>(estoqueSalva, HttpStatus.OK);
    }

    // Read - Get
    @GetMapping("/estoque")
    public ResponseEntity<List<Estoque>> listar() {
        List<Estoque> estoque = new ArrayList<>();
        repository.findAll().forEach(estoque::add);

        if (estoque.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estoque, HttpStatus.OK);
    }

    // Update - Put
    @PutMapping("/estoque/{id}")
    public ResponseEntity<Estoque> atualizar(@PathVariable Long id, @RequestBody Estoque estoque) {
        Optional<Estoque> estoqueExistente = repository.findById(id);

        if (estoqueExistente.isPresent()) {
            Estoque estoqueAtualizado = estoqueExistente.get();
            estoqueAtualizado.setCodigo(estoque.getCodigo());
            estoqueAtualizado.setProduto(estoque.getProduto());
            estoqueAtualizado.setModelo(estoque.getModelo());
            estoqueAtualizado.setFornecedor(estoque.getFornecedor());
            estoqueAtualizado.setQuantidade(estoque.getQuantidade());
            estoqueAtualizado.setValor(estoque.getValor());

            repository.save(estoqueAtualizado);
            return new ResponseEntity<>(estoqueAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete - Delete
    @DeleteMapping("/estoque/{id}")
    public ResponseEntity<Estoque> deletar(@PathVariable Long id) {

        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
     * @RequestMapping("/estoque")
     * public List<Estoque> listar() {
     * 
     * Estoque e1 = new Estoque(1L, "Porta de Madeira", 50, 150.0, "Fornecedor A",
     * Produto.PORTA);
     * Estoque e2 = new Estoque(2L, "Janela de Alumínio", 30, 200.0, "Fornecedor B",
     * Produto.JANELA);
     * Estoque e3 = new Estoque(3L, "Persiana", 20, 100.0, "Fornecedor C",
     * Produto.PERSIANA);
     * Estoque e4 = new Estoque(4L, "Vidro", 15, 250.0, "Fornecedor D",
     * Produto.VIDRO);
     * Estoque e5 = new Estoque(5L, "Fechadura", 40, 75.0, "Fornecedor E",
     * Produto.FECHADURA);
     * 
     * return Arrays.asList (e1, e2, e3, e4, e5);
     * }
     */
}
