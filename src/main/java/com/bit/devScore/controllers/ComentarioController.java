package com.bit.devScore.controllers;

import com.bit.devScore.entity.Comentario;
import com.bit.devScore.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/comentario")
public class ComentarioController {
    @Autowired
private ComentarioRepository comentarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id")final long id){
        final Comentario comentario = this.comentarioRepository.findById(id).orElse(null);
        return  comentario == null
                ? ResponseEntity.badRequest().body("valor nao encontrado.")
                : ResponseEntity.ok(comentario);
    }


    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta(){
        return ResponseEntity.ok(this.comentarioRepository.findAll());
    }


    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody final Comentario comentario) {
        try {
            this.comentarioRepository.save(comentario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar marca.");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final Long id, @RequestBody final Comentario comentario) {
        if (id.equals(comentario.getId())) {
            this.comentarioRepository.save(comentario);
        } else {
            return ResponseEntity.badRequest().body("ID não encontrado !");
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso !!!");
    }

    @DeleteMapping
    public ResponseEntity<?> delete(
            @RequestParam("id") final Long id
    ){
        final Comentario comentario = this.comentarioRepository.findById(id).orElse(null);

        this.comentarioRepository.delete(comentario);
        return ResponseEntity.ok("Registro Excluido");
    }

}
