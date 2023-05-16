package com.bit.devScore.controllers;

import com.bit.devScore.entity.Comentario;
import com.bit.devScore.entity.Like;
import com.bit.devScore.repositories.LikeRepository;
import com.bit.devScore.services.DesenvolvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/Like")
public class LikeController {
    @Autowired
    private LikeRepository Like_repo;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id")final long id){
        final Comentario comentario = this.Like_repo.findById(id).orElse(null);
        return  comentario == null
                ? ResponseEntity.badRequest().body("valor nao encontrado.")
                : ResponseEntity.ok(comentario);
    }



}
