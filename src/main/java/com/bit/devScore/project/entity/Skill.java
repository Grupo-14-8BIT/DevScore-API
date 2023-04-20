package com.bit.devScore.project.entity;
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
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_linguagem")
    private Linguagem Linguagens;

    @Getter @Setter
    @Column(name= "experiencia")
    private long experiencia;
}