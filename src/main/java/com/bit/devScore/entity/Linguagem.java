package com.bit.devScore.project.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "linguagem")
public class Linguagem {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Getter
    @Column(name = "nome", nullable = false)
    private String nome;
}
