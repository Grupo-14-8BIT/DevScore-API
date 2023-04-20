package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "amigo")
public class Amigo {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Getter
    @OneToMany
    @JoinColumn(name = "usr_id", nullable = true)
    private Desenvolvedor usr;
    @Getter
    @OneToMany
    @JoinColumn(name = "ami_id", nullable = true)
    private  Desenvolvedor ami;
}
