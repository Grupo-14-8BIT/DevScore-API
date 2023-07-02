package com.bit.devScore.services;

import com.bit.devScore.entity.Amigo;
import com.bit.devScore.repositories.AmigoRepository;
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
public class AmigoService {

    @Autowired
    private AmigoRepository amigoRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Amigo> amigoOptional =amigoRepository.findById(id);
        if (amigoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("amigo inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(amigoOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Amigo> veiculoes = amigoRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }

    @Transactional
    public ResponseEntity<?> create(Amigo dev) {



            try {
                amigoRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Amigo amigo) {
        Optional<Amigo> optionalAmigo = amigoRepository.findById(id);
        if (optionalAmigo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Amigo not found with ID: " + id);
        } else {
            Amigo condutor = optionalAmigo.get();
            BeanUtils.copyProperties(amigo, condutor);
            amigoRepository.save(condutor);
            return ResponseEntity.ok().body("Amigo atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Amigo> optionalAmigo = this.amigoRepository.findById(id);

        if(optionalAmigo.isPresent()) {
            Amigo veiculo = amigoRepository.getById(optionalAmigo.get().getId());
            this.amigoRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
