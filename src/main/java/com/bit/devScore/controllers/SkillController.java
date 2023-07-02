package com.bit.devScore.controllers;

import com.bit.devScore.entity.Skill;
import com.bit.devScore.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/Skill")
public class SkillController {
    @Autowired
    private SkillService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")final long id){
        return service.findById(id);
    }


    @GetMapping("/lista")
    public ResponseEntity<?> listAll(){
        return ResponseEntity.ok(this.service.findAll());
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody final Skill skill) {
        return service.create(skill);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> uodate(@PathVariable final Long id, @RequestBody final Skill skill) {
        return this.service.update( skill.getId(), skill);
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


