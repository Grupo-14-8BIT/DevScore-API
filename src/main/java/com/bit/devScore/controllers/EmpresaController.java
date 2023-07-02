package com.bit.devScore.controllers;

import com.bit.devScore.entity.Empresa;
import com.bit.devScore.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/Empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")final long id){
        return service.findById(id);
    }


    @GetMapping("/lista")
    public ResponseEntity<?> listAll(){
        return ResponseEntity.ok(this.service.findAll());
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody final Empresa empresa) {
        return service.create(empresa);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> uodate(@PathVariable final Long id, @RequestBody final Empresa empresa) {
        return this.service.update( empresa.getId(), empresa);
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


