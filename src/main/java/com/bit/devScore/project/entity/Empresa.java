package com.bit.devScore.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "empresa")
public class Empresa {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Getter @Setter
    private String nome;
    @Getter @Setter
    private String Descricao;
//    @Getter @Setter
//    @ManyToMany
//    private Amigo amigos;
    @Setter @Getter
    private String email;
    @Getter @Setter
    private String login;
    @Getter @Setter
    private String imagem;
//    @Getter @Setter
//    @ManyToMany
//    private Comunidade comunidades;

}