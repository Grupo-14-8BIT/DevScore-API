package br.com.DevScoreAPI.DevScoreAPI.repository;

import br.com.DevScoreAPI.DevScoreAPI.main.PublicConexoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PublicConexoesrepository extends JpaRepository <PublicConexoes, Long> {

    public List<PublicConexoes> findByNome (final String nome);
    @Query ("from Aluno where nome like :nome")
    public List<PublicConexoes> findByNomeLike (@Param ("nome") final String nome);
    @Query (value = "select * from alunos where nome like :nome", nativeQuery = true)
    public List<PublicConexoes> findByNomeLikeNative (@Param("nome") final String nome);

}