//package com.bit.devScore.project.repositories;
//
//import com.bit.devScore.project.entity.Skill;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public interface Skillrepository extends JpaRepository <Skill, Long> {
//
//    public List<Skill> findByNome (final String nome);
//    @Query ("from Aluno where nome like :nome")
//    public List<Skill> findByNomeLike (@Param ("nome") final String nome);
//    @Query (value = "select * from alunos where nome like :nome", nativeQuery = true)
//    public List<Skill> findByNomeLikeNative (@Param("nome") final String nome);
//
//}