package com.generation.blogpessoal.controller;


import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

// RestController - tornar essa classe uma controlodaroa de rotas
// RequestMapping - Falar qual a rota para essas contultas 

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "", allowedHeaders = "")

public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository; // Injeção de dependencia 

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        return ResponseEntity.ok(postagemRepository.findAll());
    }
        
        @GetMapping("/{id}")
    	public ResponseEntity<Postagem> getById(@PathVariable Long id){
    		return postagemRepository.findById(id)
    					.map(resp -> ResponseEntity.ok(resp))
    					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    	} 
        
        @GetMapping("/titulo/{titulo}")
    	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
    		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
    	}
}
