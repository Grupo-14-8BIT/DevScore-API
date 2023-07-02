package com.bit.devScore.services;

import com.bit.devScore.entity.Comentario;
import com.bit.devScore.repositories.ComentarioRepository;
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
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Comentario> comentarioOptional =comentarioRepository.findById(id);
        if (comentarioOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("comentario inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(comentarioOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Comentario> veiculoes = comentarioRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }

    @Transactional
    public ResponseEntity<?> create(Comentario dev) {



            try {
                comentarioRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Comentario comentario) {
        Optional<Comentario> optionalComentario = comentarioRepository.findById(id);
        if (optionalComentario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentario not found with ID: " + id);
        } else {
            Comentario condutor = optionalComentario.get();
            BeanUtils.copyProperties(comentario, condutor);
            comentarioRepository.save(condutor);
            return ResponseEntity.ok().body("Comentario atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Comentario> optionalComentario = this.comentarioRepository.findById(id);

        if(optionalComentario.isPresent()) {
            Comentario veiculo = comentarioRepository.getById(optionalComentario.get().getId());
            this.comentarioRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
