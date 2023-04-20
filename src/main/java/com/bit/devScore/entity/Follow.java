package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Follow {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 100)
    private Long id;

    @Getter @Setter
    @ManyToMany
    private Desenvolvedor desenvolvedor;

    @Getter @Setter
    @ManyToMany
    private Empresa empresa;
}