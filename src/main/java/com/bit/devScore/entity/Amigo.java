package com.bit.devScore.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
<<<<<<< HEAD:src/main/java/com/bit/devScore/entity/Amigo.java
    @Getter
    @OneToMany
    @JoinColumn(name = "ami_id", nullable = true)
    private  List<Desenvolvedor> ami;
=======
    @Getter @Setter

    @ManyToMany
    @JoinColumn(name = "amigo_id", nullable = true)
    private List<Desenvolvedor> amigo;

>>>>>>> a8f45b37ff195478c37868133ed1a54dacfa2e06:src/main/java/com/bit/devScore/project/entity/Amigo.java
}
