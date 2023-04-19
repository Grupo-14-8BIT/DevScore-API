package br.com.DevScoreAPI.DevScoreAPI.repository;

import br.com.DevScoreAPI.DevScoreAPI.main.Projetos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Projectosrepository extends JpaRepository <Projetos, Long> {

    public List<Projetos> findByNome (final String nome);
    @Query ("from Aluno where nome like :nome")
    public List<Projetos> findByNomeLike (@Param ("nome") final String nome);
    @Query (value = "select * from alunos where nome like :nome", nativeQuery = true)
    public List<Projetos> findByNomeLikeNative (@Param("nome") final String nome);

}
