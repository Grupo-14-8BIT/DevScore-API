package com.bit.devScore.controllers;

import com.bit.devScore.entity.Desenvolvedor;
import com.bit.devScore.repositories.Devrepository;
import com.bit.devScore.services.DesenvolvedorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/desenvolvedor")
public class DesenvolvedorController {

    @Autowired
    private DesenvolvedorService service;
    @Autowired
    private Devrepository devrepository;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> findById(
            @PathVariable(value = "id") Long id
    ){
        return service.findById(id);
    };

    @GetMapping("/all")
    public ResponseEntity<?> listAll(){
        return ResponseEntity.ok(this.service.findAll());
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getSenha();

        Desenvolvedor user = devrepository.findByEmail(email);

        Boolean loginResponse;

        // Check if the user exists and the password is correct
        if (user != null && user.getSenha().equals(password)) {

             loginResponse = true;

            return ResponseEntity.ok(user);
        }

        loginResponse = false;

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
    }



    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> create( @RequestBody  Desenvolvedor desenvolvedorDTOS){
                Desenvolvedor desenvolvedor = new Desenvolvedor();
                BeanUtils.copyProperties(desenvolvedorDTOS, desenvolvedor);
                return service.create(desenvolvedor);
    };

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> update( @RequestBody  Desenvolvedor desenvolvedorDTOS){
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        BeanUtils.copyProperties(desenvolvedorDTOS, desenvolvedor);
        return service.create(desenvolvedor);
    };

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> delete(
            @PathVariable(value = "id") Long id
    ){
        return service.delete(id);
    };

















}