package com.bit.devScore.project.repositories;

import com.bit.devScore.project.entity.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

<<<<<<< HEAD
@Repository
public interface Devrepository extends JpaRepository <Desenvolvedor, Long> {
//
=======

@Repository
public interface Devrepository extends JpaRepository <Desenvolvedor, Long> {

    @Query("SELECT c FROM Desenvolvedor c WHERE c.email = :email")
    List<Desenvolvedor> findByEmail(@Param("email") String email);

}

>>>>>>> 451351a ( Desenvolvedor: controller, DTOS e services)
//    public List<Desenvolvedor> findByNome (final String nome);
//    @Query ("from Aluno where nome like :nome")
//    public List<Desenvolvedor> findByNomeLike (@Param ("nome") final String nome);
//    @Query (value = "select * from alunos where nome like :nome", nativeQuery = true)
//    public List<Desenvolvedor> findByNomeLikeNative (@Param("nome") final String nome);

<<<<<<< HEAD
}

=======


>>>>>>> 451351a ( Desenvolvedor: controller, DTOS e services)


