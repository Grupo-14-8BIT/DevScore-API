package com.bit.devScore.entity;

import java.util.List;
import com.bit.devScore.entity.Amigo;
import com.bit.devScore.entity.Conquista;
import com.bit.devScore.entity.Projeto;
import com.bit.devScore.entity.Skill;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "desenvolvedor", schema = "public")
public class Desenvolvedor {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Getter @Setter
    private boolean ativo;

    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Getter @Setter
    @Column(name = "nick", nullable = false, length = 100, unique = true)
    private String nick;

    @Getter @Setter
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Getter @Setter
    @Column(name = "senha", nullable = false)
    private String senha;
//
//    @Getter
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_skill")
//    private List<Skill> skills;
//
//    @Getter
//    @Column(name = "Profile_picture", nullable = true)
//    private String profile_imagem;
//
//    @Getter
//    @ManyToMany
//    @Column(name = "amigo")
//    private List<Amigo> amigo;
//
//    @Getter
//    @OneToMany
//    @JoinColumn(name = "conquista")
//    private List<Conquista> conquista;
//
//    @Getter
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @Column(name = "projeto", nullable = true)
//    private List<Projeto> projeto;

}
