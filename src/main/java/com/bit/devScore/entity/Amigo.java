package com.bit.devScore.entity;

import com.bit.devScore.entity.Desenvolvedor;
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

    @Setter @Getter
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "usr_id", nullable = true)
    private List<Desenvolvedor> usr;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "amigo_id", nullable = true)
    private List<Desenvolvedor> amigo;

}
