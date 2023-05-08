package com.bit.devScore.project.desenvolvedorRepositorys;

import com.bit.devScore.project.entity.Desenvolvedor;
import com.bit.devScore.project.repositories.Devrepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalTime;
import java.util.Optional;

@Service
public class DesenvolvedorService {

    @Autowired
    private     Devrepository desenvolvedorRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Desenvolvedor> desenvolvedorOptional =desenvolvedorRepository.findById(id);
        if (desenvolvedorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("desenvolvedor inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(desenvolvedorOptional.get());

        }
    }

    @Transactional
    public ResponseEntity<?> create(Desenvolvedor dev) {

        if ( desenvolvedorRepository.findByEmail(dev.getEmail()).isEmpty() ) {


            try {
                //dev.setAtivo(true);
                desenvolvedorRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.toString());
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("email ja cadastrado");
        }
    }








}
