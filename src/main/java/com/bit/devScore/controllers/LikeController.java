package com.bit.devScore.controllers;

import com.bit.devScore.entity.Like;
import com.bit.devScore.repositories.LikeRepository;
import com.bit.devScore.services.DesenvolvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/Like")
public class LikeController {
    @Autowired
    private LikeRepository Like_repo;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@RequestParam("id")final long id){
        final Like m_like = this.Like_repo.findById(id).orElse(null);
        return  m_like == null
                ? ResponseEntity.badRequest().body("valor nao encontrado.")
                : ResponseEntity.ok(m_like);
    }
@GetMapping("/findAll")
public ResponseEntity<?> findAll() {

    try {

        List<?> likes = Like_repo.findAll();
        return new ResponseEntity<>(likes, HttpStatus.OK);

    } catch (Exception e) {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}


}
