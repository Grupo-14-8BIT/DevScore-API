package com.bit.devScore.controllers;

import com.bit.devScore.entity.Comentario;
import com.bit.devScore.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/Comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")final long id){
        return service.findById(id);
    }


    @GetMapping("/lista")
    public ResponseEntity<?> listAll(){
        return ResponseEntity.ok(this.service.findAll());
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody final Comentario comentario) {
        return service.create(comentario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> uodate(@PathVariable final Long id, @RequestBody final Comentario comentario) {
        return this.service.update( comentario.getId(), comentario);
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


