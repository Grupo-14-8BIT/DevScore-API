package br.com.DevScoreAPI.DevScoreAPI.repository;

import br.com.DevScoreAPI.DevScoreAPI.main.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Skillrepository extends JpaRepository <Skills, Long> {

    public List<Skills> findByNome (final String nome);
    @Query ("from Aluno where nome like :nome")
    public List<Skills> findByNomeLike (@Param ("nome") final String nome);
    @Query (value = "select * from alunos where nome like :nome", nativeQuery = true)
    public List<Skills> findByNomeLikeNative (@Param("nome") final String nome);

}