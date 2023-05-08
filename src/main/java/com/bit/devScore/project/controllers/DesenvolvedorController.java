package com.bit.devScore.project.controllers;

import com.bit.devScore.project.DTOS.DesenvolvedorDTOS;
import com.bit.devScore.project.entity.Desenvolvedor;
import com.bit.devScore.project.exeption.NotFoundException;
import com.bit.devScore.project.repositories.Devrepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/desenvolvedor")
public class DesenvolvedorController {

    @Autowired
    private com.bit.devScore.project.desenvolvedorRepositorys.DesenvolvedorService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )

    public ResponseEntity<?> findById(
            @PathVariable(value = "id") Long id
    ){
        return service.findById(id);
    };

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//
//    public ResponseEntity<?> findAll( ){
//        return service.findAll();
//    };
//
//    @RequestMapping(value = "/ativos", method = RequestMethod.GET)
//    public ResponseEntity<?> findAtivo( ){
//        return service.findAtivo();
//    };


    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DesenvolvedorDTOS desenvolvedorDTOS){
        Desenvolvedor desenvolvedor = new Desenvolvedor() ;
        BeanUtils.copyProperties(desenvolvedorDTOS,desenvolvedor);

        return service.create(desenvolvedor);
    }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateEntity(@PathVariable Long id, @RequestBody  @Valid Desenvolvedor desenvolvedorDTOS) {
//
//        return service.update(id, desenvolvedorDTOS);
//    }



//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deletar(@PathVariable Long id) {
//        return  service.delete(id);
//    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException (MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldname = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldname, errorMessage);
        });

        return errors;
    };

    @ExceptionHandler(com.bit.devScore.project.exeption.DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleDuplicateKeyException(DuplicateKeyException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }


}