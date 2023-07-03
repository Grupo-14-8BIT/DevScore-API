package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "comentario")
public class Comentario {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter
    @ManyToOne(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
    @JoinColumn(name = " id_comentario", nullable = true)
    private Comentario comentario;

    @Getter @Setter
    @ManyToOne(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
    @JoinColumn(name = "id_post")
    private Post post;

    @Getter @Setter
    @OneToOne(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
    @JoinColumn(name = "id_autor")
    private Desenvolvedor user;

    @Getter @Setter
    @Column(name = "texto")
    private String texto;

    @Getter @Setter
    @Column(name = "data")
    private LocalDateTime data;

//    @Getter @Setter
//    @OneToMany(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
//    @Column(name = "id_like", nullable = false)
//    private List<Like> like;

}