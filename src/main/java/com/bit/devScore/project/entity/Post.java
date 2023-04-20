package com.bit.devScore.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 100)
    private Long id;
    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private LocalDateTime data_post;
    @Getter @Setter
    private LocalDateTime data_atividade;
    @Getter @Setter
    private String imagem;
    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

}