package com.bit.devScore.services;

import com.bit.devScore.entity.Empresa;
import com.bit.devScore.repositories.EmpresaRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Empresa> empresaOptional =empresaRepository.findById(id);
        if (empresaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("empresa inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(empresaOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Empresa> veiculoes = empresaRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }


    public ResponseEntity<?> create(Empresa dev) {



            try {
                empresaRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Empresa empresa) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        if (optionalEmpresa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa not found with ID: " + id);
        } else {
            Empresa condutor = optionalEmpresa.get();
            BeanUtils.copyProperties(empresa, condutor);
            empresaRepository.save(condutor);
            return ResponseEntity.ok().body("Empresa atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Empresa> optionalEmpresa = this.empresaRepository.findById(id);

        if(optionalEmpresa.isPresent()) {
            Empresa veiculo = empresaRepository.getById(optionalEmpresa.get().getId());
            this.empresaRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
