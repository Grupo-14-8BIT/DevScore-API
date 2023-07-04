package com.bit.devScore.services;
import com.bit.devScore.entity.Conquista;
import com.bit.devScore.entity.Desenvolvedor;
import com.bit.devScore.repositories.Devrepository;
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
public class DesenvolvedorService {

    @Autowired
    private  Devrepository desenvolvedorRepository;

@Transactional
    public ResponseEntity<?> findById (Long id) {
        Optional< Desenvolvedor> desenvolvedorOptional =desenvolvedorRepository.findById(id);
        if (desenvolvedorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("desenvolvedor inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(desenvolvedorOptional.get());

        }
    }
    @Transactional
    public ResponseEntity<?> findAll( ) {
        List<Desenvolvedor> veiculoes = desenvolvedorRepository.findAll();
        return  ResponseEntity.ok(veiculoes);
    }

    @Transactional
    public ResponseEntity<?> create(Desenvolvedor dev) {

        if ( desenvolvedorRepository.findByEmail(dev.getEmail()).isEmpty() ) {

            try {
                dev.setAtivo(true);
                desenvolvedorRepository.save(dev);
//                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.ok(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("email ja cadastrado");
        }
    }
    @Transactional
    public ResponseEntity<?> update(Long id, Desenvolvedor desenvolvedor) {
        Optional<Desenvolvedor> optionalDesenvolvedor = desenvolvedorRepository.findById(id);
        if (optionalDesenvolvedor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Desenvolvedor not found with ID: " + id);
        } else {
            Desenvolvedor condutor = optionalDesenvolvedor.get();
            BeanUtils.copyProperties(desenvolvedor, condutor);
            desenvolvedorRepository.save(condutor);
            return ResponseEntity.ok().body("Desenvolvedor atualizado com sucesso");
        }
    }

    @Transactional
    public ResponseEntity<?> delete(Long id) {
        Optional<Desenvolvedor> optionalDesenvolvedor = this.desenvolvedorRepository.findById(id);

        if(optionalDesenvolvedor.isPresent()) {
            Desenvolvedor veiculo = desenvolvedorRepository.getById(optionalDesenvolvedor.get().getId());


                veiculo.setAtivo(false);
                this.desenvolvedorRepository.save(veiculo);
                return ResponseEntity.ok().build();
            }
     else {
            return ResponseEntity.notFound().build();
        }
    }
}
