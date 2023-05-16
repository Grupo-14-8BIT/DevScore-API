package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter
    @Column(name = "name")
    private String nome;

    @Getter @Setter
    @Column(name = "descricao")
    private String descricao;

    @Getter @Setter
    @Column(name = "data_post")
    private LocalDateTime data_post;

    @Getter @Setter
    @Column(name = "data_atividade")
    private LocalDateTime data_atividade;

    @Getter @Setter
    @Column(name = "image")
    private String imagem;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @Column(name = "comentario")
    private List<Comentario> comentarios;

}