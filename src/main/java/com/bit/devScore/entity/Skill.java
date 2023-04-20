package com.bit.devScore.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "skill")
public class Skill {
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter @Setter
    @OneToMany
    @JoinColumn(name = "id_linguagem")
    private Linguagem Linguagens;

    @Getter @Setter
    @Column
    private long experiencia;
}