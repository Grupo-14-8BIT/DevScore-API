package com.bit.devScore.project.repositories;

import com.bit.devScore.project.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Projectosrepository extends JpaRepository <Projeto, Long> {
//
//    public List<Projeto> findByNome ( @Param ("nome") final String nome);
//    @Query ("from Aluno where nome like :nome")
//    public List<Projeto> findByNomeLike (@Param ("nome") final String nome);
//    @Query (value = "select * from alunos where nome like :nome", nativeQuery = true)
//    public List<Projeto> findByNomeLikeNative (@Param("nome") final String nome);

}
