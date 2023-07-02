package com.bit.devScore.services;

import com.bit.devScore.entity.Comunidade;
import com.bit.devScore.repositories.ComunidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;

@Service
public class ComunidadeService {

    @Autowired
    private ComunidadeRepository comunidadeRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Comunidade> comunidadeOptional =comunidadeRepository.findById(id);
        if (comunidadeOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("comunidade inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(comunidadeOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Comunidade> veiculoes = comunidadeRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }

    @Transactional
    public ResponseEntity<?> create(Comunidade dev) {



        try {
            comunidadeRepository.save(dev);
            TransactionAspectSupport.currentTransactionStatus().flush();
            return ResponseEntity.status(HttpStatus.CREATED).body(dev);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
        }

    }

    public ResponseEntity<?> update(Long id, Comunidade comunidade) {
        Optional<Comunidade> optionalComunidade = comunidadeRepository.findById(id);
        if (optionalComunidade.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comunidade not found with ID: " + id);
        } else {
            Comunidade condutor = optionalComunidade.get();
            BeanUtils.copyProperties(comunidade, condutor);
            comunidadeRepository.save(condutor);
            return ResponseEntity.ok().body("Comunidade atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Comunidade> optionalComunidade = this.comunidadeRepository.findById(id);

        if(optionalComunidade.isPresent()) {
            Comunidade veiculo = comunidadeRepository.getById(optionalComunidade.get().getId());
            this.comunidadeRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
