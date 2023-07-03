package com.bit.devScore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "desenvolvedor", schema = "public")
public class Desenvolvedor {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    //dtos
    private Long id;
    @Getter @Setter
    private boolean ativo;

    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 100)
    //dtos
    private String nome;

    @Getter @Setter
    @Column(name = "nick", nullable = false, length = 100, unique = true)
    //dtos
    private String nick;

    @Getter @Setter
    @Column(name = "email", nullable = false, length = 100, unique = true)
    //dtos
    private String email;

    @Getter @Setter
    @Column(name = "senha", nullable = false)
    //dtos
    private String senha;

    @Getter
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_skill")
    private List<Skill> skills;

    @Getter @Setter
    @Column(name = "Profile_picture", nullable = true)
    private String profile_imagem;
//
    @Setter @Getter
    @ManyToMany(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
    @Column(name = "amigo")
    private List<Amigo> amigo;
//
    @Getter @Setter
    @ManyToMany(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
    @JoinColumn(name = "conquista")
    private List<Conquista> conquista;
    @Getter @Setter
    @OneToMany(/*fetch = FetchType.LAZY,cascade = CascadeType.ALL*/)
    @Column(name = "projeto", nullable = true)
    private List<Projeto> projeto;

    // add skill
    //delete skill
    //adicionar amigo
    //excluir amigo
    //adicionar projeto
    //excluir projeto

}
