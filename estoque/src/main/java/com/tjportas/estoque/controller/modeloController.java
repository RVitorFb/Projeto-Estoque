package com.tjportas.estoque.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tjportas.estoque.entity.Modelo;
import com.tjportas.estoque.repository.ModeloRepository;

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
public class modeloController {

    @Autowired
    ModeloRepository repository;

    // Create - Post
    @PostMapping("/modelo")
    public ResponseEntity<Modelo> salvar(@RequestBody Modelo modelo) {
        Modelo modeloSalva = repository.save(modelo);
        return new ResponseEntity<>(modeloSalva, HttpStatus.OK);
    }

    // Read - Get
    @GetMapping("/modelo")
    public ResponseEntity<List<Modelo>> listar() {
        List<Modelo> modelo = new ArrayList<>();
        repository.findAll().forEach(modelo::add);

        if (modelo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(modelo, HttpStatus.OK);
    }

    // Update - Put
    @PutMapping("/modelo/{id}")
    public ResponseEntity<Modelo> atualizar(@PathVariable Long id, @RequestBody Modelo modelo) {
        Optional<Modelo> modeloExistente = repository.findById(id);

        if (modeloExistente.isPresent()) {
            Modelo modeloAtualizado = modeloExistente.get();
            modeloAtualizado.setCor(modelo.getCor());
            modeloAtualizado.setMaterial(modelo.getMaterial());
            modeloAtualizado.setLargura(modelo.getLargura());
            modeloAtualizado.setAltura(modelo.getAltura());

            repository.save(modeloAtualizado);
            return new ResponseEntity<>(modeloAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete - Delete
    @DeleteMapping("/modelo/{id}")
    public ResponseEntity<Modelo> deletar(@PathVariable Long id) {

        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
