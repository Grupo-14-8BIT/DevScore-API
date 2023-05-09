package com.bit.devScore.project.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "comunidade")
public class Comunidade {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "decricao", nullable = false, length = 100)
    private String descricao;
    @OneToMany
    @JoinColumn(name = "projeto_id")
    private List<Projeto> projeto;
    @ManyToMany
    private List<Desenvolvedor> membros;

}
