package com.bit.devScore.repositories;

import com.bit.devScore.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpresaRepository extends JpaRepository <Empresa, Long> {


}