package com.bit.devScore.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "conexao")

public class Conexoes {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "desenvolvedor_id")
    private Desenvolvedor Desenvolvedor;
    @Getter @Setter
    @Column (name="link", nullable = false, unique = true)
    private String Endereco;
    @Enumerated(EnumType.STRING)
    @Column(name = "plataforma")
    private Plataforma plataforma;
}
