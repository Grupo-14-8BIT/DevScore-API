package com.bit.devScore.repositories;

import com.bit.devScore.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Postrepository extends JpaRepository <Post, Long> {

    public List<Post> findByNome (final String nome);
    @Query ("from Aluno where nome like :nome")
    public List<Post> findByNomeLike (@Param ("nome") final String nome);
    @Query (value = "select * from alunos where nome like :nome", nativeQuery = true)
    public List<Post> findByNomeLikeNative (@Param("nome") final String nome);

}
