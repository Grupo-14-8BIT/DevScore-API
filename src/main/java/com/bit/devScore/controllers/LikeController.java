package com.bit.devScore.controllers;

import com.bit.devScore.entity.Like;
import com.bit.devScore.services.DesenvolvedorService;
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

public class Like {
    @Autowired
    private DesenvolvedorService service;

    

}
