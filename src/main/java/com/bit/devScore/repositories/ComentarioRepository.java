package com.bit.devScore.repositories;

import com.bit.devScore.entity.Comentario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {


    public List<Comentario> findByNome(final String nome);

    @Query("from Aluno where nome like :nome")
    public List<Comentario> findByNomeLike(@Param("nome") final String nome);

    @Query(value = "select * from alunos where nome like :nome", nativeQuery = true)
    public List<Comentario> findByNomeLikeNative(@Param("nome") final String nome);


}