package com.bit.devScore.services;

import com.bit.devScore.entity.Conquista;
import com.bit.devScore.repositories.ConquistaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;

@Service
public class ConquistaService {

    @Autowired
    private ConquistaRepository conquistaRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Conquista> conquistaOptional =conquistaRepository.findById(id);
        if (conquistaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("conquista inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(conquistaOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Conquista> veiculoes = conquistaRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }


    public ResponseEntity<?> create(Conquista dev) {



            try {
                conquistaRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Conquista conquista) {
        Optional<Conquista> optionalConquista = conquistaRepository.findById(id);
        if (optionalConquista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conquista not found with ID: " + id);
        } else {
            Conquista condutor = optionalConquista.get();
            BeanUtils.copyProperties(conquista, condutor);
            conquistaRepository.save(condutor);
            return ResponseEntity.ok().body("Conquista atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Conquista> optionalConquista = this.conquistaRepository.findById(id);

        if(optionalConquista.isPresent()) {
            Conquista veiculo = conquistaRepository.getById(optionalConquista.get().getId());
            this.conquistaRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
