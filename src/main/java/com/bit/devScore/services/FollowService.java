package com.bit.devScore.services;

import com.bit.devScore.entity.Follow;
import com.bit.devScore.repositories.FollowRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Follow> followOptional =followRepository.findById(id);
        if (followOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("follow inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(followOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Follow> veiculoes = followRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }

    public ResponseEntity<?> create(Follow dev) {



            try {
                followRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Follow follow) {
        Optional<Follow> optionalFollow = followRepository.findById(id);
        if (optionalFollow.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Follow not found with ID: " + id);
        } else {
            Follow condutor = optionalFollow.get();
            BeanUtils.copyProperties(follow, condutor);
            followRepository.save(condutor);
            return ResponseEntity.ok().body("Follow atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Follow> optionalFollow = this.followRepository.findById(id);

        if(optionalFollow.isPresent()) {
            Follow veiculo = followRepository.getById(optionalFollow.get().getId());
            this.followRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
