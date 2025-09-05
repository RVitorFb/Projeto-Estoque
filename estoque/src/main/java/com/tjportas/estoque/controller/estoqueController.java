package com.tjportas.estoque.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tjportas.estoque.entity.Estoque;
import com.tjportas.estoque.entity.Produto;
import com.tjportas.estoque.repository.EstoqueRepository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class estoqueController {

    @Autowired
        EstoqueRepository repository;

        //Create - Post
        @PostMapping("/estoque")
        public ResponseEntity<Estoque> salvar(@RequestBody Estoque estoque) {
                Estoque estoqueSalva = repository.save(estoque);
                return new ResponseEntity<>(estoqueSalva, HttpStatus.OK);
}

    /* 
    @RequestMapping("/estoque")
    public List<Estoque> listar() {

        Estoque e1 = new Estoque(1L, "Porta de Madeira", 50, 150.0, "Fornecedor A", Produto.PORTA);
        Estoque e2 = new Estoque(2L, "Janela de Alumínio", 30, 200.0, "Fornecedor B", Produto.JANELA);
        Estoque e3 = new Estoque(3L, "Persiana", 20, 100.0, "Fornecedor C", Produto.PERSIANA);
        Estoque e4 = new Estoque(4L, "Vidro", 15, 250.0, "Fornecedor D", Produto.VIDRO);
        Estoque e5 = new Estoque(5L, "Fechadura", 40, 75.0, "Fornecedor E", Produto.FECHADURA);

        return Arrays.asList (e1, e2, e3, e4, e5);
    }
        */
}
