package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "comunidade")
public class Comunidade {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 100)
    private Long id;
    @Column(name = "decricao", nullable = false, length = 100)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    @Column(name = "projeto_id", nullable = false, length = 100)
    private Projeto projeto;
    @ManyToOne
    @JoinColumn(name = "dev_id")
    @Column(name = "dev_id", nullable = false, length = 100)
    private Desenvolvedor desenvolvedor;

}
