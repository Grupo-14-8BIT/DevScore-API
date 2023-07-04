package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "projeto")
public class Projeto {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter
    @Column(name ="link_projeto")
    private String link;

    @Getter @Setter
    @Column(name ="nome")
    private String nome;

    @Getter @Setter
    @Column(name="descricao")
    private String descricao;


    @Getter @Setter
    @OneToMany
    @JoinColumn(name="Linguagem")
    private List<Linguagem> linguagens;


    @Getter @Setter
    @Column(name="data_postagem")
    private LocalDateTime dataPostagem;

    @Getter @Setter
    @OneToMany(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
    @JoinColumn(name="comentario_id")
    private List<Comentario> comentarios;

    @Getter @Setter
    @OneToMany(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
    @JoinColumn(name="id_like")
    private List<Like> likes;

}
