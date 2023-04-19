package com.bit.devScore.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
public class Skill {
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Getter @Setter
    @ManyToOne
    private List<Linguagem> Linguagens;
    @Getter @Setter
    private long experiencia;
    @Getter @Setter
    private Projeto projeto;
}