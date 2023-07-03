package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import  com.bit.devScore.entity.Desenvolvedor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "comunidade")
public class Comunidade {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter
    @Column(name = "decricao", nullable = false, length = 100)
    private String descricao;

    @Getter @Setter
    @OneToMany
    @JoinColumn(name = "projeto_id")
    private List<Projeto> projeto;

    @Getter @Setter
    @ManyToMany(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
    @Column(name = "membros")
    private List<Desenvolvedor> membros;

}
