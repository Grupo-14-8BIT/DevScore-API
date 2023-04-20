//package com.bit.devScore.project.repositories;
//
//import com.bit.devScore.project.entity.Amigo;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface Amigosrepository extends JpaRepository <Amigo, Long> {
//
//    public List<Amigo> findByNome (final String nome);
//    @Query ("from Aluno where nome like :nome")
//    public List<Amigo> findByNomeLike (@Param ("nome") final String nome);
//    @Query (value = "select * from alunos where nome like :nome", nativeQuery = true)
//    public List<Amigo> findByNomeLikeNative (@Param("nome") final String nome);
//
//}
//
