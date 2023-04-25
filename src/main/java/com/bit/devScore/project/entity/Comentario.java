package com.bit.devScore.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Comentario {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 100)
    private Long id;
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn( name =" id_replies")
    private List<Comentario> replies;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id_post")
    private Post post;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id_user")
    private Desenvolvedor user;

    @Getter @Setter
    @Column
    private String texto;

    @Getter @Setter
    private LocalDateTime data;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id_like")
    private List<Like> like;
}