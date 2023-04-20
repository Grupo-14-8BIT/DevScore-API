package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class Conexoes {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Getter @Setter
    @OneToMany
    @JoinColumn(name = "desenvolvedor_id")
    private Desenvolvedor Desenvolvedor;

    @Getter @Setter
    @Column (  name="link", nullable = false, unique = true)
    private String Endereco;

    @Enumerated(EnumType.STRING)
    private Plataforma plataforma;
}
