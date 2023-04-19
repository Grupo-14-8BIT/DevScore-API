package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Empresa {


    @Getter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Getter @Setter
    private String nome;
    @Getter @Setter
    private String Descricao;
    @Getter @Setter
    private List<Amigo> amigos;
    @Setter @Getter
    private String email;
    @Setter @Getter
    private List<Projeto> projetos;
    @Getter @Setter
    private String login;
    @Getter @Setter
    private String imagem;
    @Getter @Setter
    @ManyToMany()
    private List<Comunidade> comunidades;

}