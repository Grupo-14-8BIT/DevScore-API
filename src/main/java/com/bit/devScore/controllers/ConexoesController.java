package com.bit.devScore.controllers;

import com.bit.devScore.entity.Conexoes;
import com.bit.devScore.services.ConexoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/Conexoes")
public class ConexoesController {
    @Autowired
    private ConexoesService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")final long id){
     return service.findById(id);
    }


    @GetMapping("/lista")
    public ResponseEntity<?> listAll(){
        return ResponseEntity.ok(this.service.findAll());
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody final Conexoes conexoes) {
       return service.create(conexoes);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> uodate(@PathVariable final Long id, @RequestBody final Conexoes conexoes) {
        return this.service.update( conexoes.getId(), conexoes);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestParam("id") final Long id
    ){
        final ResponseEntity<?> comentario = this.service.findById(id);
        this.service.delete(id);
        return ResponseEntity.ok("Registro Excluido");
    }

}


