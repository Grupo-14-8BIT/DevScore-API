package com.bit.devScore.services;

import com.bit.devScore.entity.Conexoes;
import com.bit.devScore.repositories.ConexoesRepository;
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
public class ConexoesService {

    @Autowired
    private ConexoesRepository conexoesRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Conexoes> conexoesOptional =conexoesRepository.findById(id);
        if (conexoesOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("conexoes inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(conexoesOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Conexoes> veiculoes = conexoesRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }

    @Transactional
    public ResponseEntity<?> create(Conexoes dev) {



            try {
                conexoesRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Conexoes conexoes) {
        Optional<Conexoes> optionalConexoes = conexoesRepository.findById(id);
        if (optionalConexoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conexoes not found with ID: " + id);
        } else {
            Conexoes condutor = optionalConexoes.get();
            BeanUtils.copyProperties(conexoes, condutor);
            conexoesRepository.save(condutor);
            return ResponseEntity.ok().body("Conexoes atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Conexoes> optionalConexoes = this.conexoesRepository.findById(id);

        if(optionalConexoes.isPresent()) {
            Conexoes veiculo = conexoesRepository.getById(optionalConexoes.get().getId());
            this.conexoesRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
