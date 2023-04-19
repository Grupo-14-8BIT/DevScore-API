package br.com.DevScoreAPI.DevScoreAPI.repository;

import br.com.DevScoreAPI.DevScoreAPI.main.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Devrepository extends JpaRepository <Dev, Long> {

    public List<Dev> findByNome (final String nome);
    @Query ("from Aluno where nome like :nome")
    public List<Dev> findByNomeLike (@Param ("nome") final String nome);
    @Query (value = "select * from alunos where nome like :nome", nativeQuery = true)
    public List<Dev> findByNomeLikeNative (@Param("nome") final String nome);

}



