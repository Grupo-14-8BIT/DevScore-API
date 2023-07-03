package com.bit.devScore.controllers;

import com.bit.devScore.entity.Like;
import com.bit.devScore.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/Like")
public class LikeController {
    @Autowired
    private LikeService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")final long id){
        return service.findById(id);
    }


    @GetMapping("/lista")
    public ResponseEntity<?> listAll(){
        return ResponseEntity.ok(this.service.findAll());
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody final Like like) {
        return service.create(like);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> uodate(@PathVariable final Long id, @RequestBody final Like like) {
        return this.service.update( like.getId(), like);
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


