package com.bit.devScore.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "amigo")
public class Amigo {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Getter
    @ManyToMany
    @JoinColumn(name = "usr_id", nullable = true)
    private List<Desenvolvedor> usr;
    @Getter @Setter
    @ManyToMany
    @JoinColumn(name = "amigo_id", nullable = true)
    private List<Desenvolvedor> amigo;
}
