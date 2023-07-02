package com.bit.devScore.services;

import com.bit.devScore.entity.Projeto;
import com.bit.devScore.repositories.ProjetoRepository;
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
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Projeto> projetoOptional =projetoRepository.findById(id);
        if (projetoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("projeto inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(projetoOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Projeto> veiculoes = projetoRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }

    @Transactional
    public ResponseEntity<?> create(Projeto dev) {



            try {
                projetoRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Projeto projeto) {
        Optional<Projeto> optionalProjeto = projetoRepository.findById(id);
        if (optionalProjeto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto not found with ID: " + id);
        } else {
            Projeto condutor = optionalProjeto.get();
            BeanUtils.copyProperties(projeto, condutor);
            projetoRepository.save(condutor);
            return ResponseEntity.ok().body("Projeto atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Projeto> optionalProjeto = this.projetoRepository.findById(id);

        if(optionalProjeto.isPresent()) {
            Projeto veiculo = projetoRepository.getById(optionalProjeto.get().getId());
            this.projetoRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
