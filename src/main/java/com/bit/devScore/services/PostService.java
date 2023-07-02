package com.bit.devScore.services;

import com.bit.devScore.entity.Post;
import com.bit.devScore.repositories.PostRepository;
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
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public ResponseEntity<?> findById (Long id) {
        Optional< Post> postOptional =postRepository.findById(id);
        if (postOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("post inexistente");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(postOptional.get());

        }
    }

    public ResponseEntity<?> findAll( ) {
        List<Post> veiculoes = postRepository.findAll();
        return  ResponseEntity.ok().body(veiculoes);
    }

    @Transactional
    public ResponseEntity<?> create(Post dev) {



            try {
                postRepository.save(dev);
                TransactionAspectSupport.currentTransactionStatus().flush();
                return ResponseEntity.status(HttpStatus.CREATED).body(dev);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
            }

    }

    public ResponseEntity<?> update(Long id, Post post) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found with ID: " + id);
        } else {
            Post condutor = optionalPost.get();
            BeanUtils.copyProperties(post, condutor);
            postRepository.save(condutor);
            return ResponseEntity.ok().body("Post atualizado com sucesso");
        }
    }


    public ResponseEntity<?> delete(Long id) {
        Optional<Post> optionalPost = this.postRepository.findById(id);

        if(optionalPost.isPresent()) {
            Post veiculo = postRepository.getById(optionalPost.get().getId());
            this.postRepository.delete(veiculo);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
