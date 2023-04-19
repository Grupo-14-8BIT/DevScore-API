package com.bit.devScore.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "desenvolvedor", schema = "public")
public class Desenvolvedor {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Getter
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Getter
    @Column(name = "nick", nullable = false, length = 100)
    private String nick;
    @Getter
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Getter
    @Column(name = "skill", nullable = false)
    private List<Skill> skills;
    @Getter
    @Column(name = "imagem", nullable = true)
    private String imagem;
    @Getter
    @OneToMany
    @Column(name = "amigo", nullable = true)
    private Amigo amigo;
    @Getter
    @OneToMany
    @Column(name = "conquista", nullable = true)
    private Conquista conquista;
    @Getter
    @OneToMany
    @Column(name = "projeto", nullable = true)
    private Projeto projeto;
    @Getter
    @ManyToMany
    @Column(name = "comunidade", nullable = true)
    private Comunidade comunidade;

}
