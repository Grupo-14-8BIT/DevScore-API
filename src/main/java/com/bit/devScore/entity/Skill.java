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
    @ManyToOne
    private List<Linguagem> Linguagens;
    @Getter @Setter
    private long experiencia;
    @Getter @Setter
    private Projeto projeto;
}