package com.bit.devScore.entity;

import com.bit.devScore.entity.Desenvolvedor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL) spenas em delecao
    @OneToOne
    @JoinColumn(name = "id_desenvolvedor")
    private Desenvolvedor user;

    @Getter @Setter
    @Column(name = "data")
    private LocalDateTime data;

}