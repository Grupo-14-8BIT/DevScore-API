package com.bit.devScore.project.entity;

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
<<<<<<< HEAD
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_skill")
    private List<Skill> skills;
    @Getter
    @Column(name = "Profile_picture", nullable = true)
    private String profile_imagem;
    @Getter
    @ManyToMany
    @Column(name = "amigo")
    private List<Amigo> amigo;
    @Getter
    @OneToMany
    @JoinColumn(name = "conquista")
    private List<Conquista> conquista;
    @Getter
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)

    @Column(name = "projeto", nullable = true)
    private Projeto projeto;
=======
    @Column(name = "password", nullable = false, length = 30)
    private String senha;


//    @Getter
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_skill")
//    private Skill skills;
    @Getter
    @Column(name = "Profile_picture", nullable = true)
    private String profile_imagem;
//    @Getter
//    @ManyToMany
//    private Amigo amigo;
//    @Getter
//    @OneToMany
//    @JoinColumn(name = "conquista")
//    private Conquista conquista;
//    @Getter
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @Column(name = "projeto", nullable = true)
//    private Projeto projeto;
//    @Getter
//    @ManyToMany
//    private Comunidade comunidade;
>>>>>>> 451351a ( Desenvolvedor: controller, DTOS e services)

}
