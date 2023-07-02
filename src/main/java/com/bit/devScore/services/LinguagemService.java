package com.bit.devScore.services;

import com.bit.devScore.entity.Linguagem;
import com.bit.devScore.repositories.LinguagemRepository;
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
public class LinguagemService {

    @Autowired
    private LinguagemRepository linguagemRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Linguagem> linguagemOptional =linguagemRepository.findById(id);
        if (linguagemOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("linguagem inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(linguagemOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Linguagem> veiculoes = linguagemRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }

    @Transactional
    public ResponseEntity<?> create(Linguagem dev) {



            try {
                linguagemRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Linguagem linguagem) {
        Optional<Linguagem> optionalLinguagem = linguagemRepository.findById(id);
        if (optionalLinguagem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Linguagem not found with ID: " + id);
        } else {
            Linguagem condutor = optionalLinguagem.get();
            BeanUtils.copyProperties(linguagem, condutor);
            linguagemRepository.save(condutor);
            return ResponseEntity.ok().body("Linguagem atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Linguagem> optionalLinguagem = this.linguagemRepository.findById(id);

        if(optionalLinguagem.isPresent()) {
            Linguagem veiculo = linguagemRepository.getById(optionalLinguagem.get().getId());
            this.linguagemRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
