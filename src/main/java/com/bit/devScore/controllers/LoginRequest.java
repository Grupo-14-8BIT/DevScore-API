package com.bit.devScore.controllers;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    @Getter @Setter
    private String email;

    @Getter @Setter
    private String senha;


}