//package com.bit.devScore.services;
//
//import com.bit.devScore.entity.Comentario;
//import com.bit.devScore.entity.Desenvolvedor;
//import com.bit.devScore.repositories.ComentarioRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.interceptor.TransactionAspectSupport;
//
//import java.util.Optional;
//import java.util.List;
//
//@Service
//public class ComentarioServices {
//
//    @Autowired
//    private ComentarioRepository Comment_repo;
//
//    public ResponseEntity<?> findById (Long id) {
//        Optional<Comentario> commentOptional = Comment_repo.findById(id);
//        if (commentOptional.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("desenvolvedor inexistente");
//
//        } else {
//
//            return ResponseEntity.status(HttpStatus.OK).body(commentOptional.get());
//
//        }
//    }
//
//}
