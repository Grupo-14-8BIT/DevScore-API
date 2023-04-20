package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Comentario {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 100)
    private Long id;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn( name =" id_comentario")
    private Comentario comentario;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="id_post")
    private Post post;
    @Getter
    @Setter
    @OneToMany
    @JoinColumn(name="id_user")
    private Desenvolvedor user;

    @Getter
    @Setter
    @Column
    private String texto;
    @Getter
    @Setter
    private LocalDateTime data;


    @Getter @Setter
    @OneToMany
    @JoinColumn(name="id_like")
    private Like like;
}