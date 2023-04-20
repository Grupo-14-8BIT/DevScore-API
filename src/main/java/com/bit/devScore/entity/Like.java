package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Like {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 100)
    private Long id;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_desenvolvedor")
    private Desenvolvedor user;

    @Getter @Setter
    private LocalDateTime data;
}