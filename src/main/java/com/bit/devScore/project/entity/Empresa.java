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
    @Column(name = "id", nullable = false)
    private long Id;
    @Getter @Setter
    @Column(name = "name")
    private String nome;
    @Getter @Setter
    @Column(name = "descricao")
    private String Descricao;
//    @Getter @Setter
//    @ManyToMany
//    @Column(name = "amigos")
//    private Amigo amigos;
    @Setter @Getter
    @Column(name = "email")
    private String email;
    @Getter @Setter
    @Column(name = "login")
    private String login;
    @Getter @Setter
    @Column(name = "image")
    private String imagem;
//    @Getter @Setter
//    @ManyToMany
//    @Column(name = "comunidade")
//    private Comunidade comunidades;

}