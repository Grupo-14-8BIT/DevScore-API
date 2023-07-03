package com.bit.devScore.services;

import com.bit.devScore.entity.Like;
import com.bit.devScore.repositories.LikeRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Like> likeOptional =likeRepository.findById(id);
        if (likeOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("like inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(likeOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Like> veiculoes = likeRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }


    public ResponseEntity<?> create(Like dev) {



            try {
                likeRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Like like) {
        Optional<Like> optionalLike = likeRepository.findById(id);
        if (optionalLike.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Like not found with ID: " + id);
        } else {
            Like condutor = optionalLike.get();
            BeanUtils.copyProperties(like, condutor);
            likeRepository.save(condutor);
            return ResponseEntity.ok().body("Like atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Like> optionalLike = this.likeRepository.findById(id);

        if(optionalLike.isPresent()) {
            Like veiculo = likeRepository.getById(optionalLike.get().getId());
            this.likeRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
