package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "projeto")
public class Projeto {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

}
