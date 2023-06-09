package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "conquista")
public class Conquista {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter
    @Column(name = "path", nullable = false)
    private String imagem;

    @Getter @Setter
    @Column(name = "n_conquista", nullable = false)
    private String nomeConquista;

    @Getter @Setter
    @Column(name = "descricao_conquista", nullable = false, length = 250)
    private String descricaoConquista;

}

