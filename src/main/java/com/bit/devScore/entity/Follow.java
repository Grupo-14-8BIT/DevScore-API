package com.bit.devScore.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "follow")

public class Follow {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @Getter @Setter
//    @ManyToMany
//@Column(name = "desenvolvedor")
//    private Desenvolvedor desenvolvedor;

    @Getter @Setter
    @ManyToMany
    @Column(name = "empresa")
    private List<Empresa> empresa;
}